package br.com.ever.fin.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ever.fin.model.BankConversionFee;

@FeignClient(name ="fin-ms-bcb",fallbackFactory = FinMsBCBClientFallbackFactory.class)
public interface FinMsBCBFeignClient {

	@RequestMapping(value = "/cardfees/sicoob", method = RequestMethod.GET)
	ResponseEntity<BankConversionFee> getSicoobFees();

	@RequestMapping(value = "/cardfees/mercadopago", method = RequestMethod.GET)
	ResponseEntity<BankConversionFee> getMercadoPagoFees();

	@RequestMapping(value = "/cardfees/agibank", method = RequestMethod.GET)
	ResponseEntity<BankConversionFee> getAgibankFees();

	@RequestMapping(value = "/cardfees/banrisul", method = RequestMethod.GET)
	ResponseEntity<BankConversionFee> getBanrisulFees();

	@RequestMapping(value = "/cardfees/bmg", method = RequestMethod.GET)
	ResponseEntity<BankConversionFee> getBmgFees();

	@RequestMapping(value = "/cardfees/bradesco", method = RequestMethod.GET)
	ResponseEntity<BankConversionFee> getBradescoFees();

	@RequestMapping(value = "/cardfees/c6", method = RequestMethod.GET)
	ResponseEntity<BankConversionFee> getC6Fees();

	@RequestMapping(value = "/cardfees/cef", method = RequestMethod.GET)
	ResponseEntity<BankConversionFee> getCefFees();

	@RequestMapping(value = "/cardfees/crefisa", method = RequestMethod.GET)
	ResponseEntity<BankConversionFee> getCrefisaFees();

	@RequestMapping(value = "/cardfees/itau", method = RequestMethod.GET)
	ResponseEntity<BankConversionFee> getItauFees();

	@RequestMapping(value = "/cardfees/nubank", method = RequestMethod.GET)
	ResponseEntity<BankConversionFee> getNuBankFees();

	@RequestMapping(value = "/cardfees/pan", method = RequestMethod.GET)
	ResponseEntity<BankConversionFee> getPanFees();

	@RequestMapping(value = "/cardfees/safra", method = RequestMethod.GET)
	ResponseEntity<BankConversionFee> getSafraFees();

	@RequestMapping(value = "/cardfees/sicredi", method = RequestMethod.GET)
	ResponseEntity<BankConversionFee> getSicrediFees();

}
