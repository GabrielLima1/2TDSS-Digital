package br.com.fiap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="comida",sequenceName="SQ_T_COMIDA",allocationSize=1)
public class Comida {

	@Id
	@GeneratedValue(generator="comida",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	private String nome;
	
	private boolean salgado;
	
	private float preco;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isSalgado() {
		return salgado;
	}

	public void setSalgado(boolean salgado) {
		this.salgado = salgado;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
}
