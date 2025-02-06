import java.util.ArrayList;

public class Store {
	
	private static int cnt;
	private int id;
	private String name;
	private ArrayList<Product> productList;
	private float income;
	
	public Store(String name) {
		this.name = name;
		Store.cnt++;
		this.id = cnt;
		this.income = 0;
		this.productList = new ArrayList<>();
	}
	
	public Store(String name, ArrayList<Product> productList, float income) {
		this.name = name;
		Store.cnt++;
		this.id = cnt;
		this.income = income;
		this.productList = productList;
	}
	
	public boolean hasProduct(Product product) {
		for (Product p : productList) {
			if (p.getId() == product.getId()) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean addProduct(Product product) {
		for (Product p : productList) {
			if (p.getId() == product.getId()) {
				return false;
			}
		}
		
		return productList.add(product);
	}
	
	public boolean removeProduct(Product product) {
		for (Product p : productList) {
			if (p.getId() == product.getId()) {
				return productList.remove(p);
			}
		}
		
		return false;
	}
	
	public ArrayList<Product> getProductList() {
		return productList;
	}
	
	public void transact(Product product, int method) {
		if (method == 0) {
			for (Product p : productList) {
				if (p.getId() == product.getId()) {
					income += product.getPrice();
					productList.remove(p);
					return;
				}
			}
		} else if (method == 1){
			addProduct(product);
			income -= product.getPrice();
		}
	}
	
	public int getId() {
		return id;
	}
	
}