import java.util.ArrayList;

public class Product {
	
	private static int cnt; 
	private int id; 
	private String name;
	private float price;
	private ArrayList<Integer> ratings; 
	
	public Product(String name, float price) {
		this.name = name;
		this.price = price;
		Product.cnt++;
		this.id = cnt;
		this.ratings = new ArrayList<>();
	}
	
	public boolean setRating(int rating) {
		if (rating < 1 || rating > 5) {
			return false;
		}
		
		return ratings.add(rating);
	}
	
	public float getAvgRating() {
		int sum = 0;
		for (int i = 0; i < ratings.size(); i++) {
			sum += ratings.get(i);
		}
		
		return (float)sum / (float)ratings.size();
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
		String _price = String.format("%.2f", price);
		String _avgRating = String.format("%.1f", getAvgRating());
		
		return String.format("Product ID %d, %s, RMB %s, Rating %s", id, name, _price, _avgRating);
	}
	
}