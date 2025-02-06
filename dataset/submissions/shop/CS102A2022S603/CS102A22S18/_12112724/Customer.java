import java.util.ArrayList;
import java.util.Arrays;
public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart =new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
        shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }
    public void updateWallet(float amount) {
        wallet = amount + wallet;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            shoppingCart.add(product);
            wallet=wallet- product.getPrice();
            store.transact(product,0);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.Price)) {
            Float[] a = new Float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                a[i] = shoppingCart.get(i).getPrice();
            }
            Arrays.sort(a);
            ArrayList<Product> shoppingCart1 = new ArrayList<>();
            ArrayList<Product> shoppingCart2 = shoppingCart ;
            int length=a.length;
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < length; k++) {
                    if (a[j] == shoppingCart2.get(k).getPrice()) {
                        shoppingCart1.add(shoppingCart2.get(k));
                        shoppingCart2.remove(k);
                        length=length-1;
                    }
                }
            }
                for (Product product : shoppingCart1 ) {
                    System.out.println(product.toString());
                }
            }
        if (sortMethod.equals(SortBy.Rating)) {
                Float[] b = new Float[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    b[i] = shoppingCart.get(i).getAvgRating();
                }
                Arrays.sort(b);
                ArrayList<Product> shoppingCart1 = new ArrayList<>();
                ArrayList<Product> shoppingCart2 = shoppingCart ;
                int length=b.length;
                for (int j = 0; j <b. length; j++) {
                    for (int k = 0; k < length; k++) {
                        if (b[j] == shoppingCart2.get(k).getAvgRating()) {
                            shoppingCart1.add(shoppingCart2.get(k));
                            shoppingCart2.remove(k);
                            length=length-1;
                        }
                    }
                }
                for (Product product : shoppingCart1) {
                    System.out.println(product.toString());
                }
            }
            if (sortMethod.equals(SortBy.PurchaseTime)) {
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
            }
        }
        public boolean refundProduct (Product product){
        return false;
        }
    }
