package br.com.fiap.loja.bo;

import org.apache.log4j.Logger;

import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {
	
	private static Logger log = Logger.getLogger(EstoqueBO.class);

	//Regras de negócio e os dados
	public ProdutoTO consultarProduto(int codigo) throws Exception {
		ProdutoTO produto = null;
		log.debug("Pesquisando código: " + codigo);
		switch (codigo) {
		case 401:
			produto = new ProdutoTO(401, 20, 30, "Camiseta Branca");
			break;
		case 402:
			produto = new ProdutoTO(402,10,50,"Camiseta Azul");
			break;
		case 403:
			produto = new ProdutoTO(403,20,40,"Camiseta Rosa");
			break;
		default:
			log.error("Código não encontrado: " + codigo);
			throw new Exception("Produto não encontrado");
		}
		return produto;
	}
	
}