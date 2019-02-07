package br.com.fiap.revisao.dao;

import java.util.List;
import br.com.fiap.revisao.bean.Violao;

//Uma interface pode herdar de uma ou mais interfaces
public interface ViolaoDAO { //extends Serializable, Comparable {

	void insert(Violao violao);
	List<Violao> list();
	
}