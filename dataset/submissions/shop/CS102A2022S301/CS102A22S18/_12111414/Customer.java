import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private ArrayList<Store> storeList;
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
        this.storeList = new ArrayList<>();
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)){
            if (this.wallet >= product.getPrice()){
                store.transact(product,0);
                this.shoppingCart.add(product);
                this.storeList.add(store);
                updateWallet(product.getPrice() * -1f);
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod == SortBy.PurchaseTime){
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                System.out.println(this.shoppingCart.get(i).toString());
            }
        }else if (sortMethod == SortBy.Rating){
            ArrayList<Product> copyList = sortByRating();
            for (int i = 0; i < copyList.size(); i++) {
                System.out.println(copyList.get(i).toString());
            }
        }else if (sortMethod == SortBy.Price){
            ArrayList<Product> copyList = sortByPrice();
            for (int i = 0; i < copyList.size(); i++) {
                System.out.println(copyList.get(i).toString());
            }
        }
    }

    public boolean refundProduct(Product product){
        boolean exist = false;
        for (int i = 0; i < this.shoppingCart.size(); i++) {
            if (this.shoppingCart.get(i).getId() == product.getId()){
                exist = true;
                break;
            }
        }

        if (exist){
            updateWallet(product.getPrice());
            storeList.get(shoppingCart.indexOf(product)).transact(product,1);

            storeList.remove(shoppingCart.indexOf(product));
            shoppingCart.remove(product);

            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Product> sortByRating(){
        ArrayList<Product> copyList = new ArrayList<>();
        for (int i = 0; i < this.shoppingCart.size(); i++) {
            copyList.add(shoppingCart.get(i));
        }

        copyList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getAvgRating() > o2.getAvgRating()){
                    return 1;
                }else if (o1.getAvgRating() < o2.getAvgRating()){
                    return -1;
                }else {
                    return 0;
                }
            }
        }
        );
        return copyList;
    }

    public ArrayList<Product> sortByPrice(){
        ArrayList<Product> copyList = new ArrayList<>();
        for (int i = 0; i < this.shoppingCart.size(); i++) {
            copyList.add(shoppingCart.get(i));
        }

        copyList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()){
                    return 1;
                }else if (o1.getPrice() < o2.getPrice()){
                    return -1;
                }else {
                    return 0;
                }
            }
        }
        );
        return copyList;
    }



}