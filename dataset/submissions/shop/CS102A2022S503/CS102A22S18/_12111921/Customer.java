import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private ArrayList<Store> stores;
    private ArrayList<Product> products;

    public Customer(String name, float wallet){
        this.wallet = wallet;
        this.name = name;
        cnt++;
        id = cnt;
        shoppingCart = new ArrayList<>();
        stores = new ArrayList<>();
        products = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            store.removeProduct(product);
            store.setIncome(store.getIncome() + product.getPrice());
            wallet -= product.getPrice();
            shoppingCart.add(product);
            stores.add(store);
            products.add(product);
            return true;
        }
        else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod.equals(SortBy.Rating)){
            ArrayList<Product> products1 = new ArrayList<>(shoppingCart);
            products1.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return Float.compare(o1.getAvgRating(), o2.getAvgRating());
                }
            });
            for (int i = 0; i < products1.size(); i++) {
                System.out.println(products1.get(i));
            }
        }
        else if (sortMethod.equals(SortBy.Price)){
            ArrayList<Product> products1 = shoppingCart;
            products1.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getPrice() > o2.getPrice()){
                        return 1;
                    }
                    else if (o1.getPrice() == o2.getPrice()){
                        if (products1.indexOf(o1) > products1.indexOf(o2)){
                            return 1;
                        }
                        else {
                            return 0;
                        }
                    }
                    else return -1;
                }
            });
            for (int i = 0; i < products1.size(); i++) {
                System.out.println(products1.get(i));
            }
        }
        else {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }
    }

    public boolean refundProduct(Product product){
        boolean a = false;
        int i = 0;
        for (; i < shoppingCart.size(); i++) {
            if (product.getId() == shoppingCart.get(i).getId()){
                a = true;
                break;
            }
        }
        if (a){
            int j = 0;
            for (; j < products.size(); j++) {
                if (products.get(j).getId() == product.getId()){
                    break;
                }
            }
            shoppingCart.remove(i);
            wallet += product.getPrice();
            stores.get(j).transact(product,1);
            return true;
        }
        else return false;
    }
}
