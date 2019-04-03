package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {

	private String login;
	private String senha;
	
	public void entrar() {
		if (login.equals("FIAP") && "FIAP2019".equals(senha)) {
			System.out.println("Logado com sucesso!");
		}else {
			System.out.println("Usuário e/ou senha inválidos");
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
