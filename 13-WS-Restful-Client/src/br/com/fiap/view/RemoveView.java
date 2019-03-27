package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.repository.ReservaRepository;

public class RemoveView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Código: ");
		int codigo = sc.nextInt();
		
		ReservaRepository rep = new ReservaRepository();
		
		try {
			rep.remover(codigo);
			System.out.println("Removido!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
	
}
