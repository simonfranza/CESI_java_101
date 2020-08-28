package fr.tam.factory.moulds;

import fr.tam.factory.utils.ConsoleColors;

public abstract class Mould {
	private final String color;
	private final String shape;
	protected boolean wholesalerOnly = false;

	public Mould (String pColor, String pShape) {
		color = pColor;
		shape = pShape;
	}

	public String getColor () {
		return color;
	}

	public String getShape () {
		return shape;
	}

	@Override
	public String toString () {
		return String.format("%1$sSuccessfully created a new mould! It is a %2$s %3$s, how nice!%4$s",
				ConsoleColors.ANSI_GREEN,
				getColor(),
				getShape(),
				wholesalerOnly ? ConsoleColors.ANSI_RED + "\n=== It can only be sold to wholesalers, though ===" + ConsoleColors.ANSI_RESET : ConsoleColors.ANSI_RESET);
	}
}
