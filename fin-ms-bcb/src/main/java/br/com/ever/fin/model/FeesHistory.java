package br.com.ever.fin.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeesHistory {

	private String taxaTipoGasto;
	//private Date taxaData;// 2020-10-30,
	//private Double taxaConversao;// 5.7718,
	//private Date taxaDivulgacaoDataHora;// 2020-10-30T03:00:00Z
	
	private String taxaData; 
	private String taxaConversao; 
	private String taxaDivulgacaoDataHora; 

}
