package br.com.ever.fin.enums;

/**
 * taxaTipoGasto
 */
public enum RateTypeSpent {

	CREDIT("Crédito"), DEBIT("Débito à conta");

	private String type;

	private RateTypeSpent(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
