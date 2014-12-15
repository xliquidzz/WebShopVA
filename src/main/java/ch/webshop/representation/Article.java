package ch.webshop.representation;

public class Article {

	private int id;
	private int categoryId;
	private String name;
	private double price;

	public Article(int id, int categoryId, String name, double price) {
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public int getCategoryId() { return categoryId; }

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}
