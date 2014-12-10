package ch.webshop.representation;

import org.hibernate.validator.constraints.NotBlank;

public class Food {

	@NotBlank
	private int id;
	@NotBlank
	private String description;
	@NotBlank
	private double price;

	public Food(int id, String description, double price) {
		this.id = id;
		this.description = description;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}
}
