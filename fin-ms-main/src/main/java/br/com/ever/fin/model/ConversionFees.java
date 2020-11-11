package br.com.ever.fin.model;

import lombok.Data;

@Data
public class ConversionFees {

	private String emissorNome;
	private String taxaData;
	private String taxaConversao;
	private String taxaTipoGasto;

}
