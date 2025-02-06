import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.cnt ++;
        this.name = name;
        this.id = cnt ;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet >= product.getPrice()){
            store.transact(product,0);
            this.shoppingCart.add(product);
            this.wallet -= product.getPrice();
            return true;
        }
        else
            return false;
    }
    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                    System.out.println(this.shoppingCart.get(i));
            }
        } else if (sortMethod == SortBy.Rating) {
            ArrayList<Product> newShoppingCart = this.shoppingCart;
            for (int i = 0; i < newShoppingCart.size() - 1; i++) {
                for (int j = 0; j < newShoppingCart.size() - 1 - i; j++) {
                    if (newShoppingCart.get(j).getAvgRating() > newShoppingCart.get(j + 1).getAvgRating()) {
                        Product temp = newShoppingCart.get(j);
                        newShoppingCart.set(j, newShoppingCart.get(j + 1));
                        newShoppingCart.set(j + 1, temp);
                    }
                }
            }
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                    System.out.println(newShoppingCart.get(i).toString());
                
            }
        } else if (sortMethod == SortBy.Price) {
            ArrayList<Product> newShoppingCart = this.shoppingCart;
            for (int i = 0; i < newShoppingCart.size() - 1; i++) {
                for (int j = 0; j < newShoppingCart.size() - 1 - i; j++) {
                    if (newShoppingCart.get(j).getAvgRating() > newShoppingCart.get(j + 1).getAvgRating()) {
                        Product temp = newShoppingCart.get(j);
                        newShoppingCart.set(j, newShoppingCart.get(j + 1));
                        newShoppingCart.set(j + 1, temp);
                    }
                }
            }
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                    System.out.println(newShoppingCart.get(i).toString());
                
            }

        }
    }

}