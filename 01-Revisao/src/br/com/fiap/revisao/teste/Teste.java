package br.com.fiap.revisao.teste;

import br.com.fiap.revisao.bean.InstrumentoMusical;
import br.com.fiap.revisao.bean.Violao;

public class Teste {

	public static void main(String[] args) {
		//InstrumentoMusical i = new InstrumentoMusical();
		//Chama o método do instrumento musical
		//System.out.println(i.emitirSom());
		
		Violao violao = new Violao();
		//Chama o método do violão
		System.out.println(violao.emitirSom());
		
		InstrumentoMusical i2 = new Violao();
		//Chama o método do violão (Objeto atual)
		System.out.println(i2.emitirSom());
		
		//CAST: força um objeto ser de um tipo
		Violao v2 = (Violao) i2;
		
		//TESTE do operador ternário
		System.out.println(v2.emitirSom("Mi"));
		
	}
	
}




