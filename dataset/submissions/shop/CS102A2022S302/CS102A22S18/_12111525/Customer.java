import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) == true){
            if (wallet>=product.getPrice()){
                wallet -= product.getPrice();;
                shoppingCart.add(product);
                store.transact(product,0);
                product.setStore(store);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod == SortBy.Rating) {
            Product[] pro = new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                pro[i] = shoppingCart.get(i);
            }
            int end = shoppingCart.size();
            while (end > 0) {
                int flag = 0;
                for (int i = 1; i < end; i++) {
                    if (pro[i - 1].getAvgRating() > pro[i].getAvgRating()) {
                        Product store = pro[i];
                        pro[i] = pro[i - 1];
                        pro[i - 1] = store;
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    break;
                }
                end--;
            }
            for (Product product : pro) {
                System.out.println(product);
            }
        }
        if (sortMethod == SortBy.Price) {
            Product[] pro = new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                pro[i] = shoppingCart.get(i);
            }
            int end = shoppingCart.size();
            while (end > 0) {
                int flag = 0;
                for (int i = 1; i < end; i++) {
                    if (pro[i - 1].getPrice() > pro[i].getPrice()) {
                        Product store = pro[i];
                        pro[i] = pro[i - 1];
                        pro[i - 1] = store;
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    break;
                }
                end--;
            }
            for (Product product : pro) {
                System.out.println(product);
            }
        }
    }
    public boolean refundProduct(Product product){
        int a = 0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (product == shoppingCart.get(i)){
                shoppingCart.remove(i);
                a++;
                product.getStore().transact(product,1);
                wallet += product.getPrice();
            }
        }

        if (a==1){
            return true;
        }
        else {
            return false;
        }
    }

    }






