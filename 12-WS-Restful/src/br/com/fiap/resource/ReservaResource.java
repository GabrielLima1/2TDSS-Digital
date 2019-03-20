package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.entity.Reserva;
import br.com.fiap.exception.ChaveInexistenteException;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

//http://localhost:8080/12-WS-Restful/rest/reserva/1
@Path("/reserva")
public class ReservaResource {

	private ReservaDAO dao;
	
	public ReservaResource() {
		EntityManagerFactory fabrica = 
				EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		dao = new ReservaDAOImpl(em);
	}
	
	@DELETE
	@Path("{id}")
	public void remover(@PathParam("id") int codigo) {
		
		try {
			dao.remover(codigo);
			dao.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new InternalServerErrorException(); //Erro 500
			//return Response.serverError().build();
		}
		//return Response.noContent().build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int codigo, 
			Reserva reserva) {
		
		try {
			reserva.setCodigo(codigo);
			dao.atualizar(reserva);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build(); //Erro 500
		}
		
		return Response.ok().build(); //200 OK
	}
	
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reserva buscar(@PathParam("id") int codigo) {
		try {
			return dao.consultar(codigo);
		} catch (ChaveInexistenteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Reserva reserva, @Context UriInfo uri) {
		
		try {
			dao.cadastrar(reserva);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build(); //Erro 500
		}
		//Construir a URL para acessar o recurso (reserva) cadastrada
		UriBuilder builder = uri.getAbsolutePathBuilder();
		//adicionar o código da reserva na URL
		builder.path(Integer.toString(reserva.getCodigo()));
		
		return Response.created(builder.build()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reserva> buscar() {
		return dao.listar();
	}
	
}
