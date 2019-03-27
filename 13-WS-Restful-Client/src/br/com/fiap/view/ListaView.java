package br.com.fiap.view;

import java.util.List;

import br.com.fiap.repository.ReservaRepository;
import br.com.fiap.to.Reserva;

public class ListaView {

	public static void main(String[] args) {
		//Chamar o webservice e exibir as reservas cadastradas
		ReservaRepository rep = new ReservaRepository();
		
		try {
			List<Reserva> listar = rep.listar();
			
			for (Reserva reserva : listar) {
				System.out.println(reserva.getCliente());
				System.out.println(reserva.getPreco());
				System.out.println("----------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}