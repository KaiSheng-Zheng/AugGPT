import java.util.ArrayList;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name="";
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet=0;

    public Customer(String name, float wallet){
        cnt++;
       id=cnt;
       this.wallet=wallet;
       this.name=name;
    }


    public boolean rateProduct(Product product, int rating){
      return   product.setRating(rating);

    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product) {
        int a=0;
        for (int i = 0; i < store.getProductList().size(); i++) {
            if (store.hasProduct(product) && wallet >= product.getPrice()) {
                updateWallet(-product.getPrice());
                shoppingCart.add(product);
                store.transact(product, 0);
               a=1;
            }
        }
       if(a==0){
           return false;
       }else{
           return true;
       }
    }
    public void viewShoppingCart(SortBy sortMethod) {
        if (shoppingCart.size() != 0) {
            if (sortMethod == SortBy.PurchaseTime) {
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
            }
            if (sortMethod == SortBy.Rating) {
                for (int x = 0; x < shoppingCart.size() - 1; x++) {
                    for (int y = x + 1; y < shoppingCart.size(); y++) {
                        if (shoppingCart.get(x).getAvgRating() > shoppingCart.get(y).getAvgRating()) {
                            Product temp = shoppingCart.get(x);
                            shoppingCart.set(x, shoppingCart.get(y));
                            shoppingCart.set(y, temp);
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
            }

            if (sortMethod == SortBy.Price) {
                for (int x = 0; x < shoppingCart.size() - 1; x++) {
                    for (int y = x + 1; y < shoppingCart.size(); y++) {
                        if (shoppingCart.get(x).getPrice() > shoppingCart.get(y).getPrice()) {
                            Product temp = shoppingCart.get(x);
                            shoppingCart.set(x, shoppingCart.get(y));
                            shoppingCart.set(y, temp);
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
            }

        }
    }
}
