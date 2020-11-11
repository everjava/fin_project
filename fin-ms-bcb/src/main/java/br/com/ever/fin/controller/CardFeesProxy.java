package br.com.ever.fin.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.ever.fin.model.BanksResponse;

@FeignClient(url = "https://olinda.bcb.gov.br/olinda/servico/DASFN/versao/v1/odata", name = "cardfeesbank")
//@RibbonClient(name="currency-exchange-service")
public interface CardFeesProxy {

	@GetMapping("/Recursos?$filter=Api%20eq%20%27taxas_cartoes%27%20and%20Recurso%20eq%20%27/itens/ultimo%27&$format=json")
	public BanksResponse retrieveBanks( );
	
	
}
