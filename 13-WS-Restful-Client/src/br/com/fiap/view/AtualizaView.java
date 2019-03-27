package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.repository.ReservaRepository;
import br.com.fiap.to.Reserva;

public class AtualizaView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("C�digo: ");
		int codigo = sc.nextInt();
		System.out.print("Cliente: ");
		String cliente = sc.next() + sc.nextLine();
		System.out.print("Pre�o: ");
		float preco = sc.nextFloat();
		
		Reserva reserva = new Reserva(codigo, cliente, preco);
		
		ReservaRepository rep = new ReservaRepository();
		
		try {
			rep.atualizar(reserva);
			System.out.println("Atualizado!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
	
}
