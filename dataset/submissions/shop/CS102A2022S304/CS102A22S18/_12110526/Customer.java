

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Customer {
	private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
	private int id; // unique for each customer and the value is set to cnt.
	private String name;
	private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty;
	private float wallet; 
	
	public Customer(String name, float wallet) {
		cnt++;
		id=cnt;
		this.name=name;
		this.wallet=wallet;
		this.shoppingCart=new ArrayList<>(0);
	}

	//A customer can rate a product using this method.
	public boolean rateProduct(Product product, int rating) {
		
			if(rating <=5&&rating>=1) {
				return true;}
			else {return false;}
		}
	
	public void updateWallet(float amount) {
		wallet=wallet+amount;
	}
	public boolean purchaseProduct(Store store, Product product) {
		boolean has1=false;
		
		if(store.hasProduct(product) ) {
			has1=true;
		}
		boolean enough =false;
		if(wallet >= product.getPrice()) {
				enough = true;
		}
		if(has1&&enough) {
			store.transact(product,0);
            shoppingCart.add(product);
            float pay = -product.getPrice();
            updateWallet(pay);
			return true;
			}else {
			return false;}
	}
    public void viewShoppingCart(SortBy sortMethod) {
    	int case1=0;
    	if(sortMethod == SortBy.PurchaseTime) {
    		case1=1;
    	}
    	if(sortMethod == SortBy.Price){ case1=2;}
    	if (case1 ==1) {
        	int l = shoppingCart.size();
        	for(int i =0;i<l ;i++) {
        		Product y =shoppingCart.get(i);
        		System.out.println(y.toString());
        	}
            
        } else {
        	ArrayList<Product> cart1 = shoppingCart;
            if (sortMethod == SortBy.Price) {
                Collections.sort(cart1, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                    	float a = o1.againgetAvgRating();
                    	float b = o2.againgetAvgRating();
                    	if (a <b) {return 1;
                        } else if (a< b) {return -1;
                        } else { return 0;}
                    	} });
                
                int l =cart1.size();
                for(int i =0;i<l;i++) {
                	Product y =shoppingCart.get(i);
                	 System.out.println(y.toString());
                }
            } else {
                Collections.sort(cart1, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                    	float a = o1.againgetAvgRating();
                    	float b = o2.againgetAvgRating();
                        if (a > b) {
                            return 1;
                        } else if (a< b) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }});
                int l =cart1.size();
                for(int i =0;i<l;i++) {
                	Product y =shoppingCart.get(i);
                	 System.out.println(y.toString());
                }
            }
        }
    }

	//refund
	public boolean refundProduct(Product product) {
			return true;}
	

}
