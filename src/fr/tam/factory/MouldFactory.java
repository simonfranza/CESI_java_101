package fr.tam.factory;

import fr.tam.factory.moulds.*;

public class MouldFactory {
	public Mould createMould(MouldModelEnum pModel) {
		return switch(pModel) {
			case A -> new MouldA();
			case B -> new MouldB();
			case C -> new MouldC();
			case D -> new MouldD();
			case E -> new MouldE();
		};
	}
}

