import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){
        boolean t=product.setRating(rating);
        return t;
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            wallet-=product.getPrice();
            store.transact(product,0);
            shoppingCart.add(product);
            return true;
        }else return false;
    }


    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.Price){

        }
        if(sortMethod==SortBy.Rating){

        }
        for (int i=0;i<shoppingCart.size();i++) {
            Product p=shoppingCart.get(i);
            System.out.println("Product ID "+p.getId()+", "+p.getName()+", RMB "+String.format("%.2f",p.getPrice())+", Rating "+String.format("%.1f",p.getAvgRating()));
        }
    }
    public boolean refundProduct(Product product) {
    if(shoppingCart.contains(product)){
        shoppingCart.remove(product);
        wallet+=product.getPrice();
        return true;
    }else return false;
    }
}
