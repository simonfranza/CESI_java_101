package fr.tam.builder.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger {
	private final String filePath;
	private File logFile;

	public FileLogger (String pFilePath) {
		filePath = pFilePath;
	}

	public void createFileIfNotExist() {
		try {
			logFile = new File(filePath);

			if (logFile.createNewFile()) {
				System.out.println("Created new log file : " + logFile.getName());
			}
		} catch (IOException e) {
			System.out.printf("Could not create file %1$s.\n", filePath);
			e.printStackTrace();
		}
	}

	public void writeToFile(String message) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter(logFile, true));
			out.append(message).append("\n");
			out.close();
		} catch (IOException e) {
			System.out.printf("Could not write logs to %1$s.\n", filePath);
			e.printStackTrace();
		}
	}
}
