package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;
import br.com.fiap.to.CarroTO;

public class CarroBO {

	private static List<CarroTO> banco = new ArrayList<CarroTO>();
	
	public void cadastrar(CarroTO carro) {
		banco.add(carro);
	}
	
	public List<CarroTO> listar(){
		return banco;
	}
	
}




