package br.com.fiap.singleton;

import java.io.IOException;
import java.util.Properties;

public class ConfiguracaoSingleton {

	//1 - Atributo estático que armazena a única instancia
	private static Properties prop;
	
	//2 - Método estático que retorna a única instancia
	public static Properties getInstance() {
		if (prop == null) {
			prop = new Properties();
			try {
				//carregar o objeto com as informações do arquivo
				prop.load(ConfiguracaoSingleton.class.
					getResourceAsStream("/app.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
	
	//3 - Construtor privado (ninguem instancia a classe)
	private ConfiguracaoSingleton() {}
}




