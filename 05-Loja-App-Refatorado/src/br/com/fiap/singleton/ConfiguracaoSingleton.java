package br.com.fiap.singleton;

import java.io.IOException;
import java.util.Properties;

public class ConfiguracaoSingleton {

	private static Properties p;
	
	public static Properties getInstance() {
		if (p == null) {
			p = new Properties();
			//carregar o arquivo
			try {
				p.load(ConfiguracaoSingleton.class.
					getResourceAsStream("/loja.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
	private ConfiguracaoSingleton() {}
	
}


