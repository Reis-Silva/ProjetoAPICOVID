package br.com.virus.entidade.repository;

import java.util.Arrays;

import br.com.virus.entidade.datasource.Pais;

public class VirusRepository {
	
	private Pais[] data;

	public Pais[] getVirusEstado() {
		return data;
	}

	public void setVirusEstado(Pais[] virusEstado) {
		this.data = virusEstado;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(data);
	}
}
