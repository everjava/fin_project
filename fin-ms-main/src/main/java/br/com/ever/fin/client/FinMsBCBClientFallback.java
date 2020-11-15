package br.com.ever.fin.client;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.ever.fin.model.BankConversionFee;
import br.com.ever.fin.model.FeesHistory;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FinMsBCBClientFallback implements FinMsBCBFeignClient {

	private final Throwable cause;

	public FinMsBCBClientFallback(Throwable cause) {
		this.cause = cause;
	}

	 
	public ResponseEntity<BankConversionFee> notFound(String methodName) {

		if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
			log.error("404 error took place when "+methodName+"retrieveBankFee was called from endpoint: " 
					+ ". Error message: " + cause.getLocalizedMessage());
		} else {
			log.error("Other error took place: " + cause.getLocalizedMessage());
		}
		
		BankConversionFee fees = new BankConversionFee("0", "0", new ArrayList<FeesHistory>());
		return ResponseEntity.status(HttpStatus.OK).body(fees);

		//return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}


	@Override
	public ResponseEntity<BankConversionFee> getSicoobFees() {
		// TODO Auto-generated method stub
		return notFound("");
	}


	@Override
	public ResponseEntity<BankConversionFee> getMercadoPagoFees() {
		// TODO Auto-generated method stub
		return notFound("");
	}


	@Override
	public ResponseEntity<BankConversionFee> getAgibankFees() {
		// TODO Auto-generated method stub
		return notFound("");
	}


	@Override
	public ResponseEntity<BankConversionFee> getBanrisulFees() {
		// TODO Auto-generated method stub
		return notFound("");
	}


	@Override
	public ResponseEntity<BankConversionFee> getBmgFees() {
		// TODO Auto-generated method stub
		return notFound("");
	}


	@Override
	public ResponseEntity<BankConversionFee> getBradescoFees() {
		// TODO Auto-generated method stub
		return notFound("");
	}


	@Override
	public ResponseEntity<BankConversionFee> getC6Fees() {
		// TODO Auto-generated method stub
		return notFound("");
	}


	@Override
	public ResponseEntity<BankConversionFee> getCefFees() {
		// TODO Auto-generated method stub
		return notFound("");
	}


	@Override
	public ResponseEntity<BankConversionFee> getCrefisaFees() {
		// TODO Auto-generated method stub
		return notFound("");
	}


	@Override
	public ResponseEntity<BankConversionFee> getItauFees() {
		// TODO Auto-generated method stub
		return notFound("");
	}


	@Override
	public ResponseEntity<BankConversionFee> getNuBankFees() {
		// TODO Auto-generated method stub
		return notFound("");
	}


	@Override
	public ResponseEntity<BankConversionFee> getPanFees() {
		// TODO Auto-generated method stub
		return notFound("");
	}


	@Override
	public ResponseEntity<BankConversionFee> getSafraFees() {
		// TODO Auto-generated method stub
		return notFound("");
	}


	@Override
	public ResponseEntity<BankConversionFee> getSicrediFees() {
		// TODO Auto-generated method stub
		return notFound("");
	}

}
