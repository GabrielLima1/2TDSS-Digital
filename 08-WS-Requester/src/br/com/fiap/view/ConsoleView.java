package br.com.fiap.view;

import br.com.fiap.bo.DisciplinaBOStub;
import br.com.fiap.bo.DisciplinaBOStub.RetidoPorFalta;
import br.com.fiap.bo.DisciplinaBOStub.RetidoPorFaltaResponse;

public class ConsoleView {

	public static void main(String[] args) {
		
		try {
			//Objeto que possui os m�todos para chamar o web service
			DisciplinaBOStub stub = new DisciplinaBOStub();
			
			//Objeto que possui os parametros que ser�o enviados
			RetidoPorFalta valores = new RetidoPorFalta();
			valores.setAulas(100);
			valores.setFaltas(26);
			
			//Chamando o web service (Projeto 06)
			RetidoPorFaltaResponse resp =
								stub.retidoPorFalta(valores);
			
			//Exibe a resposta
			boolean retido = resp.get_return();
			System.out.println("Retido: " + (retido?"Sim":"N�o"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
