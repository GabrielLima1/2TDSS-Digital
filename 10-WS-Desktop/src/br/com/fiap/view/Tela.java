package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtNumero1;
	private Text txtNumero2;
	private Text txtResultado;
	private Text txtOrigem;
	private Text txtDestino;
	private Text txtPrazo;
	private Text txtDataMaxima;

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
		
		Label lblNmero = new Label(shell, SWT.NONE);
		lblNmero.setBounds(21, 25, 55, 15);
		lblNmero.setText("N\u00FAmero 1");
		
		txtNumero1 = new Text(shell, SWT.BORDER);
		txtNumero1.setBounds(82, 22, 76, 21);
		
		Label lblNmero_1 = new Label(shell, SWT.NONE);
		lblNmero_1.setBounds(21, 64, 55, 15);
		lblNmero_1.setText("N\u00FAmero 2");
		
		txtNumero2 = new Text(shell, SWT.BORDER);
		txtNumero2.setBounds(82, 61, 76, 21);
		
		Button btnCalcular = new Button(shell, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//recupera os valores informados pelo usuário
				int n1 = Integer.parseInt(txtNumero1.getText());
				int n2 = Integer.parseInt(txtNumero2.getText());
				
				//fazer a soma
				int soma = n1 + n2;
				
				//exibir a resposta
				txtResultado.setText(String.valueOf(soma));
			}
		});
		btnCalcular.setBounds(83, 88, 75, 25);
		btnCalcular.setText("Calcular");
		
		txtResultado = new Text(shell, SWT.BORDER);
		txtResultado.setEditable(false);
		txtResultado.setBounds(82, 119, 76, 21);
		
		Label lblResultado = new Label(shell, SWT.NONE);
		lblResultado.setBounds(21, 122, 55, 15);
		lblResultado.setText("Resultado");
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(191, 15, 2, 224);
		
		Label lblCepOrigem = new Label(shell, SWT.NONE);
		lblCepOrigem.setBounds(211, 25, 76, 15);
		lblCepOrigem.setText("CEP Origem");
		
		Label lblCepDestino = new Label(shell, SWT.NONE);
		lblCepDestino.setBounds(211, 64, 76, 15);
		lblCepDestino.setText("CEP Destino");
		
		txtOrigem = new Text(shell, SWT.BORDER);
		txtOrigem.setBounds(294, 22, 76, 21);
		
		txtDestino = new Text(shell, SWT.BORDER);
		txtDestino.setBounds(294, 61, 76, 21);
		
		Button btnPesquisar = new Button(shell, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String cepOrigem = txtOrigem.getText();
				String cepDestino = txtDestino.getText();
				
				try {
					
					CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
					
					CalcPrazo c = new CalcPrazo();
					c.setNCdServico("40010");
					c.setSCepDestino(cepDestino);
					c.setSCepOrigem(cepOrigem);
					
					CalcPrazoResponse resp = stub.calcPrazo(c);
					
					txtPrazo.setText(resp.getCalcPrazoResult().getServicos()
						.getCServico()[0].getPrazoEntrega());
					txtDataMaxima.setText(resp.getCalcPrazoResult().getServicos()
						.getCServico()[0].getDataMaxEntrega());
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPesquisar.setBounds(295, 88, 75, 25);
		btnPesquisar.setText("Pesquisar");
		
		Label lblPrazo = new Label(shell, SWT.NONE);
		lblPrazo.setBounds(211, 122, 55, 15);
		lblPrazo.setText("Prazo");
		
		txtPrazo = new Text(shell, SWT.BORDER);
		txtPrazo.setEditable(false);
		txtPrazo.setBounds(294, 119, 76, 21);
		
		Label lblDataMxima = new Label(shell, SWT.NONE);
		lblDataMxima.setBounds(211, 159, 76, 15);
		lblDataMxima.setText("Data M\u00E1xima");
		
		txtDataMaxima = new Text(shell, SWT.BORDER);
		txtDataMaxima.setEditable(false);
		txtDataMaxima.setBounds(295, 156, 76, 21);

	}
}
