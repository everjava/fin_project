package br.com.ever.fin.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankConversionFee {

	private String emissorCnpj;
	private String emissorNome;
	private List<FeesHistory> historicoTaxas;

}
