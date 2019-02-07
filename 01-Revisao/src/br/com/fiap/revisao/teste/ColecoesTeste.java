package br.com.fiap.revisao.teste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ColecoesTeste {

	public static void main(String[] args) {
		//Lista -> valores possuem índice
		List<String> lista = new ArrayList<String>();
		lista.add("Coxinha"); //adiciona valor na lista
		lista.add("Coxinha");
		lista.add("Pastel");
		lista.add("Temaki");
		
		//Exibir todos os valores da lista
		System.out.println("LISTA:");
		for (String item : lista) {
			System.out.println(item);
		}
		
		//SET: não permite valores repetidos
		Set<String> set = new HashSet<String>();
		set.add("Coca Cola"); //adiciona elementos no set
		set.add("Coca Cola");
		set.add("Limonada");
		
		//Exibir todos os valores do conjunto
		System.out.println("SET:");
		for (String item : set) {
			System.out.println(item);
		}
		
		//MAPA: par de chave e valor
		Map<String,Double> mapa = new HashMap<String,Double>();
		mapa.put("coxinha", 5d); //adiciona valor no mapa
		mapa.put("pastel", 6.0);
		
		System.out.println("MAPA:");
		//Exibe o valor da chave "pastel"
		System.out.println("Valor do pastel: " + mapa.get("pastel"));
		
		
	}
	
}










