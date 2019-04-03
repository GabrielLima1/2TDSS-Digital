package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HomeBean {

	private String nome;
	
	public void noClique() {
		System.out.println(getNome());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}