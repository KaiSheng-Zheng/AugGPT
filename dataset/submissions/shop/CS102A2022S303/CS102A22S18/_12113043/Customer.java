import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private ArrayList<Store> stores=new ArrayList<>();


    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating >= 1 && rating <= 5) {
            product.setRating(rating);
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) == true && product.getPrice() <= wallet) {
            wallet -= product.getPrice();
            shoppingCart.add(product);
            stores.add(store);
            store.transact(product,0);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }
        if (sortMethod == SortBy.Price) {
            ArrayList<Product> newproducts = new ArrayList<>(shoppingCart);
            newproducts.sort(new SortByPrice());
            for (int i = 0; i < newproducts.size(); i++) {
                System.out.println(newproducts.get(i));
            }
        }
        if (sortMethod == SortBy.Rating) {
            ArrayList<Product> newproducts = new ArrayList<>(shoppingCart);
            newproducts.sort(new SortByRating());
            for (int i = 0; i < newproducts.size(); i++) {
                System.out.println(newproducts.get(i));
            }
        }
    }
    public boolean refundProduct(Product product){
        int N=0;
        int Sequence=0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).getId()== product.getId()){
                N++;
                Sequence=i;}
        }
        if (N==1){
            shoppingCart.remove(Sequence);
            wallet+= product.getPrice();
            stores.get(Sequence).transact(product,1);
            stores.remove(Sequence);
            return true;
        }else {
            return false;
        }
    }

    class SortByPrice implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            return (int) (o1.getPrice() - o2.getPrice());
        }
    }

    class SortByRating implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            return (int) (o1.getAvgRating()-o2.getAvgRating());
        }
    }
}


