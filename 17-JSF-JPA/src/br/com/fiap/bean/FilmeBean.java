package br.com.fiap.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.fiap.dao.FilmeDAO;
import br.com.fiap.dao.impl.FilmeDAOImpl;
import br.com.fiap.entity.Filme;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@ManagedBean
@RequestScoped 
public class FilmeBean implements Serializable {

	private Filme filme;
	
	private FilmeDAO dao;
	
	@PostConstruct
	public void init() {
		filme = new Filme();
		filme.setDataLancamento(Calendar.getInstance());
		dao = new FilmeDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	public void validarTitulo(FacesContext context, UIComponent 
			component, Object value) throws ValidatorException {
		
		String titulo = value.toString();
		
		if (dao.contarPorTitulo(titulo) != 0) {
			throw new ValidatorException(
					new FacesMessage("Título já cadastrado!"));
		}
		
	}
	
	public String remover(int codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
			adicionarMensagem("Removido!");
		} catch (Exception e) {
			e.printStackTrace();
			adicionarMensagem("Erro..");
		}
		return "lista-filme?faces-redirect=true";
	}
	
	public List<Filme> listar(){
		return dao.listar();
	}

	public String salvar() {
		try {
			if (filme.getCodigo() == 0) {
				dao.cadastrar(filme);
				dao.commit();
				adicionarMensagem("Cadastrado!");
			}else {
				dao.atualizar(filme);
				dao.commit();
				adicionarMensagem("Atualizado!");
			}
			return "lista-filme?faces-redirect=true"; //navega para a página lista-filme.xhtml
		} catch (CommitException e) {
			e.printStackTrace();
			adicionarMensagem("Erro..");
			return "cadastro-filme";
		}
	}
	
	private void adicionarMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		//Mantém as mensagens após um redirect
		FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().setKeepMessages(true);
		
	}
	
	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
}
