import java.util.ArrayList;
public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating))
            return true;
        else
            return false;
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && product.getPrice() <= wallet){
            wallet -= product.getPrice();
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product temp = null;
        ArrayList<Product> s = new ArrayList<>();
        for (Product i: shoppingCart)
            s.add(i);
        if (shoppingCart.size() != 0) {
            if (sortMethod.equals(SortBy.PurchaseTime)) {
                for (int i = 0; i < s.size(); i++)
                    System.out.println(s.get(i));
            }
            if (sortMethod.equals(SortBy.Rating)) {
                for (int i = 0; i < s.size() - 1; i++) {
                    for (int j = 0; j < s.size() - 1 - i; j++) {
                        if (s.get(j).getAvgRating() > s.get(j + 1).getAvgRating()) {
                            temp = s.get(j);
                            s.remove(s.get(j));
                            s.add(j, s.get(j));
                            s.remove(s.get(j + 1));
                            s.add(j + 1, temp);
                        }
                    }
                }
                for (int i = 0; i < s.size(); i++) {
                    System.out.println(s.get(i));
                }
            }
            if (sortMethod.equals(SortBy.Price)) {
                for (int i = 0; i < s.size() - 1; i++) {
                    for (int j = 0; j < s.size() - 1 - i; j++) {
                        if (s.get(j).getPrice() > s.get(j + 1).getPrice()) {
                            temp = s.get(j);
                            s.remove(s.get(j));
                            s.add(j, s.get(j));
                            s.remove(s.get(j + 1));
                            s.add(j + 1, temp);
                        }
                    }
                }
                for (int i = 0; i < s.size(); i++) {
                    System.out.println(s.get(i));
                }
            }
        }else
            System.out.println(shoppingCart);
    }

    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet += product.getPrice();
            product.getStore().transact(product, 1);
            return true;
        }
        else
            return false;
    }
}