package br.com.ever.fin.client;

import java.net.URI;

import org.springframework.cloud.openfeign.FeignClient;

import br.com.ever.fin.model.BankConversionFee;
import feign.RequestLine;
/**
 * https://www.tfzx.net/article/5772307.html
 * https://www.manongdao.com/q-677553.html
 * @author everson
 *
 */
@FeignClient("bankConversionFeesFeignClient")
////@RibbonClient(name="currency-exchange-service")
public interface BankConversionFeesFeignClient {
	
	@RequestLine("GET")
	public BankConversionFee retrieveBankFee(URI endpoint);

}
