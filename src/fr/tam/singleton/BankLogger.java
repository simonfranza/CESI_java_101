package fr.tam.singleton;

import fr.tam.singleton.utils.ConsoleColors;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public final class BankLogger {
	private static BankLogger INSTANCE;
	private final List<String> logs;

	private final HashMap<String, List<String>> logsByAccountId;
	private final NumberFormat formatter = new DecimalFormat("#0.00");

	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

	private BankLogger () {
		logs = new ArrayList<String>();
		logsByAccountId = new HashMap<String, List<String>>();
	}

	public static synchronized BankLogger getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BankLogger();
		}
		return INSTANCE;
	}

	/**
	 * Generates a log message from a specified action, whether or not
	 *      is was a success and various information concerning account.
	 *
	 * @return String.
	 */
	private String generateLogMessage(BankActionEnum action, Boolean isSuccess, Double actionAmount, Double finalBalance, String currency) {
		String logMessage = "";

		switch (action) {
			case DEPOSIT -> {
				logMessage = String.format("%1$sDeposited %2$s %3$s. New balance : %4$s %5$s",
					ConsoleColors.ANSI_RESET,
					formatter.format(actionAmount),
					currency,
					formatter.format(finalBalance),
					currency
				);
			}
			case WITHDRAWAL -> {
				if (isSuccess) {
					logMessage = String.format("%1$sWithdrew %2$s %3$s from account. New balance: %4$s %5$s",
						ConsoleColors.ANSI_RESET,
						formatter.format(actionAmount),
						currency,
						formatter.format(finalBalance),
						currency
					);
				} else {
					logMessage = String.format(
						"%1$sTried to withdraw %2$s %3$s from account. Aborted due to insufficient funds. Current balance: %4$s %5$s%6$s",
						ConsoleColors.ANSI_RED,
						formatter.format(actionAmount),
						currency,
						formatter.format(finalBalance),
						currency,
						ConsoleColors.ANSI_RESET
					);
				}
			}
			case ACCOUNT_CREATION -> {
				logMessage = String.format("%1$sAccount created. Current balance : %2$s %3$s.%4$s",
					ConsoleColors.ANSI_BLUE,
					formatter.format(finalBalance),
					currency,
					ConsoleColors.ANSI_RESET
				);
			}
		}

		return logMessage;
	}

	/**
	 * Logs the action made onto a banking account.
	 *
	 * Uses {@link #generateLogMessage(BankActionEnum, Boolean, Double, Double, String)} to create the message.
	 */
	public void addLog(String accountId, BankActionEnum action, Boolean isSuccess, Double actionAmount, Double finalBalance, String currency) {
		String log = String.format("%1$s[%2$s]%3$s #%4$s : %5$s%6$s",
			ConsoleColors.ANSI_CYAN,
			dtf.format(LocalDateTime.now()),
			ConsoleColors.ANSI_YELLOW,
			accountId,
			generateLogMessage(action, isSuccess, actionAmount, finalBalance, currency),
			ConsoleColors.ANSI_RESET
		);

		logs.add(log);
		if (!logsByAccountId.containsKey(accountId)) {
			logsByAccountId.put(accountId, new ArrayList<String>());
		}

		logsByAccountId.get(accountId).add(log);
	}

	/**
	 * Retrieves logs from all bank accounts stored inside the arrayList version of the logger.
	 *
	 * @return String.
	 */
	public String getAllLogs() {
		return String.format("================== All banking logs ==================\n%1$s", String.join("\n", logs));
	}

	/**
	 * Retrieves logs a specific bank account stored inside the arrayList version of the logger.
	 *
	 * @return String.
	 */
	public String getLogsByAccountId(String pAccountId) {
		List<String> accountLogs = logs.stream()
			                           .filter(msg -> msg.matches("^.*#" + pAccountId + ".*"))
			                           .collect(Collectors.toList());

		return String.format("================== Banking logs for account %1$s ==================\n%2$s", pAccountId, String.join("\n", accountLogs));
	}

	/**
	 * Retrieves logs from all bank accounts stored inside the hashmap version of the logger.
	 *
	 * @return String.
	 */
	public String getAllLogsViaHashmap() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("================== All banking logs via Hashmap ==================\n");

		for (List<String> logs : logsByAccountId.values()) {
			stringBuilder.append(String.join("\n", logs)).append("\n");
		}
		return stringBuilder.toString();
	}

	/**
	 * Retrieves logs from a specific bank account stored inside the hashmap version of the logger.
	 *
	 * @return String.
	 */
	public String getLogsByAccountIdViaHashmap(String pAccountId) {
		return String.format(
			"================== Banking logs for account %1$s via Hashmap ==================\n%2$s",
			pAccountId,
			String.join("\n", logsByAccountId.get(pAccountId))
		);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}