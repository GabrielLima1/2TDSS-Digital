package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.bo.DisciplinaBOStub;
import br.com.fiap.bo.DisciplinaBOStub.CalcularPS;
import br.com.fiap.bo.DisciplinaBOStub.CalcularPSResponse;

public class ConsoleView2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		//Ler os dados
		System.out.print("Nota de NAC: ");
		float nac = sc.nextFloat();
		System.out.print("Nota de AM: ");
		float am = sc.nextFloat();
		
		//Calcular a nota de PS
		CalcularPS valores = new CalcularPS();
		valores.setAm(am);
		valores.setNac(nac);
		
		try {
			DisciplinaBOStub stub = new DisciplinaBOStub();
			CalcularPSResponse resp = stub.calcularPS(valores);
			System.out.println("PS: " + resp.get_return());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
	
}





