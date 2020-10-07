package br.com.virus.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.google.gson.Gson;

import br.com.virus.entidade.datasource.Pais;
import br.com.virus.entidade.repository.VirusRepository;


@ApplicationScoped
@ManagedBean
public class PaisController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Pais pais;
	
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

	@PostConstruct
	public void init() {
		try {
			setEstados(PaisController.listarEstados());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Pais> listarEstados() throws Exception {
		PaisController ws = new PaisController();
		String url = "https://covid19-brazil-api.now.sh/api/report/v1?formato=json";
		String json = ws.obterDados(url);
	
		Gson g = new Gson();
		VirusRepository vr = new VirusRepository();
		System.out.println(json);
		vr = g.fromJson(json,VirusRepository.class);
		System.out.println(vr);
		
		List<Pais> list = convertArrayToList(vr.getVirusEstado());

		return list;
	}
	
	public static <T> List<T> convertArrayToList(T array[]) {
		List<T> list = new ArrayList<>(); 
		for (T t : array) { 
			list.add(t);
		}
		return list; 
	}
	
	
	public String obterDados(String url) throws Exception{

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuffer response = new StringBuffer();
			
			String line;
			while ((line = br.readLine()) != null) {
				response.append(line);
			}

			conn.disconnect();			
			return response.toString();
	}
	
	

}
