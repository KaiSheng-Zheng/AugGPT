import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        cnt+=1;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.getProductList().contains(product)&&wallet>= product.getPrice()){
            updateWallet(0 - product.getPrice());
            store.transact(product, 0);
            shoppingCart.add(product);
            return true;
        }
        else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch(sortMethod) {
		case PurchaseTime:
			break;
		case Rating:
			shoppingCart.sort(Comparator.comparing(Product::getAvgRating));
			break;
		case Price:
			shoppingCart.sort(Comparator.comparing(Product::getPrice));
			break;
		}
		
		for (Product p : shoppingCart) {
			System.out.println(p.toString());
		}
    }

    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            return true;
        }
        else{
            return false;
        }
    }
}