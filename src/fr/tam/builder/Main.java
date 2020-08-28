package fr.tam.builder;

import fr.tam.builder.logging.ProductLogger;
import fr.tam.builder.products.ProductCategoryEnum;

public class Main {

	public static void main(String[] args) {
		final ProductManager productManager = ProductManager.getInstance();
		final ProductLogger logger = new ProductLogger(productManager, "");

		productManager.addProduct("0001", "Essentielb ERCV180-55v1", null, 250.0, ProductCategoryEnum.FRIDGE);
		productManager.addProduct("0002", "Haier HB18FGSAAA", null, 500.0, ProductCategoryEnum.FRIDGE);
		productManager.addProduct("0003", "Listo RML 504", null, 42.0, ProductCategoryEnum.FRIDGE);

		productManager.addProduct("0004", "Essentielb EFMP 104i", 44.0, 72.0, ProductCategoryEnum.OVEN);
		productManager.addProduct("0005", "Bosch HBG672BS2 Série 8", 40.0, 71.0, ProductCategoryEnum.OVEN);
		productManager.addProduct("0006", "Whirlpool AKP471NB01", 43.0, 65.0, ProductCategoryEnum.OVEN);

		productManager.addProduct("0007", "LG 65UN74006 65\"", 22.4, null, ProductCategoryEnum.TELEVISION);
		productManager.addProduct("0008", "Samsung QE75Q75T 2020 75\"", 39.5, null, ProductCategoryEnum.TELEVISION);
		productManager.addProduct("0009", "Hisense 43A7500F 43\"", 8.9, null, ProductCategoryEnum.TELEVISION);

	}
}
