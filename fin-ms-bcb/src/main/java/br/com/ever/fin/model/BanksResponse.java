package br.com.ever.fin.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BanksResponse {

	@JsonProperty("value")
	private List<Bank> banks;

}
