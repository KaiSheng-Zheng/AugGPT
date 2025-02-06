import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the
    //constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products;
    //default is empty.
    private float wallet;
    private HashMap byPrice = new HashMap<Float, Integer>();
    private HashMap byRating = new HashMap<Float, Integer>();
    private ArrayList<Float> priceList = new ArrayList<>();
    private ArrayList<Float> ratingList = new ArrayList<>();

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (this.wallet >= product.getPrice()) {
            if (store.getProductList().contains(product)) {
                store.transact(product, 0);
                this.wallet -= product.getPrice();
                this.shoppingCart.add(product);
                if (!priceList.contains(product.getPrice())) {
                    priceList.add(product.getPrice());
                    byPrice.put(product.getPrice(), product.getId());
                } else {
                    if (shoppingCart.indexOf(product) > shoppingCart.indexOf(byPrice.get(product.getPrice()))) {
                        priceList.add(Float.valueOf(String.valueOf(product.getPrice() - 0.0000001)));
                        byPrice.put(Float.valueOf(String.valueOf(product.getPrice() - 0.0000001)), product.getId());
                    } else {
                        priceList.add(Float.valueOf(String.valueOf(product.getPrice() + 0.0000001)));
                        byPrice.put(Float.valueOf(String.valueOf(product.getPrice() + 0.0000001)), product.getId());
                    }
                }
                if (!ratingList.contains(product.getPrice())) {
                    ratingList.add(product.getPrice());
                    byRating.put(product.getAvgRating(), product.getId());
                } else {
                    if (shoppingCart.indexOf(product) > shoppingCart.indexOf(byRating.get(product.getPrice()))) {
                        ratingList.add(Float.valueOf(String.valueOf(product.getAvgRating() - 0.0000001)));
                        byRating.put(Float.valueOf(String.valueOf(product.getAvgRating() - 0.0000001)), product.getId());
                    } else {
                        ratingList.add(Float.valueOf(String.valueOf(product.getAvgRating() + 0.0000001)));
                        byRating.put(Float.valueOf(String.valueOf(product.getAvgRating() + 0.0000001)), product.getId());
                    }
                }
                return true;
            } else return false;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                System.out.println(this.shoppingCart.get(i).toString());
            }
        } else if (sortMethod == SortBy.Price) {
            if (this.shoppingCart.size() > 0) {
                Collections.sort(this.priceList);
                for (int i = 0; i < this.priceList.size(); i++) {
                    for (int j = 0; j <Product.ProductList.size() ; j++) {
                        if (Integer.parseInt(String.valueOf(byPrice.get(priceList.get(priceList.size()-1-i))))==Product.ProductList.get(j).getId()){
                            System.out.println(Product.ProductList.get(j).toString());
                        }
                    }
                }
            }
        } else {
            if (this.shoppingCart.size() > 0) {
                Collections.sort(this.ratingList);
                for (int i = 0; i < this.ratingList.size(); i++) {
                    for (int j = 0; j <Product.ProductList.size() ; j++) {
                        if (Integer.parseInt(String.valueOf(byRating.get(ratingList.get(ratingList.size()-1-i))))==Product.ProductList.get(j).getId()){
                            System.out.println(Product.ProductList.get(j).toString());
                        }
                    }
                }
            }
        }

    }

    public boolean refundProduct(Product product) {
        Store store=new Store("",new ArrayList<>(),0);
        for (int i = 0; i < Store.StoreList.size(); i++) {
            if (product.StoreId == Store.StoreList.get(i).getId()) {
                store = Store.StoreList.get(i);
            }
        }
        if (shoppingCart.contains(product)){
            if ((store.getIncome()>=product.getPrice())){
                store.transact(product,1);
                wallet+=product.getPrice();
                shoppingCart.remove(product);
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}