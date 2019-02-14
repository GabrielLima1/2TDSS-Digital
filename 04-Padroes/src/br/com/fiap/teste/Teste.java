package br.com.fiap.teste;

import br.com.fiap.singleton.ConfiguracaoSingleton;

public class Teste {

	public static void main(String[] args) {
		//Recuperar a conex�o configurada
		String conexao = 
				ConfiguracaoSingleton.getInstance()
								.getProperty("conexao");
		System.out.println(conexao);
	}
	
}




