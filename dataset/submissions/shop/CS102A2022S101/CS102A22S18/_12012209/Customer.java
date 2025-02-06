import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }
    
    public void updateWallet(float amount) {
        wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if(store.hasProduct(product)&&wallet>=product.getPrice())
        {
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(shoppingCart.size(),product);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod) {

        if(sortMethod.equals(SortBy.Price))
        {
            shoppingCart.sort((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
        }
        else if(sortMethod.equals(SortBy.Rating))
        {
            shoppingCart.sort((o1, o2) -> (int) (o1.getAvgRating() - o2.getAvgRating()));
        }

        for (int i=0;i<shoppingCart.size();i++) {
            System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\r\n",
                    shoppingCart.get(i).getId(), shoppingCart.get(i).getName(),
                    shoppingCart.get(i).getPrice(), shoppingCart.get(i).getAvgRating());
        }
    }

    public boolean refundProduct(Product product) {
        return true;
    }
}