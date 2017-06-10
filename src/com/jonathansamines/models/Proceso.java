package com.jonathansamines.models;

public class Proceso {
	private int idProceso;
	private String nombreProceso;
	private long tiempoInicial;
	private long tiempoEjecucion;
	private long tiempoFinalizacion;
	private long tiempoServicio;
	private long tiempoEspera;
	private float usoCpuPorcentual;
	private int idSimulacion;
	private PlanificacionProceso planificacion;
	
	public Proceso() {}
	public Proceso(int idProceso, String nombreProceso, long tiempoEjecucion, long tiempoFinalizacion,
			long tiempoServicio, long tiempoEspera, float usoCPUPorcentual, int idSimulacion) {
		super();
		this.idProceso = idProceso;
		this.nombreProceso = nombreProceso;
		this.tiempoEjecucion = tiempoEjecucion;
		this.tiempoFinalizacion = tiempoFinalizacion;
		this.tiempoServicio = tiempoServicio;
		this.tiempoEspera = tiempoEspera;
		this.usoCpuPorcentual = usoCPUPorcentual;
		this.idSimulacion = idSimulacion;
	}

	public int getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}

	public String getNombreProceso() {
		return nombreProceso;
	}

	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}

	public long getTiempoEjecucion() {
		return tiempoEjecucion;
	}

	public void setTiempoEjecucion(long tiempoEjecucion) {
		this.tiempoEjecucion = tiempoEjecucion;
	}

	public long getTiempoFinalizacion() {
		return tiempoFinalizacion;
	}

	public void setTiempoFinalizacion(long tiempoFinalizacion) {
		this.tiempoFinalizacion = tiempoFinalizacion;
	}

	public long getTiempoServicio() {
		return tiempoServicio;
	}

	public void setTiempoServicio(long tiempoServicio) {
		this.tiempoServicio = tiempoServicio;
	}

	public long getTiempoEspera() {
		return tiempoEspera;
	}

	public void setTiempoEspera(long tiempoEspera) {
		this.tiempoEspera = tiempoEspera;
	}

	public float getUsoCpuPorcentual() {
		return usoCpuPorcentual;
	}

	public void setUsoCpuPorcentual(float usoCPUPorcentual) {
		this.usoCpuPorcentual = usoCPUPorcentual;
	}

	public int getIdSimulacion() {
		return idSimulacion;
	}

	public void setIdSimulacion(int idSimulacion) {
		this.idSimulacion = idSimulacion;
	}

	public long getTiempoInicial() {
		return tiempoInicial;
	}

	public void setTiempoInicial(long tiempoInicial) {
		this.tiempoInicial = tiempoInicial;
	}

	public PlanificacionProceso getPlanificacion() {
		return planificacion;
	}

	public void agregarDetallePlanificacion(PlanificacionProceso planificacion) {
		this.planificacion = planificacion;
	}
}
