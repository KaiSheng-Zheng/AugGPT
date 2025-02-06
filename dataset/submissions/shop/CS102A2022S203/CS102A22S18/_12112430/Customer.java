import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.name=name;this.wallet=wallet;cnt++;id=cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>=product.getPrice()){
            updateWallet(0-product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }else {return false;}
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
                for (Product product : shoppingCart) {
                    System.out.println(product);
                }
        }
        else if (sortMethod==SortBy.Rating){
                Product[] rating = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    rating[i] = shoppingCart.get(i);
                }
                for (int i = 0; i < shoppingCart.size() - 1; i++) {
                    for (int j = 0; j < shoppingCart.size() - 1 - i; j++) {
                        if (shoppingCart.get(j).getAvgRating() > shoppingCart.get(j + 1).getAvgRating()) {
                            Product t = shoppingCart.get(j + 1);
                            rating[j + 1] = shoppingCart.get(j);
                            rating[j] = t;
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(rating[i]);
                }
        }
        else if (sortMethod==SortBy.Price){
                Product[] price = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    price[i] = shoppingCart.get(i);
                }
                for (int i = 0; i < shoppingCart.size() - 1; i++) {
                    for (int j = 0; j < shoppingCart.size() - 1 - i; j++) {
                        if (shoppingCart.get(j).getPrice() > shoppingCart.get(j + 1).getPrice()) {
                            Product temp = shoppingCart.get(j + 1);
                            price[j + 1] = shoppingCart.get(j);
                            price[j] = temp;
                        }
                        else if (shoppingCart.get(j).getPrice() == shoppingCart.get(j + 1).getPrice()
                        &&shoppingCart.get(j).getPrice() > shoppingCart.get(j + 1).getPrice()){
                            Product temp = shoppingCart.get(j + 1);
                            price[j + 1] = shoppingCart.get(j);
                            price[j] = temp;
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(price[i]);
                }
        }

    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);updateWallet(product.getPrice());
            return true;
        }else {return false;}
    }
}
