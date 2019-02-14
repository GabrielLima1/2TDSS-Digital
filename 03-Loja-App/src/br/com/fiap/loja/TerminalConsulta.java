package br.com.fiap.loja;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class TerminalConsulta {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// Recupera a data atual formatada
		String data = sdf.format(Calendar.getInstance().getTime());
		int codigo;
		do {
			System.out.print("Digite o código: ");
			codigo = sc.nextInt(); // lê o código do produto
			switch (codigo) {
			case 401:
				System.out.println("Camiseta Branca");
				break;
			case 402:
				System.out.println("Camiseta Azul");
				break;
			case 403:
				System.out.println("Camiseta Rosa");
				break;
			case 0:
				System.out.println("Obrigado!");
				break;
			default:
				System.out.println("Produto não encontrado");
			}
			System.out.println("LojaFIAP " + data + "\n");
		} while (codigo != 0);

		sc.close();
	}

}
