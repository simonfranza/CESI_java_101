package fr.tam.factory;

import fr.tam.factory.moulds.Mould;

public class Main {
	public static void main(String[] args) {
		MouldFactory factory = new MouldFactory();
		Mould mould;
		for (final MouldModelEnum mouldModel : MouldModelEnum.values()) {
			System.out.println("\nGenerating a new mould, please wait...");
			mould = factory.createMould(mouldModel);
			System.out.println(mould.toString());
		}
	}
}
