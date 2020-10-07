package br.com.virus.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.google.gson.Gson;
import br.com.virus.entidade.datasource.Pais;
import br.com.virus.entidade.repository.Repository;

public class WEBStatus {
	
	
	//Armazenando Dados na lista 
	public static List<Pais> listarEstados() throws Exception {

		WEBStatus ws = new WEBStatus();
		String url = "https://covid19-brazil-api.now.sh/api/report/v1?formato=json";
		String json = ws.obterDados(url);
		Gson g = new Gson();
		Repository vr = new Repository();
		vr = g.fromJson(json,Repository.class);
		
		List<Pais> dadosCOVID = convertArrayToList(vr.getData());
	
		
		/*WEBStatus ws2 = new WEBStatus();
		String url2 = "https://covid19-brazil-api.now.sh/api/report/v1/brazil?formato=json";
		String json2 = ws2.obterDados(url2);
		Gson g2 = new Gson();
		Repository vr2 = new Repository();
		vr2 = g2.fromJson(json2,Repository.class);
		System.out.println(json2);
		List<Pais> dadosCOVIDGeral = convertArrayToList(vr2.getData());
		
		System.out.println(dadosCOVIDGeral);*/
		
		return dadosCOVID;
	}
	
	//Armazenando dados Gerais
		public static Date brazilCOVID() throws Exception {
		
			WEBStatus ws2 = new WEBStatus();
			String url2 = "https://covid19-brazil-api.now.sh/api/report/v1/brazil/uf/sp";
			String json2 = ws2.obterDados(url2);
			Gson g2 = new Gson();
			Pais vr2 = new Pais();
			vr2 = g2.fromJson(json2,Pais.class);
			System.out.println(json2);
			System.out.println(vr2);

			System.out.println(vr2.getDatetime());


			return vr2.getDatetime();
		
	}
	
	
	//Obtendo dados da URL 
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
	
	

	
	
	//Conversão de Arrays
	public static <T> List<T> convertArrayToList(T array[]) {
		List<T> list = new ArrayList<>(); 
		for (T t : array) { 
			list.add(t);
		}
		return list; 
	}





}

	

