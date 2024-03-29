package com.venta.pasajes.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.venta.pasajes.model.Asiento;
import com.venta.pasajes.model.Viaje;
import com.venta.pasajes.model.listas.FilaAsiento;
import com.venta.pasajes.service.AsientoService;
import com.venta.pasajes.util.Constantes;


@Path("/asiento")
public class AsientoRestController {

	@Autowired
	private AsientoService asientoService;
	
	@Path("/dist/{idViaje}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public String getFilaAsientos(@PathParam("idViaje") int idViaje){
		
		Viaje viaje = new Viaje();
		viaje.setIdViaje(idViaje);
		
		List<FilaAsiento> filaAsientos = asientoService.getFilaAsientos(viaje);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat(Constantes.FORMATO_FECHA).create();
		String jsonAsientos= gson.toJson(filaAsientos);
		return jsonAsientos;
	}
	
	@Path("/lista/{idViaje}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public String getAsientos(@PathParam("idViaje") int idViaje){
		
		Viaje viaje = new Viaje();
		viaje.setIdViaje(idViaje);
		
		List<Asiento> asientos = asientoService.getAsientos(viaje);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat(Constantes.FORMATO_FECHA).create();
		String jsonAsientos= gson.toJson(asientos);
		return jsonAsientos;
	}
	
	@Path("/{idAsiento}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public String buscarAsiento(@PathParam("idAsiento") int idAsiento){
		Asiento asiento = asientoService.buscarAsiento(idAsiento);
		Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat(Constantes.FORMATO_FECHA).create();
		String jsonAsiento = gson.toJson(asiento);
		return jsonAsiento;
	} 


}

