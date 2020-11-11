package br.com.ever.fin.enums;

/**
 * add to properties file
 * 
 * @author everson
 *
 */
public enum BankEndpointEnum {

	
	SICOOB ("https://dadosabertos.sicoob.com.br/cda/api/taxas-cartoes/itens/ultimo"),  //
	MERCADO_PAGO ("https://www.mercadopago.com.br/informacoes-adicionais/dados-abertos/itens/ultimo"),  //
	CREFISA ("https://www.crefisa.com.br/dadosabertos/itens/ultimo"),  //
	CEF ("https://api.caixa.gov.br:8443/dadosabertos/taxasCartoes/1.2.0/itens/ultimo"),  //
	NUBANK ("https://dadosabertos.nubank.com.br/taxasCartoes/itens/ultimo"),  //
	BANRISUL ("https://www.banrisul.com.br/bob/data/opendata/cartoes/itens/ultimo/"),  //
	BMG ("https://api.bancobmg.com.br/api/v1/bacen/dasfn/taxascartoes/itens/ultimo"),  //
	SICREDI ("https://dadosabertos.sicredi.com.br/dasfn/v1/taxa-cartao/0100/itens/ultimo"),  //
	PAN ("https://api.bancopan.com.br/dadosabertos/dadosabertos/taxasCartoes/itens/ultimo"),  //
	ITAU ("https://api.itau.com.br/dadosabertos/taxasCartoes/taxas/itens/ultimo"),  //
	BRADESCO ("https://proxy.api.prebanco.com.br/bradescard/dadosabertos/taxasCart"),  //
	C6 ("https://dadosabertos-p.c6bank.info/cartao/taxasCartoes/itens/ultimo"),  //
	SAFRA("https://www.safra.com.br/dadosabertos/taxascartoes/itens/ultimo"), //
	AGIBANK("https://api.agibank.com.br/cards-open-data/v1/dolar/itens/ultimo");
	
	
	
	private String endpoint;
	
	BankEndpointEnum(String endpoint){
		this.endpoint = endpoint;
	}
	
	public String getEndpoint() {
		return endpoint;
	}
}
