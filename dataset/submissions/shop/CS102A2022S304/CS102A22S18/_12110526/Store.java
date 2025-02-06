

import java.util.ArrayList;

public class Store {
	private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
	private int id;; // unique for each store and the value is set to cnt.
	private String name;
	private ArrayList<Product> productList = new ArrayList<>(0);
	private float income=0;
	public Store(String name) {
		this.income=0;
		cnt = cnt+1;
		id=cnt;
		this.name = name;
	}
	
	public Store(String name, ArrayList<Product> productList, float income) {
		this.name = name;
		this.productList=productList;
		this.income = income;
		cnt++;
		this.id=cnt;
	}  

	public boolean hasProduct(Product product) {
			int l = productList.size();
			int has = 0;
			 for (int i = 0;i<l;i++){
		            if (productList.get(i).getId() == product.getId()) {
		                has=1;break;
            }}
        if(has ==0) {
        return false;
        }else {return true;}
        }

	
	public boolean addProduct(Product product) {
		
		if(productList.contains(product)) {
			return false;
		}else {
			productList.add(product);
			return true ;
		}
    }
	public boolean removeProduct(Product product) {
        if(productList.contains(product)) {
        	for(Product item:productList) {
        		if(item.equals(product)) {
        			productList.remove(item);
        			break;
        		}       		
        	}
               return true;
            } else {
            return true;
        }
	}
	public ArrayList<Product> getProductList(){
		return productList;
	}
	public void transact(Product product, int method) {
        if (method == 0){
            productList.remove(product);
            float shouru = product.getPrice();
            income =income+ shouru;
        }
        if(method == 1){
            addProduct(product);
            float shouru = product.getPrice();
            income =income-shouru;
            
        }
    }

}




