package br.com.fiap.to;

public class Reserva {

	private int codigo;
	
	private String cliente;

	private float preco;
	
	

	public Reserva(int codigo, String cliente, float preco) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.preco = preco;
	}

	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
}