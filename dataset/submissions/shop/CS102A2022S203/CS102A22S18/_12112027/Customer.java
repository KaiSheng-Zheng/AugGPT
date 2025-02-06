import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;
    private int times;

    public Customer(String name, float wallet){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if (rating>=1 && rating<=5) {
            product.setRating(rating);
            return true;
        }else return false;
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && getWallet()>=product.getPrice()){
            product.setBelong(store);
            store.transact(product,0);
            updateWallet(-product.getPrice());
            times++;
            product.setPurchaseTime(times);
            shoppingCart.add(product);
            return true;
        }else return false;
    }


    public void viewShoppingCart(SortBy sortMethod){
        int[] rank = new int[shoppingCart.size()];
        if (sortMethod== SortBy.PurchaseTime){
            for (int i = 0 ; i < shoppingCart.size() ; i++){
                System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\n", shoppingCart.get(i).getId(), shoppingCart.get(i).getName(), shoppingCart.get(i).getPrice(), shoppingCart.get(i).getAvgRating());
            }
        }else if (sortMethod== SortBy.Price){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getPrice() == o2.getPrice()){
                        return o1.getPurchaseTime() - o2.getPurchaseTime();
                    }else return (o1.getPrice() < o2.getPrice() ? -1:1);

                }
            });
            for (int i = 0 ; i < shoppingCart.size() ; i++){
                System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\n", shoppingCart.get(i).getId(), shoppingCart.get(i).getName(), shoppingCart.get(i).getPrice(), shoppingCart.get(i).getAvgRating());
            }
        }else if (sortMethod== SortBy.Rating){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getAvgRating() == o2.getAvgRating()){
                        return o1.getPurchaseTime() - o2.getPurchaseTime();
                    } else return (o1.getAvgRating() < o2.getAvgRating() ? -1:1);
                }
            });
            for (int i = 0 ; i < shoppingCart.size() ; i++){
                System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\n", shoppingCart.get(i).getId(), shoppingCart.get(i).getName(), shoppingCart.get(i).getPrice(), shoppingCart.get(i).getAvgRating());
            }
        }
    }

    public boolean refundProduct(Product product){
            if (!shoppingCart.contains(product)) return false;
            Store store = product.getBelong();
            shoppingCart.remove(product);
            setWallet(getWallet() + product.getPrice());
            store.addProduct(product);
            store.setIncome(store.getIncome() - product.getPrice());
            return true;

        }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public float getWallet() {
        return wallet;
    }

}
