package fr.tam.builder.logging;

import fr.tam.builder.ProductManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProductLogger extends Observer {
	protected ProductManager subject;
	protected FileLogger fileLogger;
	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

	public ProductLogger (ProductManager pSubject, String pLoggingFilePath) {
		this.subject = pSubject;
		this.subject.attachObserver(this);
		this.fileLogger = new FileLogger(pLoggingFilePath.isEmpty() ? "productCreationLogs.txt" : pLoggingFilePath);
		fileLogger.createFileIfNotExist();
	}

	@Override
	public void update () {
		String message = String.format(
			"[%1$s]\t\t%2$s",
			dtf.format(LocalDateTime.now()),
			subject.getProducts().get(subject.getProducts().size() - 1).toString()
		);
		System.out.println(message);
		fileLogger.writeToFile(message);
	}


}
