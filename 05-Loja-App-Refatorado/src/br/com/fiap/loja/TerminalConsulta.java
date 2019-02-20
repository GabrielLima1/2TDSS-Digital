package br.com.fiap.loja;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import org.apache.log4j.Logger;

import br.com.fiap.loja.bo.EstoqueBO;
import br.com.fiap.loja.to.ProdutoTO;
import br.com.fiap.singleton.ConfiguracaoSingleton;

public class TerminalConsulta {

	private static Logger log = Logger.getLogger(TerminalConsulta.class);
	
	//Camada de apresentação 
	public static void main(String[] args) {
		
		log.warn("Início da aplicação");
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// Recupera a data atual formatada
		String data = sdf.format(Calendar.getInstance().getTime());
		
		EstoqueBO bo = new EstoqueBO();
		
		//Recupera o valor configurado
		String nome = ConfiguracaoSingleton.getInstance()
										.getProperty("loja");
		
		int codigo;
		do {
			System.out.print("Digite o código: ");
			codigo = sc.nextInt(); // lê o código do produto
			
			try {
				//Pesquisa o produto na camada de negócio
				ProdutoTO to = bo.consultarProduto(codigo);
				System.out.println(to.getDescricao());
				System.out.println("Preço: " + to.getPreco());
				System.out.println("Qtd: " + to.getQuantidade());
			} catch (Exception e) {
				//e.printStackTrace();
				System.err.println(e.getMessage());
				log.error("Produto não encontrado");
			}
			
			System.out.println(nome + " " + data + "\n");
		} while (codigo != 0);

		log.warn("Fim da aplicação!");
		
		sc.close();
	}

}
