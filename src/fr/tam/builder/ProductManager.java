package fr.tam.builder;

import fr.tam.builder.logging.Subject;
import fr.tam.builder.products.Product;
import fr.tam.builder.products.ProductBuilder;
import fr.tam.builder.products.ProductCategoryEnum;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManager extends Subject {
	private static final ProductManager INSTANCE = new ProductManager();
	private List<Product> products;

	public ProductManager () {
		products = new ArrayList<Product>();
	}

	public static ProductManager getInstance() {
		return INSTANCE;
	}

	public Product addProduct(String id, String name, @Nullable Double weight, @Nullable Double volume, @Nullable ProductCategoryEnum category) {
		Product product = new ProductBuilder(id, name)
				                  .weight(weight)
				                  .volume(volume)
				                  .category(category)
				                  .build();

		products.add(product);
		notifyObservers();
		return product;
	}

	public List<Product> getProducts () {
		return products;
	}

	public String displayProducts() {
		return products.stream().map(Product::toString).collect(Collectors.joining("\n"));
	}
}
