package br.com.fiap.bean;

import java.util.Calendar;

public class ContaCorrente extends Conta {

	private TipoConta tipo;
	
	@Override
	public void retirar(double valor) throws Exception {
		if (tipo == TipoConta.COMUM && saldo < valor) {
			throw new Exception("Saldo insuficiente");
		}
		saldo -= valor;
	}

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipo) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipo = tipo;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}
	
}


