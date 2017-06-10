package com.jonathansamines.models;

import java.util.ArrayList;
import java.util.Date;

public class Simulacion {	
	private int idSimulacion;
	private Date fechaSimulacion;
	private String algoritmo;
	private int quantum;
	private long tiempoTotal;
	private ArrayList<Proceso> listaProcesos;
	
	public Simulacion() {
		this.listaProcesos = new ArrayList<Proceso>();
	}

	public Simulacion(int idSimulacion, Date fechaSimulacion, String algoritmo, int quantum, long tiempoTotal) {
		super();
		this.idSimulacion = idSimulacion;
		this.fechaSimulacion = fechaSimulacion;
		this.algoritmo = algoritmo;
		this.quantum = quantum;
		this.tiempoTotal = tiempoTotal;
		this.listaProcesos = new ArrayList<Proceso>();
	}

	public int getIdSimulacion() {
		return idSimulacion;
	}

	public void setIdSimulacion(int idSimulacion) {
		this.idSimulacion = idSimulacion;
	}

	public Date getFechaSimulacion() {
		return fechaSimulacion;
	}

	public void setFechaSimulacion(Date fechaSimulacion) {
		this.fechaSimulacion = fechaSimulacion;
	}

	public String getAlgoritmo() {
		return algoritmo;
	}

	public void setAlgoritmo(String algoritmo) {
		this.algoritmo = algoritmo;
	}

	public int getQuantum() {
		return quantum;
	}

	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}

	public long getTiempoTotal() {
		return tiempoTotal;
	}

	public void setTiempoTotal(long tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}

	public ArrayList<Proceso> getListaProcesos() {
		return listaProcesos;
	}

	public void setListaProcesos(ArrayList<Proceso> listaProcesos) {
		this.listaProcesos = listaProcesos;
	}
}
