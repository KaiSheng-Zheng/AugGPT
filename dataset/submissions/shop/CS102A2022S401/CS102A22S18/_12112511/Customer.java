import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    //Attributes
    private String name;
    private float wallet;
    private static int cnt;
    private int id;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    HashMap<Integer,Store> productIdToStoreMap = new HashMap<>();

    //Constructor
    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    //Methods
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating) ? true : false;
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            addCargo(product);
            store.removeProduct(product);
            store.setIncome(product.getPrice());
            wallet -= product.getPrice();
            productIdToStoreMap.put(product.getId(),store);
            return true;
        }else{return false;}
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (int x = 0;x<shoppingCart.size();x++){
                    System.out.println(shoppingCart.get(x).toString());
                }
                break;
            case Rating:
                sortByRating();
                break;
            case Price:
                sortByPrice();
                break;
        }
    }

    public boolean refundProduct(Product product){
        if (hasCargo(product)) {
            productIdToStoreMap.get(product.getId()).addProduct(product);
            productIdToStoreMap.get(product.getId()).setIncome(-product.getPrice());
            productIdToStoreMap.remove(product.getId());
            shoppingCart.remove(product);
            wallet += product.getPrice();
            return true;
        }else{return false;}
    }

    //ShoppingCart Methods
    public void addCargo(Product product){shoppingCart.add(product);}

    public boolean hasCargo(Product product){
        for (int x = 0;x<shoppingCart.size();x++){
            if (product.getId() == shoppingCart.get(x).getId()){
                return true;
            }
        }
        return false;
    }

    public void removeCargo(Product product){shoppingCart.remove(product);}

    //Sort Method
    public void sortByRating(){
        HashMap<Float,Product> RatingMap = new HashMap<>();
        for (int x = 0;x<shoppingCart.size();x++){
            RatingMap.put(shoppingCart.get(x).getAvgRating(),shoppingCart.get(x));
        }
        float[] RatingList = new float[shoppingCart.size()];
        for (int x = 0;x<shoppingCart.size();x++){
            RatingList[x] = shoppingCart.get(x).getAvgRating();
        }
        Arrays.sort(RatingList);
        for (int x = 0;x<shoppingCart.size();x++) {
            System.out.println(RatingMap.get(RatingList[x]).toString());
        }
    }

    public void sortByPrice(){
        HashMap<Float,Product> PriceMap = new HashMap<>();
        for (int x = 0;x<shoppingCart.size();x++){
            PriceMap.put(shoppingCart.get(x).getPrice(),shoppingCart.get(x));
        }
        float[] PriceList = new float[shoppingCart.size()];
        for (int x = 0;x<shoppingCart.size();x++){
            PriceList[x] = shoppingCart.get(x).getPrice();
        }
        Arrays.sort(PriceList);
        for (int x = 0;x<shoppingCart.size();x++) {
            System.out.println(PriceMap.get(PriceList[x]).toString());
        }
    }
}
