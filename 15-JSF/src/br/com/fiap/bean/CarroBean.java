package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.CarroBO;
import br.com.fiap.to.CarroTO;

@ManagedBean
public class CarroBean {

	private CarroTO carro;
	
	private CarroBO bo;
	
	@PostConstruct //método para inicializar os objetos
	public void init() {
		bo = new CarroBO();
		carro = new CarroTO();
	}
	
	//método para preencher a tabela HTML
	public List<CarroTO> carros(){
		return bo.listar();
	}
	
	public void cadastrar() {
		bo.cadastrar(carro);
		//Mensagem que será exibida na página
		FacesMessage msg = new FacesMessage("Cadastrado!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		System.out.println(carro.getModelo());
		System.out.println("Carro cadastrado!");
	}

	public CarroTO getCarro() {
		return carro;
	}

	public void setCarro(CarroTO carro) {
		this.carro = carro;
	}
	
}
