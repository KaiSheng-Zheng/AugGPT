
import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private ArrayList<Store> stores;
    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        ++cnt;
        id = cnt;
        shoppingCart = new ArrayList<>();
        stores = new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
       return product.setRating(rating);
    }
    public void updateWallet(float amount){
        if (wallet + amount >= 0){
            wallet += amount;
        }
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            stores.add(store);
            return true;
        }else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> newList;
        switch (sortMethod){
            case PurchaseTime:
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
                break;
            case Rating:
                newList = new ArrayList<>(shoppingCart);
                newList.sort((o1, o2) -> {
                    if (o1.getAvgRating() != o2 .getAvgRating()) {
                        return (int) (o1.getAvgRating() - o2.getAvgRating());
                    } else {
                        return shoppingCart.indexOf(o1) - shoppingCart.indexOf(o2);
                    }
                });
                for (Product product : newList) {
                    System.out.println(product.toString());
                }
                break;
            case Price:
                newList = new ArrayList<>(shoppingCart);
                newList.sort((o1, o2) -> {
                    if (o1.getPrice() != o2.getPrice()) {
                        return (int) (o1.getPrice() - o2.getPrice());
                    } else {
                        return shoppingCart.indexOf(o1) - shoppingCart.indexOf(o2);
                    }
                });
                for (Product product : newList) {
                    System.out.println(product.toString());
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        int productIndex = shoppingCart.indexOf(product);
        if (productIndex==-1){
            return false;
        }
        Store refundStore = stores.get(productIndex);
        refundStore.transact(product,1);
        shoppingCart.remove(product);
        stores.remove(productIndex);
        updateWallet(product.getPrice());
        return true;
    }
}

