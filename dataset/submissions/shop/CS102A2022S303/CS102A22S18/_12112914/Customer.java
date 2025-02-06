import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private float wallet;
    private ArrayList<Store> storeCart = new ArrayList<Store>();

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            wallet = wallet - product.getPrice();
            shoppingCart.add(product);
            storeCart.add(store);
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> b = new ArrayList<Product>();
        for (int i = 0; i < shoppingCart.size(); i++) {
            b.add(shoppingCart.get(i));
        }

        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f", shoppingCart.get(i).getId(),
                        shoppingCart.get(i).getName(), shoppingCart.get(i).getPrice(), shoppingCart.get(i).getAvgRating());
                System.out.println();
            }
        } else if (sortMethod.equals(SortBy.Rating)) {

            Collections.sort(b, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getAvgRating()>=o2.getAvgRating()){
                        return 1;
                    }else {
                        return  -1;
                    }
                }
            });
            for (int i = 0; i < b.size(); i++) {
                System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f", b.get(i).getId(),
                        b.get(i).getName(), b.get(i).getPrice(), b.get(i).getAvgRating());
                System.out.println();
            }



        }else if (sortMethod.equals(SortBy.Price)){
            Collections.sort(b, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getPrice()>=o2.getPrice()){
                        return 1;
                    }else {
                        return  -1;
                    }
                }
            });
            for (int i = 0; i < b.size(); i++) {
                System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f", b.get(i).getId(),
                        b.get(i).getName(), b.get(i).getPrice(), b.get(i).getAvgRating());
                System.out.println();
            }
        }
    }

    public boolean refundProduct(Product product){
      if (hasProduct(product)){
          wallet+=product.getPrice();
          int index = shoppingCart.indexOf(product);
          Store back = storeCart.get(index);
          back.transact(product,1);
          storeCart.remove(index);
          shoppingCart.remove(product);
          return true;
      }else return false;
    }

    public boolean hasProduct(Product product){
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).equals(product)){
                return true;
            }
        }
        return false;
    }
}
