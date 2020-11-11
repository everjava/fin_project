package br.com.ever.fin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.ever.fin.client.BankConversionFeesFeignClient;
import br.com.ever.fin.model.BankConversionFee;

@Service
public class ConversionFeesService implements ConversionFees {

	@Autowired
	private BankConversionFeesFeignClient bankConversionFees;

	@Override
	public List<BankConversionFee> getAllFees() {
		List<BankConversionFee> listFees = new ArrayList<BankConversionFee>();
		getAgibank().ifPresent(s -> listFees.add(s));
		getC6().ifPresent(s -> listFees.add(s));
		getSicoob().ifPresent(s -> listFees.add(s));
		getBanrisul().ifPresent(s -> listFees.add(s));
		getBmg().ifPresent(s -> listFees.add(s));
		getBradesco().ifPresent(s -> listFees.add(s));
		getCef().ifPresent(s -> listFees.add(s));
		getCrefisa().ifPresent(s -> listFees.add(s));
		getItau().ifPresent(s -> listFees.add(s));
		getMercadoPago().ifPresent(s -> listFees.add(s));
		getNuBank().ifPresent(s -> listFees.add(s));
		getPan().ifPresent(s -> listFees.add(s));
		getSafra().ifPresent(s -> listFees.add(s));
		getSicredi().ifPresent(s -> listFees.add(s));

		return listFees;
	}

	public Optional<BankConversionFee> fallBack(){
		return Optional.empty();
	}
	
	private Optional<BankConversionFee> getC6() {
		return Optional.ofNullable(bankConversionFees.getC6Fees().getBody());
	}

	private Optional<BankConversionFee> getAgibank() {
		return Optional.ofNullable(bankConversionFees.getAgibankFees().getBody());
	}


	@HystrixCommand(fallbackMethod = "fallBack")
	private Optional<BankConversionFee> getSicoob() {
		return Optional.ofNullable(bankConversionFees.getSicoobFees().getBody());
	}

	private Optional<BankConversionFee> getBanrisul() {
		return Optional.ofNullable(bankConversionFees.getBanrisulFees().getBody());
	}

	private Optional<BankConversionFee> getBmg() {
		return Optional.ofNullable(bankConversionFees.getBmgFees().getBody());
	}

	private Optional<BankConversionFee> getBradesco() {
		return Optional.ofNullable(bankConversionFees.getBradescoFees().getBody());
	}

	private Optional<BankConversionFee> getCef() {
		return Optional.ofNullable(bankConversionFees.getCefFees().getBody());
	}

	private Optional<BankConversionFee> getCrefisa() {
		return Optional.ofNullable(bankConversionFees.getCrefisaFees().getBody());
	}

	private Optional<BankConversionFee> getItau() {
		return Optional.ofNullable(bankConversionFees.getItauFees().getBody());
	}

	private Optional<BankConversionFee> getMercadoPago() {
		return Optional.ofNullable(bankConversionFees.getMercadoPagoFees().getBody());
	}

	private Optional<BankConversionFee> getNuBank() {
		return Optional.ofNullable(bankConversionFees.getNuBankFees().getBody());
	}

	private Optional<BankConversionFee> getPan() {
		return Optional.ofNullable(bankConversionFees.getPanFees().getBody());
	}

	private Optional<BankConversionFee> getSafra() {
		return Optional.ofNullable(bankConversionFees.getSafraFees().getBody());
	}

	private Optional<BankConversionFee> getSicredi() {
		return Optional.ofNullable(bankConversionFees.getSicrediFees().getBody());
	}

}
