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
		this.name = name;
		this.wallet = wallet;
		Customer.cnt++;
		this.id = cnt;
		this.shoppingCart = new ArrayList<>();
		this.stores = new HashMap<>();
	}
	
	public boolean rateProduct(Product product, int rating) {
		return product.setRating(rating);
	}
	
	public void updateWallet(float amount) {
		this.wallet += amount;
	}
	
	public boolean purchaseProduct(Store store, Product product) {
		boolean flag = store.hasProduct(product);
		if (flag) {
			if (wallet >= product.getPrice()) {
				store.transact(product, 0);
				shoppingCart.add(product);
				wallet -= product.getPrice();
				
				stores.put(product.getId(), store);
				
				return true;
			}
		}
		
		return false;
	}
	
	public void viewShoppingCart(SortBy sortMethod) {
		if (sortMethod == SortBy.PurchaseTime) {

		} else if (sortMethod == SortBy.Rating) {
			shoppingCart.sort(new Comparator<Product>() {

				@Override
				public int compare(Product o1, Product o2) {
					if(o1.getAvgRating() > o2.getAvgRating()) {
			            return 1;
			        } else if(o1.getAvgRating() < o2.getAvgRating()) {
			        	return -1;
			        }
			       
					return 0;
				}
				
			});
		} else if (sortMethod == SortBy.Price) {
			shoppingCart.sort(new Comparator<Product>() {

				@Override
				public int compare(Product o1, Product o2) {
					if(o1.getPrice() > o2.getPrice()) {
			            return 1;
			        } else if(o1.getPrice() < o2.getPrice()) {
			        	return -1;
			        }
			       
					return 0;
				}
			});
		} 
		
		for (Product p : shoppingCart) {
			System.out.println(p.toString());
		}
		
	}
	public boolean refundProduct(Product product) {
		for (Product p : shoppingCart) {
			if (p.getId() == product.getId()) {
				shoppingCart.remove(product);
				updateWallet(product.getPrice());
				
				Store s = stores.get(product.getId());
				s.transact(product, 1);
				
				return true;
			}
		}
		
		return false;
	}
	
}