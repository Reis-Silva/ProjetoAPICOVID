package br.com.virus.entidade.datasource;

import java.util.Date;



public class Pais {
	
	 	private String uid;
	    private String uf;
	    private String state;
	    private String cases;
	    private String deaths;
	    private String suspects;
	    private Date datetime;
	    private String refuses;
	    
	    private String country;
	    private String confirmed;
	    private Date updated_at;
	    private String recovered;

		
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getConfirmed() {
			return confirmed;
		}
		public void setConfirmed(String confirmed) {
			this.confirmed = confirmed;
		}
		public Date getUpdated_at() {
			return updated_at;
		}
		public void setUpdated_at(Date updated_at) {
			this.updated_at = updated_at;
		}
		public String getRecovered() {
			return recovered;
		}
		public String getRefuses() {
			return refuses;
		}

		public void setRefuses(String refuses) {
			this.refuses = refuses;
		}

		public void setRecovered(String recovered) {
			this.recovered = recovered;
		}
		public String getUid() {
			return uid;
		}
		public void setUid(String uid) {
			this.uid = uid;
		}
		public String getUf() {
			return uf;
		}
		public void setUf(String uf) {
			this.uf = uf;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCases() {
			return cases;
		}
		public void setCases(String cases) {
			this.cases = cases;
		}
		public String getDeaths() {
			return deaths;
		}
		public void setDeaths(String deaths) {
			this.deaths = deaths;
		}
		public String getSuspects() {
			return suspects;
		}
		public void setSuspects(String suspects) {
			this.suspects = suspects;
		}
		public Date getDatetime() {
			return datetime;
		}
		public void setDatetime(Date datetime) {
			this.datetime = datetime;
		}
		
	    	    
}
