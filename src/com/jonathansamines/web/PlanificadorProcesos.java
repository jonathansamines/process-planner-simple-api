package com.jonathansamines.web;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jonathansamines.dao.repository.SimulacionRepository;
import com.jonathansamines.models.Simulacion;

/**
 * Servlet implementation class PlanificadorProcesos
 */
@WebServlet("/planificar")
public class PlanificadorProcesos extends HttpServlet {
	private final String contentType = "application/json";
	private SimulacionRepository repository;
	private Gson serializer;

	private static final long serialVersionUID = 1L;

    public PlanificadorProcesos() {
        super();
        this.repository = new SimulacionRepository();
        this.serializer = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }
    
    private String getRequestString(BufferedReader stream) throws IOException {
    	StringBuilder builder = new StringBuilder();
    	String string;

        while ((string = stream.readLine()) != null) {
            builder.append(string);
        }
        
        return builder.toString();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonString = this.getRequestString(request.getReader());
		Simulacion simulacion = this.serializer.fromJson(jsonString, Simulacion.class);
		boolean wasCreated = this.repository.create(simulacion);
		
		if (wasCreated) {
			response.setStatus(200);
			response.setContentType(this.contentType);
			response.getOutputStream().print(this.serializer.toJson(simulacion));			
		} else {
			response.setStatus(500);
			response.setContentType(this.contentType);
		}
	
	}
}
