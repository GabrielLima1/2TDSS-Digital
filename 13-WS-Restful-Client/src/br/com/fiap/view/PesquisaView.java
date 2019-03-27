package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.repository.ReservaRepository;
import br.com.fiap.to.Reserva;

public class PesquisaView {

	public static void main(String[] args) {
		//Ler um código e pesquisar no web service
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Código: ");
		int codigo = sc.nextInt();
		
		ReservaRepository rep = new ReservaRepository();
		
		try {
			Reserva reserva = rep.pesquisar(codigo);
			System.out.println(reserva.getCliente());
			System.out.println(reserva.getPreco());
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
	
}
