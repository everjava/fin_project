package br.com.ever.fin.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@ToString
@Data
@Getter
public class Bank {

	@JsonProperty("Api")
	private String api;
	
	@JsonProperty("Versao")
	private String versao;
	
	@JsonProperty("CnpjInstituicao")
	private String cnpjInstituicao;
	
	@JsonProperty("NomeInstituicao")
	private String nomeInstituicao;
	
	@JsonProperty("NomeContatoString")
	private String nomeContatoString;
	
	@JsonProperty("EmailContato")
	private String emailContato;
	
	@JsonProperty("Recurso")
	private String recurso;
	
	@JsonProperty("Argumento")
	private String argumento;
	
	@JsonProperty("Situacao")
	private String situacao;
	
	@JsonProperty("URLDados")
	private String uRLDados;
	
	@JsonProperty("URLConsulta")
	private String uRLConsulta;

}
