package br.com.fiap.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.dao.FilmeDAO;
import br.com.fiap.dao.impl.FilmeDAOImpl;
import br.com.fiap.entity.Filme;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@ManagedBean
@ViewScoped
public class FilmeBean implements Serializable {

	private Filme filme;
	
	private FilmeDAO dao;
	
	@PostConstruct
	public void init() {
		filme = new Filme();
		filme.setDataLancamento(Calendar.getInstance());
		dao = new FilmeDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	public List<Filme> listar(){
		return dao.listar();
	}

	public void salvar() {
		try {
			dao.cadastrar(filme);
			dao.commit();
			adicionarMensagem("Cadastrado!");
		} catch (CommitException e) {
			e.printStackTrace();
			adicionarMensagem("Erro..");
		}
	}
	
	private void adicionarMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
}
