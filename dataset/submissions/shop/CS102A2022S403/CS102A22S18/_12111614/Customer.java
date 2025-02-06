import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Customer {
	private static int cnt;
	private int id;
	private String name;
	private ArrayList<Product> shoppingCart;
	private float wallet;
	private Map<Integer, Store> stores;
	
	public Customer(String name, float wallet) {
		cnt++;
		this.id = cnt;
		this.name = name;
		this.wallet = wallet;
		this.shoppingCart = new ArrayList<>();
		this.stores = new HashMap<>();
	}
	
	public boolean rateProduct(Product product, int rating) {
		return product.setRating(rating);
	}
	
	public void updateWallet(float amount) {
		wallet = wallet + amount;
	}
	
	public boolean purchaseProduct(Store store, Product product) {
		boolean flag = store.hasProduct(product);
		if (!flag) {
			return false;
		}
		
		if (wallet < product.getPrice()) {
			return false;
		}
		
		store.transact(product, 0);
		shoppingCart.add(product);
		wallet -= product.getPrice();
		stores.put(product.getId(), store);
		
		return true;
	}
	
	public void viewShoppingCart(SortBy sortMethod) {
		if (sortMethod == SortBy.Rating) {
			shoppingCart.sort(Comparator.comparing(Product::getAvgRating));
		} else if (sortMethod == SortBy.Price) {
			shoppingCart.sort(Comparator.comparing(Product::getPrice));
		}
		
		for (Product p : shoppingCart) {
			System.out.println(p.toString());
		}
	}
	
	public boolean refundProduct(Product product) {
		for (Product p : shoppingCart) {
			if (p.getId() == product.getId()) {
				Store store = stores.get(product.getId());
				store.transact(product, 1);
				updateWallet(product.getPrice());
				shoppingCart.remove(p);
				
				return true;
			}
		}
		
		return false;
	}
	
}
