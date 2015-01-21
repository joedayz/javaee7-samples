/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upc.laboro;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author pcsijdia
 */
@Path("/ofertas")
public class OfertasResource {
    
   
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Oferta> findAll(){
        
        return cargarLista();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Oferta findById(@PathParam("id") String id){
        List<Oferta> ofertas = cargarLista();
        for(Oferta of:  ofertas){
            if(of.getId() == Integer.parseInt(id)){
                return of;
            }
        }
        return null;
    }
    
    private List<Oferta> cargarLista(){
        List<Oferta> ofertas = new ArrayList<Oferta>();
        Oferta oferta1 = new Oferta();
        oferta1.setId(1);
        oferta1.setTitulo("Se Busca Analista Comercial");
        oferta1.setDescripcion("Experiencia de 3 años en "
                + "entidad financieras....");
        
        Oferta oferta2 = new Oferta();
        oferta2.setId(2);
        oferta2.setTitulo("Se Busca Ejecutivo de cuenta");
        oferta2.setDescripcion("Experiencia de 3 años en "
                + "ventas....");  
        ofertas.add(oferta1);
        ofertas.add(oferta2);
        return ofertas;
    }

}

