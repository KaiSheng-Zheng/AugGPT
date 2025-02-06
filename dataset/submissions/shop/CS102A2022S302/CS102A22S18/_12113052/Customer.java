import java.util.ArrayList;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;//the list of things to buy
    private float wallet;
    private ArrayList<ArrayList<Object>> tag;
    
    public Customer(String name,float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
        tag = new ArrayList<ArrayList<Object>>();
        shoppingCart = new ArrayList<Product>();
    }
    public boolean rateProduct(Product product,int rating){
        if (rating>0&&rating<6){
        	product.setRating(rating);
            return true;
        }else return false;
    }
    public void updateWallet(float amount){
    	wallet += amount;
    }
    public boolean purchaseProduct(Store store,Product product){
        if (wallet>product.getPrice() && store.hasProduct(product)){
        	shoppingCart.add(product);
        	updateWallet(-product.getPrice());
        	store.transact(product, 0);
        	ArrayList<Object> t = new ArrayList<>();
        	t.add(store);
        	t.add(product);
        	tag.add(t);
            return true;
        }else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
    	ArrayList<Product> pl = shoppingCart;
		Product min;
		Product temp;
    	switch(sortMethod) {
    	case PurchaseTime:
    		for(Product i:shoppingCart) System.out.println(i);
    		break;
    	case Rating:
    		for(int i =0;i<pl.size();i++) {
    			min = pl.get(i);
    			for(int j =i+1 ;j<pl.size();j++) {
    				if(pl.get(j).getAvgRating()<min.getAvgRating()) {
    					temp = pl.get(j);
    					pl.set(j, min);
    					min = temp;
    				}
    			}
    			System.out.println(min);
    		}
    		break;
    	case Price:
    		for(int i =0;i<pl.size();i++) {
    			min = pl.get(i);
    			for(int j =i+1 ;j<pl.size();j++) {
    				if(pl.get(j).getPrice()<min.getPrice()) {
    					temp = pl.get(j);
    					pl.set(j, min);
    					min = temp;
    				}
    			}
    			System.out.println(min);
    		}
    		break;
    	}
    }
    public boolean refundProduct(Product product){
    	for(int i = 0 ; i<tag.size();i++) {
    		if(tag.get(i).get(1)==product) {
    			Store s = (Store)tag.get(i).get(0);
    			s.transact(product, 1);
    			updateWallet(product.getPrice());
    			shoppingCart.remove(product);
    			tag.remove(tag.get(i));
    			return true;
    		}
    	}
    	return false;
    }

} 