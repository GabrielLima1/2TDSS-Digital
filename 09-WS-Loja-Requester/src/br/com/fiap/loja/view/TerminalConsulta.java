package br.com.fiap.loja.view;

import java.util.Scanner;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class TerminalConsulta {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Ler o c�digo do produto
		System.out.print("C�digo produto: ");
		int codigo = sc.nextInt();
		try {
			//Criar a inst�ncia do objeto que chama o ws
			EstoqueBOStub stub = new EstoqueBOStub();
			//Criar a inst�ncia do objeto para enviar o c�digo
			ConsultarProduto produto = new ConsultarProduto();
			produto.setCodigo(codigo);
			//Chamar o webservice e receber o resultado
			ConsultarProdutoResponse resp = 
						stub.consultarProduto(produto);
			//Recuperar o produto e exibir os dados
			ProdutoTO to = resp.get_return();
			System.out.println(to.getDescricao());
			System.out.println("Pre�o:" + to.getPreco());
			System.out.println("Qdt: " + to.getQuantidade());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		sc.close();
	}
	
}