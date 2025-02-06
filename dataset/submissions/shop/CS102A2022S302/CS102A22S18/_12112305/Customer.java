
import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;

    }

    public boolean rateProduct(Product product,int rating){
        if (rating >= 1 && rating <= 5){
            product.setRating(rating);
            return true;
        }
        else return false;
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public void addShoppingCart(Product product){
        shoppingCart.add(product);
    }

    public boolean purchaseProduct(Store store,Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            store.removeProduct(product);
            wallet -= product.getPrice();
            addShoppingCart(product);
            store.setIncome(store.getIncome() + product.getPrice());
            product.setStore(store);
            return true;
        }
        else return false;
    }



    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> newProducts = new ArrayList<>(shoppingCart);
        switch (sortMethod){
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
                break;
            case Rating:
                newProducts.sort(new SortByRating());
                for (int i = 0; i < newProducts.size(); i++) {
                    System.out.println(newProducts.get(i));
                }
                break;
            case Price:
                newProducts.sort(new SortByPrice());
                for (int i = 0; i < newProducts.size(); i++) {
                    System.out.println(newProducts.get(i));
                }
                break;

        }


    }
    static class SortByRating implements Comparator<Product>{

        @Override
        public int compare(Product o1, Product o2) {
            return (int) (o1.getAvgRating() - o2.getAvgRating());
        }
    }

    static class SortByPrice implements Comparator<Product>{

        @Override
        public int compare(Product o1, Product o2) {
            return (int) (o1.getPrice() - o2.getPrice());
        }
    }



    public String getName() {
        return name;
    }


    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet += product.getPrice();
            product.getStore().transact(product,1);
            return true;


        }
        return false;
    }
}





