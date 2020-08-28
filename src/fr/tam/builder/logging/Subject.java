package fr.tam.builder.logging;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private final List<Observer> observers = new ArrayList<Observer>();

	public void attachObserver(Observer pObserver) {
		observers.add(pObserver);
	}

	public void notifyObservers() {
		for (final Observer observer : observers) {
			observer.update();
		}
	}
}
