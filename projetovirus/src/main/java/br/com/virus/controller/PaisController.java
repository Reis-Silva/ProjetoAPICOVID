package br.com.virus.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.virus.entidade.datasource.Pais;
import br.com.virus.service.WEBStatus;


@ApplicationScoped
@ManagedBean
public class PaisController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	// Iiniciando construção de lista
	
	@Inject
	private Pais pais = new Pais();
	
	@Inject
	private List<Pais> estados = new ArrayList<Pais>();	
	

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Pais> getEstados() {
		return estados;
	}

	public void setEstados(List<Pais> estados) {
		this.estados = estados;
	}
	
	//Inicio automático da página
	@PostConstruct
	public void init() {
		try {
			setEstados(WEBStatus.listarEstados());
			pais.setDatetime(WEBStatus.brazilCOVID());
			System.out.println("DateTIme"+ pais.getDatetime());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
