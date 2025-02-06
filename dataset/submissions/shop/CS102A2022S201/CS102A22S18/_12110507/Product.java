import java.util.ArrayList;

public class Product {
	private static int cnt;
	private int id;
	private String name;
	private float price;
	private ArrayList<Integer> ratings = new ArrayList<Integer>();

	public Product(String name, float price) {
		this.name = name;
		this.price = price;
		id = ++cnt;
	}

	public boolean setRating(int rating) {
		if (rating < 1 || rating > 5)
			return false;
		ratings.add(Integer.valueOf(rating));
		return true;
	}

	public float getPrice() {
		return price;
	}

	public float getAvgRating() {
		float sum = 0;
		for (Integer i : ratings)
			sum += i.intValue();
		return sum / ratings.size();
	}

	public int getID()
	{
		return id;
	}
	public String toString() {
		int p = Math.round(price * 100), r = Math.round(getAvgRating() * 10);
		return "Product ID " + id + ", " + name + ", RMB " + p / 100 + "." + p % 100 + ", Rating "
				+ r / 10 + "." + r % 10;
	}
}