package br.com.fiap.view;

import java.util.Scanner;

import org.apache.axis2.AxisFault;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class CorreiosView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Ler dois CEPs e calcular o prazo de entrega
		//40010 SEDEX
		System.out.print("CEP Origem: ");
		String origem = sc.next();
		
		System.out.print("CEP Destino: ");
		String destino = sc.next();
		
		try {
			//Objeto que possui os métodos do web service
			CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
			
			CalcPrazo valores = new CalcPrazo();
			valores.setNCdServico("40010");
			valores.setSCepDestino(destino);
			valores.setSCepOrigem(origem);
			
			CalcPrazoResponse resp = stub.calcPrazo(valores);
			
			System.out.println("Prazo: " + resp.getCalcPrazoResult()
				.getServicos().getCServico()[0].getPrazoEntrega());
			
			System.out.println("Data: " + resp.getCalcPrazoResult()
			.getServicos().getCServico()[0].getDataMaxEntrega());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
	
}




