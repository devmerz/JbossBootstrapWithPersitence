/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jboss.as.quickstarts.rshelloworld;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.as.quickstarts.rshelloworld.dez.Producto;
import org.jboss.entidades.Test2;

/**
 *
 * @author devmerz
 */

@Path("/modulo")
public class ElmerService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/saludame")
    public Response getName(){
        
        Producto pro = new Producto();
        pro.setName("Coca Cola");
        pro.setValor(1);
        return Response.status(200).entity(pro).build();
    }
    
    @POST
    @Path("/doy")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getName(Producto pro){
        
        System.out.println("Nombre" +pro.getName());
        System.out.println("Valor" + pro.getValor());
        
        
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "org.jboss.quickstarts.eap_jboss-helloworld-rs_war_7.0.0-SNAPSHOTPU" );

        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.getTransaction( ).begin( );

        Test2 t2 = new Test2();
        t2.setIdTest2(1);
        t2.setNombre("Elmer" + Math.random());

        entitymanager.persist( t2 );
        entitymanager.getTransaction( ).commit( );

        entitymanager.close( );
        emfactory.close( );
      
        return Response.status(200).entity(pro).build();
    }
}
