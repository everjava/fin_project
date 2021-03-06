package br.com.ever.fin.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.ever.fin.client.BankConversionFeesFeignClient;
import br.com.ever.fin.enums.BankEndpointEnum;
import br.com.ever.fin.model.BankConversionFee;
import br.com.ever.fin.model.FeesHistory;
import feign.Feign;
import feign.Target;
import feign.codec.Decoder;
import feign.codec.Encoder;

@RestController
@RequestMapping("/cardfees")
@Import(FeignClientsConfiguration.class)
public class BankConversionFeesController {

	private BankConversionFeesFeignClient bankConversionFeesFeignClient;

	@Autowired
	public BankConversionFeesController(Decoder decoder, Encoder encoder) {
		bankConversionFeesFeignClient = Feign.builder() //
				.encoder(encoder) //
				.decoder(decoder) //
				.target(Target.EmptyTarget.create(BankConversionFeesFeignClient.class));
	}

	/**
	 * CB circuit breaker
	 */
	public BankConversionFee fallbackRetrieveConfiguration() {
		BankConversionFee fees = new BankConversionFee("0", "0", new ArrayList<FeesHistory>());
		return fees;
	}

	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration") // CB
	@RequestMapping(value = "/sicoob", method = RequestMethod.GET)
	public BankConversionFee getSicoobFees() throws URISyntaxException {
		BankConversionFee fees = bankConversionFeesFeignClient
				.retrieveBankFee(new URI(BankEndpointEnum.SICOOB.getEndpoint()));
		return fees;
	}

	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	@RequestMapping(value = "/mercadopago", method = RequestMethod.GET)
	public BankConversionFee getMercadoPagoFees() throws URISyntaxException {
		BankConversionFee fees = bankConversionFeesFeignClient
				.retrieveBankFee(new URI(BankEndpointEnum.MERCADO_PAGO.getEndpoint()));
		return fees;
	}

	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	@RequestMapping(value = "/agibank", method = RequestMethod.GET)
	public BankConversionFee getAgibankFees() throws URISyntaxException {
		BankConversionFee fees = bankConversionFeesFeignClient
				.retrieveBankFee(new URI(BankEndpointEnum.AGIBANK.getEndpoint()));
		return fees;

	}

	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	@RequestMapping(value = "/banrisul", method = RequestMethod.GET)
	public BankConversionFee getBanrisulFees() throws URISyntaxException {
		BankConversionFee fees = bankConversionFeesFeignClient
				.retrieveBankFee(new URI(BankEndpointEnum.BANRISUL.getEndpoint()));
		return fees;

	}

	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	@RequestMapping(value = "/bmg", method = RequestMethod.GET)
	public BankConversionFee getBmgFees() throws URISyntaxException {
		BankConversionFee fees = bankConversionFeesFeignClient
				.retrieveBankFee(new URI(BankEndpointEnum.BMG.getEndpoint()));
		return fees;

	}

	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	@RequestMapping(value = "/bradesco", method = RequestMethod.GET)
	public BankConversionFee getBradescoFees() throws URISyntaxException {
		BankConversionFee fees = bankConversionFeesFeignClient
				.retrieveBankFee(new URI(BankEndpointEnum.BRADESCO.getEndpoint()));
		return fees;

	}

	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	@RequestMapping(value = "/c6", method = RequestMethod.GET)
	public BankConversionFee getC6Fees() throws URISyntaxException {
		BankConversionFee fees = bankConversionFeesFeignClient
				.retrieveBankFee(new URI(BankEndpointEnum.C6.getEndpoint()));
		return fees;

	}

	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	@RequestMapping(value = "/cef", method = RequestMethod.GET)
	public BankConversionFee getCefFees() throws URISyntaxException {
		BankConversionFee fees = bankConversionFeesFeignClient
				.retrieveBankFee(new URI(BankEndpointEnum.CEF.getEndpoint()));
		return fees;

	}

	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	@RequestMapping(value = "/crefisa", method = RequestMethod.GET)
	public BankConversionFee getCrefisaFees() throws URISyntaxException {
		BankConversionFee fees = bankConversionFeesFeignClient
				.retrieveBankFee(new URI(BankEndpointEnum.CREFISA.getEndpoint()));
		return fees;

	}

	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	@RequestMapping(value = "/itau", method = RequestMethod.GET)
	public BankConversionFee getItauFees() throws URISyntaxException {
		// BankConversionFee fees = bankConversionFeesFeignClient.retrieveBankFee(new
		// URI(BankEndpointEnum.ITAU.getEndpoint()));
		BankConversionFee fees = bankConversionFeesFeignClient.retrieveBankFee(new URI("localhost:1010"));
		return fees;

	}

	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	@RequestMapping(value = "/nubank", method = RequestMethod.GET)
	public BankConversionFee getNuBankFees() throws URISyntaxException {
		BankConversionFee fees = bankConversionFeesFeignClient
				.retrieveBankFee(new URI(BankEndpointEnum.NUBANK.getEndpoint()));
		return fees;

	}

	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	@RequestMapping(value = "/pan", method = RequestMethod.GET)
	public BankConversionFee getPanFees() throws URISyntaxException {
		BankConversionFee fees = bankConversionFeesFeignClient
				.retrieveBankFee(new URI(BankEndpointEnum.PAN.getEndpoint()));
		return fees;

	}

	// @HystrixCommand(fallbackMethod="fallbackRetrieveConfiguration")
	@RequestMapping(value = "/safra", method = RequestMethod.GET)
	public BankConversionFee getSafraFees() throws URISyntaxException {
		BankConversionFee fees = bankConversionFeesFeignClient
				.retrieveBankFee(new URI(BankEndpointEnum.SAFRA.getEndpoint()));
		return fees;

	}

	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	@RequestMapping(value = "/sicredi", method = RequestMethod.GET)
	public BankConversionFee getSicrediFees() throws URISyntaxException {
		BankConversionFee fees = bankConversionFeesFeignClient
				.retrieveBankFee(new URI(BankEndpointEnum.SICREDI.getEndpoint()));
		return fees;

	}

//	@GetMapping(value = "/banks")
//	public <BanksResponse> getBanks() throws JsonProcessingException {
//		BanksResponse bankResponse = new BanksResponse();// .retrieveBanks();
//		System.err.println(bankResponse.toString());
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
//		String result = mapper.writeValueAsString(bankResponse);
//		System.err.println(result);
//		
//		ListBankConversionFee conversionFees = new ArrayListBankConversionFee();
//		bankResponse.getBanks().forEach(bank -> bank.getURLConsulta());
//		return (bankResponse);
//	}

}
