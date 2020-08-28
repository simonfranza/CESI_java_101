package fr.tam.singleton;

public class Main {

	public static void main(String[] args) {

		final BankLogger logger = BankLogger.getInstance();
		BankAccount accountA = new BankAccount("123");
		BankAccount accountB = new BankAccount("321");

		accountA.makeDeposit(100.0, "DA");
		accountA.withdraw(120.0, "DA");
		accountA.withdraw(80.0, "DA");

		accountB.makeDeposit(200.0, "DA");
		accountB.withdraw(110.0, "DA");

		System.out.println(logger.getAllLogs() + "\n\n\n");
		System.out.println(logger.getLogsByAccountId(accountA.getId()) + "\n\n\n");
		System.out.println(logger.getLogsByAccountId(accountB.getId()) + "\n\n\n");


		System.out.println(logger.getAllLogsViaHashmap() + "\n\n\n");
		System.out.println(logger.getLogsByAccountIdViaHashmap(accountA.getId()) + "\n\n\n");
		System.out.println(logger.getLogsByAccountIdViaHashmap(accountB.getId()));
	}
}
