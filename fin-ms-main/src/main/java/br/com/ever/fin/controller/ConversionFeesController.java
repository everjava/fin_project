package br.com.ever.fin.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ever.fin.model.BankConversionFee;
import br.com.ever.fin.model.ConversionFeeResponse;
import br.com.ever.fin.model.FeesHistory;
import br.com.ever.fin.service.ConversionFees;

/**
 * https://stackoverflow.com/questions/64791975/get-item-from-first-list-of-list-inside-list-java-8
 *
 */
@RestController
@RequestMapping("/conversionfees")
public class ConversionFeesController {

	@Autowired
	private ConversionFees conversionFees;

	@GetMapping("/allFees")
	public ResponseEntity<ConversionFeeResponse> retrieveAllFees() {

		List<BankConversionFee> allFees = conversionFees.getAllFees();
		allFees.forEach(s -> System.out.println(s));

		BankConversionFee minFees = minFees(allFees).orElseGet(BankConversionFee::new);
		BankConversionFee maxFees = maxFees(allFees).orElseGet(BankConversionFee::new);

		ConversionFeeResponse response = ConversionFeeResponse.builder() //
				.maxEmissorNome(maxFees.getEmissorNome()) //
				.maxTaxaConversao(maxFees.getHistoricoTaxas().get(0).getTaxaConversao()) //
				.minEmissorNome(minFees.getEmissorNome()) //
				.minTaxaConversao(minFees.getHistoricoTaxas().get(0).getTaxaConversao()).build();

		// return ResponseEntity.status(HttpStatus.OK).body(allFees);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	private Optional<BankConversionFee> maxFees(List<BankConversionFee> allFees) {
		Comparator<BankConversionFee> comparatorMax = Comparator.comparing( //
				h -> h.getHistoricoTaxas().stream() //
						.map(FeesHistory::getTaxaConversao) //
						.max(Comparator.naturalOrder()).orElseThrow());

		Optional<BankConversionFee> maxx = allFees.stream() //
				.filter(f -> !f.getHistoricoTaxas().isEmpty()) //
				.max(comparatorMax);
		System.out.println("MAXX ==  " + maxx.get());
		return maxx;

	}

	private Optional<BankConversionFee> minFees(List<BankConversionFee> allFees) {
		Comparator<BankConversionFee> comparatorMin = Comparator.comparing( //
				h -> h.getHistoricoTaxas().stream() //
						.map(FeesHistory::getTaxaConversao) //
						.min(Comparator.naturalOrder()) //
						.orElseThrow());

		Optional<BankConversionFee> minn = allFees.stream() //
				.filter(f -> !f.getHistoricoTaxas().isEmpty()) //
				.min(comparatorMin);

		System.out.println("MINN  ==  " + minn.get());
		return minn;

	}

//	private void old(List<BankConversionFee> allFees) {
//		Comparator<FeesHistory> comparator = Comparator.comparingDouble(FeesHistory::getTaxaConversao);
//		FeesHistory minFees = allFees.stream() //
//				.filter(bank -> !bank.getHistoricoTaxas().isEmpty()) //
//				.map(bank -> bank.getHistoricoTaxas().stream().min(comparator).get()) //
//				.min(comparator).get();
//
//		Optional<BankConversionFee> bankMin = allFees.stream() //
//				.filter(bank -> !bank.getHistoricoTaxas().isEmpty()) //
//				.filter(bank -> bank.getHistoricoTaxas().contains(minFees)) //
//				.map(b -> b) //
//				.findFirst();
//		System.err.println("min22 == " + bankMin.get());
//	}

}
