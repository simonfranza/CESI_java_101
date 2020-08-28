package fr.tam.builder.products;

public class Product {
	private final String id;
	private final String name;
	private final Double weight;
	private final Double volume;
	private final ProductCategoryEnum category;

	public Product(ProductBuilder pBuilder) {
		id = pBuilder.id;
		name = pBuilder.name;
		weight = pBuilder.weight;
		volume = pBuilder.volume;
		category = pBuilder.category;
	}

	public String getId () {
		return id;
	}

	public String getName () {
		return name;
	}

	public Double getWeight () {
		return weight;
	}

	public Double getVolume () {
		return volume;
	}

	public ProductCategoryEnum getCategory () {
		return category;
	}

	@Override
	public String toString () {
		return String.format("%-8s %-35s %-10s %-10s %-20s",
				id,
				name,
				(weight != - 1 ? weight.toString() + "kg" : "NaN"),
				(volume != - 1 ? volume.toString() + "L" : "NaN"),
				(category != null ? category.toString() : "NaN")
		);
	}
}
