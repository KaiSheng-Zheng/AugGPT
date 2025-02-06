import java.util.ArrayList;

public class Product {
	private static int cnt;
	private int id;
	private String name;
	private float price;
	private ArrayList<Integer> ratings;

	public Product(String name, float price) {
		cnt++;
		this.id = cnt;
		this.name = name;
		this.price = price;
		this.ratings = new ArrayList<>(10);
	}

	public boolean setRating(int rating) {
		if (rating < 1 || rating > 5) {
			return false;
		}

		return ratings.add(rating);
	}

	public float getAvgRating() {
		// no isPresent() check, will fail if there is no rating
		return (float) ratings.stream().mapToDouble(a -> a).average().getAsDouble();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Product ID ").append(id)
				.append(", ").append(name)
				.append(", RMB ").append(String.format("%.2f", price))
				.append(", Rating ").append(String.format("%.1f", getAvgRating()));

		return sb.toString();
	}

}
