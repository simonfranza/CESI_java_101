package fr.tam.builder.logging;

public abstract class Observer {
	protected Object subject;
	public abstract void update();
}
