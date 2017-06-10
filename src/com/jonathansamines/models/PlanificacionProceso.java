package com.jonathansamines.models;

public class PlanificacionProceso {
	private int idPlanificacionProceso;
	private int idProceso;
	private String unidadesEjecucion;
	private String unidadesEspera;
	private long tiempoFinalizacion;

	public PlanificacionProceso() {}
	public PlanificacionProceso(int idPlanificacionProceso, int idProceso, String unidadesEjecucion,
			String unidadesEspera, long tiempoFinalizacion) {
		super();
		this.idPlanificacionProceso = idPlanificacionProceso;
		this.idProceso = idProceso;
		this.unidadesEjecucion = unidadesEjecucion;
		this.unidadesEspera = unidadesEspera;
		this.tiempoFinalizacion = tiempoFinalizacion;
	}

	public int getIdPlanificacionProceso() {
		return idPlanificacionProceso;
	}

	public void setIdPlanificacionProceso(int idPlanificacionProceso) {
		this.idPlanificacionProceso = idPlanificacionProceso;
	}

	public int getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}

	public String getUnidadesEjecucion() {
		return unidadesEjecucion;
	}

	public void setUnidadesEjecucion(String unidadesEjecucion) {
		this.unidadesEjecucion = unidadesEjecucion;
	}

	public String getUnidadesEspera() {
		return unidadesEspera;
	}

	public void setUnidadesEspera(String unidadesEspera) {
		this.unidadesEspera = unidadesEspera;
	}

	public long getTiempoFinalizacion() {
		return tiempoFinalizacion;
	}

	public void setTiempoFinalizacion(long tiempoFinalizacion) {
		this.tiempoFinalizacion = tiempoFinalizacion;
	}
}
