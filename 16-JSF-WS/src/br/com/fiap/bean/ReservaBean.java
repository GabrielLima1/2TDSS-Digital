package br.com.fiap.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.repository.ReservaRepository;
import br.com.fiap.to.Reserva;

@ViewScoped
@ManagedBean
public class ReservaBean implements Serializable {

	private Reserva reserva;
	
	private ReservaRepository rep;
	
	@PostConstruct
	public void init() {
		setReserva(new Reserva());
		rep = new ReservaRepository();
	}
	
	public List<Reserva> listar(){
		try {
			return rep.listar();
		} catch (Exception e) {
			e.printStackTrace();
			exibeMensagem("Erro ao listar..");
			return null;
		}
	}
	
	public void deletar(int codigo) {
		try {
			rep.remover(codigo);
			exibeMensagem("Excluido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			exibeMensagem("Erro..");
		}
	}
	
	private void exibeMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void cadastrar() {		
		try {
			if (reserva.getCodigo() == 0) {
				rep.cadastrar(getReserva());
				exibeMensagem("Cadastrado!");
			}else {
				rep.atualizar(reserva);
				exibeMensagem("Atualizado!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			exibeMensagem("Erro..");
		}
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
}


