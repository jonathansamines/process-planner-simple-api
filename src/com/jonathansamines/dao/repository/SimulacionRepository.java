package com.jonathansamines.dao.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.util.ArrayList;
import com.jonathansamines.dao.ConnectionManager;
import com.jonathansamines.models.Simulacion;
import com.jonathansamines.models.Proceso;
import com.jonathansamines.models.PlanificacionProceso;

public class SimulacionRepository implements IRepository<Simulacion> {
	
	private ResultSet createSimulacion(Connection connection, Simulacion simulacion) throws SQLException {
		String generatedColumns[] = { "id_simulacion" };
		String SQLInsertSimulacion = "INSERT INTO simulacion (algoritmo, fecha_simulacion, quantum, tiempo_total) VALUES (?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(SQLInsertSimulacion, generatedColumns);
		statement.setString(1, simulacion.getAlgoritmo());
		statement.setDate(2, new Date(simulacion.getFechaSimulacion().getTime()));
		statement.setLong(3, simulacion.getQuantum());
		statement.setLong(4, simulacion.getTiempoTotal());
		
		statement.executeUpdate();
		
		return statement.getGeneratedKeys();
	}
	
	private ResultSet createProceso(Connection connection, int simulacionId, Proceso proceso) throws SQLException {
		String generatedColumnsProcess[] = { "id_proceso" };
		String SQLInsertProceso = "INSERT INTO proceso (nombre_proceso, tiempo_inicial, tiempo_ejecucion, tiempo_finalizacion, tiempo_servicio, tiempo_espera, uso_cpu_porcentual, id_simulacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement = connection.prepareStatement(SQLInsertProceso, generatedColumnsProcess);
		statement.setString(1, proceso.getNombreProceso());
		statement.setLong(2, proceso.getTiempoInicial());
		statement.setLong(3, proceso.getTiempoEjecucion());
		statement.setLong(4, proceso.getTiempoFinalizacion());
		statement.setLong(5, proceso.getTiempoServicio());
		statement.setLong(6, proceso.getTiempoEspera());
		statement.setFloat(7, proceso.getUsoCpuPorcentual());
		statement.setInt(8, simulacionId);
		
		statement.executeUpdate();

		return statement.getGeneratedKeys();
	}
	
	private ResultSet createPlanificacionProceso(Connection connection, int idProceso, PlanificacionProceso plan) throws SQLException {
		String generatedColumns[] = { "id_planificacion" };
		String SQLInsertPlanificacion = "INSERT INTO planificacionproceso (id_proceso, unidades_ejecucion, unidades_espera, tiempo_finalizacion) VALUES (?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(SQLInsertPlanificacion, generatedColumns);

		statement.setInt(1, idProceso);
		statement.setString(2, plan.getUnidadesEjecucion());
		statement.setString(3, plan.getUnidadesEspera());
		statement.setLong(4, plan.getTiempoFinalizacion());
		
		statement.executeUpdate();

		return statement.getGeneratedKeys();
	}
	
	@Override
	public boolean create(Simulacion simulacion) {
		try (Connection connection = ConnectionManager.getConnection()) {
			// Deshabilitar autocommit, para hacer que este metodo sea transaccional
			connection.setAutoCommit(false);

			// creating simulacion object
			ResultSet simulacionSet = this.createSimulacion(connection, simulacion);
					
			if (simulacionSet.next()) {
				simulacion.setIdSimulacion(simulacionSet.getInt(1));
				
				// Crear un registro (proceso, planificacion_proceso) por cada proceso
				for (Proceso proceso : simulacion.getListaProcesos()) {
					proceso.setIdSimulacion(simulacion.getIdSimulacion());
					PlanificacionProceso plan = proceso.getPlanificacion();
					
					ResultSet procesoSet = this.createProceso(connection, simulacion.getIdSimulacion(), proceso);
					
					if (procesoSet.next()) {
						proceso.setIdProceso(procesoSet.getInt(1));
						plan.setIdProceso(proceso.getIdProceso());
						
						ResultSet planSet = this.createPlanificacionProceso(connection, proceso.getIdProceso(), plan);
						
						if (planSet.next()) {
							plan.setIdPlanificacionProceso(planSet.getInt(1));
						}
					}
				}
			}
			
			// Confirmar todas las operaciones, como una única unidad
			connection.commit();
			
			// Se restaura el valor al original
			connection.setAutoCommit(true);			
			
			// Se asume que si le llega a este punto, todo resulto correctamente
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			
			// En caso de haber una excepción se marca como un error
			return false;
		}
	}

	@Override
	public ArrayList<Simulacion> get() {
		return null;
	}

	@Override
	public Simulacion getById(int id) {
		return null;
	}

	@Override
	public boolean update(Simulacion o) {
		return false;
	}
}
