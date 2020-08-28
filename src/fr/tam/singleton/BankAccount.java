package fr.tam.singleton;

public class BankAccount {
	private final String id;
	private Double balance;
	private final String DEFAULT_CURRENCY = "DA";

	public BankAccount (String pId, Double pBalance) {
		id = pId;
		balance = pBalance;
		BankLogger.getInstance().addLog(id, BankActionEnum.ACCOUNT_CREATION, true, pBalance, balance, DEFAULT_CURRENCY);
	}

	public BankAccount (String pId) {
		this(pId, 0.0);
	}

	public void makeDeposit(Double pAmount, String pCurrency) {
		setBalance(getBalance() + pAmount);
		BankLogger.getInstance().addLog(id, BankActionEnum.DEPOSIT, true, pAmount, balance, pCurrency);
	}

	public void withdraw (Double pAmount, String pCurrency) {
		if (pAmount > balance) {
			BankLogger.getInstance().addLog(id, BankActionEnum.WITHDRAWAL, false, pAmount, balance, pCurrency);
		} else {
			setBalance(getBalance() - pAmount);
			BankLogger.getInstance().addLog(id, BankActionEnum.WITHDRAWAL, true, pAmount, balance, pCurrency);
		}
	}

	public String getId () {
		return id;
	}

	public Double getBalance () {
		return balance;
	}

	public void setBalance (Double pBalance) {
		balance = pBalance;
	}
}
