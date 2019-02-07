package br.com.fiap.revisao.bean;

//Classe abstrata -> não pode ser instanciada, pode conter métodos abstratos 
public abstract class InstrumentoMusical {

	private String fabricante;
	
	//método abstrato não possui implementação
	public abstract String acordes();
	
	//POLIMORFISMO: vários comportamentos para o método
	public String emitirSom() {
		return "Mi";
	}
	
	//SOBRECARGA: métodos com mesmo nome e parâmetros diferentes 
	public String emitirSom(String notaMusical) {
		//Operador ternário (condição)?Verdadeiro:Falso		
		return (notaMusical.equals("Mi"))?"Fa":"Sol";
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
}