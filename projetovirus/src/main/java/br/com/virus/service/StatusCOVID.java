package br.com.virus.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import br.com.virus.controller.PaisController;
import br.com.virus.entidade.datasource.Pais;
import br.com.virus.entidade.repository.VirusRepository;

public class StatusCOVID {
	
	public static void main(String[] args) throws Exception {
	       
		try {
			String url = "https://covid19-brazil-api.now.sh/api/report/v1";

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
			
			System.out.println(response);
			
			br.close();

			Gson gson = new Gson();			
			VirusRepository dados = gson.fromJson(response.toString(),VirusRepository.class);
			System.out.println(dados);
			
		} catch (IOException ex) {
			Logger.getLogger(StatusCOVID.class.getName()).log(Level.SEVERE, null, ex);
		}

		}
	
	public static <T> List<T> convertArrayToList(T array[]) {
		List<T> list = new ArrayList<>(); 
		for (T t : array) { 
			list.add(t);
		}
		return list; 
	}


}
	
	

