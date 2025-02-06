import java.util.ArrayList;
public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private ArrayList<Store> cargolist;
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
        this.shoppingCart = new ArrayList<>();
        this.cargolist = new ArrayList<>();
    }

    public boolean rateProduct(Product product,int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if ((store.hasProduct(product)) && (this.wallet >= product.getPrice())){
            shoppingCart.add(product);
            cargolist.add(store);
            float u = -product.getPrice();
            updateWallet(u);
            store.transact(product,0);
            return true;
        }else{
            return false;
        }
    }
    public boolean refundProduct(Product product){
          if (shoppingCart.contains(product)){
              int u = shoppingCart.indexOf(product);
              cargolist.get(shoppingCart.indexOf(product)).transact(product,1);
              updateWallet(product.getPrice());
              shoppingCart.remove(product);
              return true;
          }else {
              return false;
          }

    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }else if (sortMethod == SortBy.Price){
            ArrayList<Product> PriceTag = new ArrayList<>(shoppingCart);
            for (int i = 0; i < PriceTag.size() - 1; i++) {
                for (int j = 0; j < PriceTag.size() - 1 - i; j++) {
                    if (PriceTag.get(j).getPrice() > PriceTag.get(j + 1).getPrice() ) {
                        Product temp = PriceTag.get(j);
                        PriceTag.set(j, PriceTag.get(j + 1));
                        PriceTag.set(j + 1, temp);
                    }
                }
            }
            for (int i = 0; i < PriceTag.size(); i++) {
                System.out.println(PriceTag.get(i));
            }
        }else if (sortMethod == SortBy.Rating){
            ArrayList<Product> Rates = new ArrayList<>(shoppingCart);
            for (int i = 0; i < Rates.size() - 1; i++) {
                for (int j = 0; j < Rates.size() - 1 - i; j++) {
                    if (Rates.get(j).getAvgRating() > Rates.get(j + 1).getAvgRating() ) {
                        Product temp = Rates.get(j);
                        Rates.set(j, Rates.get(j + 1));
                        Rates.set(j + 1, temp);
                    }
                }
            }
            for (int i = 0; i < Rates.size(); i++) {
                System.out.println(Rates.get(i));
            }
        }
    }

}