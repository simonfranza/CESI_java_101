package fr.tam.builder.products;

public class ProductBuilder {
	protected String id;
	protected String name;
	protected Double weight;
	protected Double volume;
	protected ProductCategoryEnum category;

	public ProductBuilder(String pId, String pName) {
		id = pId;
		name = pName;
	}

	public ProductBuilder weight(Double pPrice) {
		this.weight = (pPrice != null ? pPrice : -1);
		return this;
	}

	public ProductBuilder volume(Double pVolume) {
		this.volume = (pVolume != null ? pVolume : -1);
		return this;
	}

	public ProductBuilder category(ProductCategoryEnum pCategory) {
		this.category = pCategory;
		return this;
	}

	public Product build() {
		return new Product(this);
	}
}
