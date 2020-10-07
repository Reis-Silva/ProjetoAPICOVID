package br.com.virus.entidade.repository;

import java.util.Arrays;

import br.com.virus.entidade.datasource.Pais;

public class Repository {
	
	private Pais[] data;
	
	
	public Pais[] getData() {
		return data;
	}

	public void setData(Pais[] data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(data);
	}
}
