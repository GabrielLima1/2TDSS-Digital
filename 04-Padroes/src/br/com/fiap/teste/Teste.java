package br.com.fiap.teste;

import org.apache.log4j.Logger;

import br.com.fiap.singleton.ConfiguracaoSingleton;

public class Teste {
	
	//Objeto para realizar o logging da classe Teste
	private static Logger log = Logger.getLogger(Teste.class);

	public static void main(String[] args) {
		
		log.trace("Inicio da aplicação");
		
		//Recuperar a conexão configurada
		String conexao = 
				ConfiguracaoSingleton.getInstance()
								.getProperty("conexao");
		
		log.debug("Recuperando a conexão");
		
		System.out.println(conexao);
	}
	
}




