import java.util.ArrayList;
public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            shoppingCart.add(product);
            wallet -= product.getPrice();
            store.transact(product,0);
            product.setStore(store);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        int i, j;
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product a : shoppingCart) {
                System.out.println(a);
            }
        } else if (sortMethod == SortBy.Price) {
            for (i = 1; i < shoppingCart.size(); i++) {
                for (j = 1; j <= shoppingCart.size() - i; j++) {
                    if (shoppingCart.get(j - 1).getPrice() > shoppingCart.get(j).getPrice()) {
                        Product temp = shoppingCart.get(j - 1);
                        shoppingCart.set(j - 1, shoppingCart.get(j));
                        shoppingCart.set(j, temp);
                    }
                }
            }
            for (Product a : shoppingCart) {
                System.out.println(a);
            }
        } else {
            for (i = 1; i < shoppingCart.size(); i++) {
                for (j = 1; j <= shoppingCart.size() - i; j++) {
                    if (shoppingCart.get(j - 1).getAvgRating() > shoppingCart.get(j).getAvgRating()) {
                        Product temp = shoppingCart.get(j - 1);
                        shoppingCart.set(j - 1, shoppingCart.get(j));
                        shoppingCart.set(j, temp);
                    }
                }
                for (Product a : shoppingCart) {
                    System.out.println(a);
                }
            }
        }
    }
        public boolean refundProduct (Product product){
        Boolean flag=false;
        for(Product a:shoppingCart){
                  if(a==product) flag=true;
        }
              if(flag){
                  shoppingCart.remove(product);
               product.getStore().transact(product,1);
               wallet+=product.getPrice();
               return true;
        }else {
                  return false;
              }
    }
}

