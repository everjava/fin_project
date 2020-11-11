package br.com.ever.fin.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ConversionFeeResponse {

	private String minEmissorNome;
	private Double minTaxaConversao;
	private String maxEmissorNome;
	private Double maxTaxaConversao;
}
