import java.util.ArrayList;

public class Store {
	private static int cnt;
	private int id;
	private String name;
	private ArrayList<Product> productList;
	private float income;
	
	public Store(String name) {
		this(name, new ArrayList<>(10), 0);
	}
	
	public Store(String name, ArrayList<Product> productList, float income) {
		cnt++;
		this.id = cnt;
		this.name = name;
		this.income = income;
		this.productList = productList;
	}
	
	public boolean hasProduct(Product product) {
		boolean flag = false;
		
		for (Product p : productList) {
			if (p.getId() == product.getId()) {
				flag = true;
				break;
			}
		}
		
		return flag;
	}
	
	public boolean addProduct(Product product) {
		boolean flag = true;
		
		for (Product p : productList) {
			if (p.getId() == product.getId()) {
				flag = false;
				break;
			}
		}
		
		if (flag) {
			productList.add(product);
		}
		
		return flag;
	}
	
	public boolean removeProduct(Product product) {
		for (Product p : productList) {
			if (p.getId() == product.getId()) {
				productList.remove(p);
				return true;
			}
		}
		
		return false;
	}
	
	public ArrayList<Product> getProductList() {
		return productList;
	}
	
	public void transact(Product product, int method) {
		boolean flag = false;
		
		if (method == 0) {
			flag = removeProduct(product);
			if (flag) {
				income += product.getPrice();
			}
			
			return;
		}
		
		flag = addProduct(product);
		if (flag) {
			income -= product.getPrice();
		}
	}
	
	public float getIncome() {
		return income;
	}
	
}