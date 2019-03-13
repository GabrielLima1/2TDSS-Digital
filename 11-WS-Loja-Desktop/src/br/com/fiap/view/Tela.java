package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtCodigo;
	private Text txtDescricao;
	private Text txtPreco;
	private Text txtQuantidade;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblCdigoProduto = new Label(shell, SWT.NONE);
		lblCdigoProduto.setBounds(33, 45, 93, 15);
		lblCdigoProduto.setText("C\u00F3digo Produto");
		
		txtCodigo = new Text(shell, SWT.BORDER);
		txtCodigo.setBounds(132, 42, 76, 21);
		
		Button btnPesquisar = new Button(shell, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				int codigo = Integer.parseInt(txtCodigo.getText());
				
				try {
					//Objeto para chamar o web service
					EstoqueBOStub stub = new EstoqueBOStub();
					
					//Objeto para enviar o código para o ws
					ConsultarProduto c = new ConsultarProduto();
					c.setCodigo(codigo);
					
					//Chama o ws e recupera a resposta
					ConsultarProdutoResponse resp =
										stub.consultarProduto(c);
					
					//Exibe a resposta na tela
					ProdutoTO produto = resp.get_return();
					txtDescricao.setText(produto.getDescricao());
					txtPreco.setText(String.valueOf(produto.getPreco()));
					txtQuantidade.setText(String.valueOf(produto.getQuantidade()));
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnPesquisar.setBounds(224, 40, 75, 25);
		btnPesquisar.setText("Pesquisar");
		
		Label lblDescrio = new Label(shell, SWT.NONE);
		lblDescrio.setBounds(33, 109, 55, 15);
		lblDescrio.setText("Descri\u00E7\u00E3o");
		
		Label lblPreo = new Label(shell, SWT.NONE);
		lblPreo.setBounds(33, 141, 55, 15);
		lblPreo.setText("Pre\u00E7o");
		
		Label lblQuantidade = new Label(shell, SWT.NONE);
		lblQuantidade.setBounds(33, 171, 76, 15);
		lblQuantidade.setText("Quantidade");
		
		txtDescricao = new Text(shell, SWT.BORDER);
		txtDescricao.setEditable(false);
		txtDescricao.setBounds(132, 109, 167, 21);
		
		txtPreco = new Text(shell, SWT.BORDER);
		txtPreco.setEditable(false);
		txtPreco.setBounds(132, 138, 167, 21);
		
		txtQuantidade = new Text(shell, SWT.BORDER);
		txtQuantidade.setEditable(false);
		txtQuantidade.setBounds(132, 168, 167, 21);

	}

}
