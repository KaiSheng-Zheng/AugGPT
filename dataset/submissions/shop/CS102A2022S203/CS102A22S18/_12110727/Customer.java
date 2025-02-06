import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
      private ArrayList<Store> stores=new ArrayList<>();
    public static int getCnt() {
        return cnt;
    }

    public ArrayList<Store> getStores() {
        return stores;
    }

    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public float getWallet() {
        return wallet;
    }

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if(rating<=5&&rating>=1){
            product.getRatings().add(rating);
            return true;
        }
        else{
            return false;
        }
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        int k=0;
        for (int i = 0; i < store.getProductList().size(); i++) {
            if(wallet>=product.getPrice()&& Objects.equals(store.getProductList().get(i).getName(), product.getName())){
               store.getProductList().remove(i);
                k=1;

            }
            else{
                continue;
            }
        }
        if(k==1){
            stores.add(store);
            shoppingCart.add(product);
            store.setIncome(store.getIncome()+product.getPrice());
            wallet=wallet-product.getPrice();
            return true;
        }
        else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime -> {
                for (int i = 0; i < shoppingCart.size(); i++) {
                        System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\n", shoppingCart.get(i).getId(), shoppingCart.get(i).getName(), shoppingCart.get(i).getPrice(), shoppingCart.get(i).getAvgRating());
                }
                break;
            }
            case Rating -> {
                ArrayList<Float> Rating=new ArrayList<>();
                for (int i = 0; i < shoppingCart.size(); i++) {
                    Rating.add(shoppingCart.get(i).getAvgRating());
                }
                Collections.sort(Rating);
                for (int p = 0; p < Rating.size(); p++) {
                    for (int i = 0; i < Rating.size(); i++) {
                        if(Objects.equals(Rating.get(p), Rating.get(i)) &&i!=p){
                            Rating.remove(Rating.get(i));
                        }
                        else{

                        }
                    }
                }
                for (int j = 0; j <Rating.size(); j++) {
                    for (int m = 0; m < shoppingCart.size(); m++) {
                        if(shoppingCart.get(m).getAvgRating()== Rating.get(j)){
                            System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\n", shoppingCart.get(m).getId(), shoppingCart.get(m).getName(), shoppingCart.get(m).getPrice(), shoppingCart.get(m).getAvgRating());
                        }
                        else{
                            continue;
                        }
                    }
                }
                break;
            }
            case Price -> {
                ArrayList<Float> Rating=new ArrayList<>();
                for (int i = 0; i < shoppingCart.size(); i++) {
                    Rating.add(shoppingCart.get(i).getPrice());
                }
                Collections.sort(Rating);
                for (int p = 0; p < Rating.size(); p++) {
                    for (int i = 0; i < Rating.size(); i++) {
                        if(Objects.equals(Rating.get(p), Rating.get(i)) &&i!=p){
                            Rating.remove(Rating.get(i));
                        }
                        else{

                        }
                    }
                }
                for (int j = 0; j < Rating.size(); j++) {
                    for (int m = 0; m < shoppingCart.size(); m++) {
                        if(shoppingCart.get(m).getPrice()== Rating.get(j)){
                            System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\n", shoppingCart.get(m).getId(), shoppingCart.get(m).getName(), shoppingCart.get(m).getPrice(), shoppingCart.get(m).getAvgRating());
                        }
                        else{
                            continue;
                        }
                    }
                }
                break;
            }
            default -> {
                break;
            }
        }
    }
    public boolean refundProduct(Product product){
        int k=0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if(product.getName().equals(shoppingCart.get(i).getName())) {
                k = 1;
                stores.get(i).setIncome(stores.get(i).getIncome() - product.getPrice());
                stores.get(i).getProductList().add(product);
                stores.remove(i);
            }
        }
        if(k==1){
            shoppingCart.remove(product);
            wallet=wallet+product.getPrice();
            return true;
        }
        else{
            return false;
        }
    }



}