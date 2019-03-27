package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import br.com.fiap.to.Reserva;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ReservaRepository {
	
	private Client client = Client.create();
	
	private static final String URL = "http://localhost:8080/12-WS-Restful/rest/reserva/";
	
	public void remover(int codigo) throws Exception {
		
		WebResource resource = client.resource(URL + codigo);
		
		ClientResponse resp = resource.delete(ClientResponse.class);
		
		if (resp.getStatus() != 204) {
			throw new Exception();
		}
		
	}
	
	public void atualizar(Reserva reserva) throws Exception {
		
		WebResource resource = 
				client.resource(URL + reserva.getCodigo());
		
		ClientResponse resp = resource
			.type(MediaType.APPLICATION_JSON)
			.put(ClientResponse.class, reserva);
		
		if (resp.getStatus() != 200) {
			throw new Exception();
		}
		
	}
	
	public void cadastrar(Reserva reserva) throws Exception {
		
		WebResource resource = client.resource(URL);
		
		ClientResponse resp = resource
				.type(MediaType.APPLICATION_JSON)
						.post(ClientResponse.class, reserva);
		
		if (resp.getStatus() != 201) {
			throw new Exception();
		}
		
	}
	
	public Reserva pesquisar(int codigo) throws Exception {
		
		WebResource resource = client.resource(URL + codigo);
		
		ClientResponse response = resource.accept(MediaType
				.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new Exception();
		}
		return response.getEntity(Reserva.class);
	}

	public List<Reserva> listar() throws Exception{
		
		WebResource resource = client.resource(URL);
		
		//Chamar o webservice
		ClientResponse response = resource
				.accept(MediaType.APPLICATION_JSON)
									.get(ClientResponse.class);
		
		//Validar o status code do HTTP
		if (response.getStatus() != 200) {
			throw new Exception();
		}
		
		//Recuperar as reservas do response
		Reserva[] vetor = response.getEntity(Reserva[].class);
		return Arrays.asList(vetor); //transformar o vetor em list
	}
	
}
