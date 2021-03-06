package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.repository.ReservaRepository;
import br.com.fiap.to.Reserva;

public class CadastroView {

	public static void main(String[] args) {
		//Cadastrar uma nova reserva
		Scanner sc = new Scanner(System.in);
		
		//Ler os dados
		System.out.print("Cliente: ");
		String cliente = sc.next() + sc.nextLine();
		System.out.print("Pre�o: ");
		float preco = sc.nextFloat();
		
		//Criando a reserva para cadastrar
		Reserva reserva = new Reserva();
		reserva.setCliente(cliente);
		reserva.setPreco(preco);
		
		//Chama o webservice para cadastrar
		ReservaRepository rep = new ReservaRepository();
		try {
			rep.cadastrar(reserva);
			System.out.println("Sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
	
}
