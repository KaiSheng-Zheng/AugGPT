
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.



    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }

    public float getTruePrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        if (ratings.size()==0){
            return 0;
        }else {
        float temp = 0;
        for (int i = 0; i < ratings.size(); i++) {
            temp += ratings.get(i);
        }
        return temp / ratings.size();}
    }

    // keep 2 decimal places following rounding
    public String getPrice() {
        return String.format("%.2f",getTruePrice());
    }

//    //keep 1 decimal place following rounding
//    public String getRating() {
//        DecimalFormat df = new DecimalFormat("0.0");
//        return df.format(getAvgRating());
//    }


    public String toString() {
        return "Product ID " + id + ", " + name + ", RMB " +String.format("%.2f",getTruePrice()) + ", Rating " + String.format("%.1f",getAvgRating());
    }
}

class Store {
    private static int cnt = 1; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;


    public Store(String name) {
        this.name = name;
        this.id = cnt;
        cnt++;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        this.id = cnt;
        cnt++;
    }

    public float setIncome(float income) {
        this.income = income;
        return income;
    }

    public float getIncome() {
        return income;
    }

    public boolean hasProduct(Product product) {
        int yn = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) == product) {
                yn = 1;
            }
        }
        if (yn == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        } else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)) {
            productList.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    // handle customers' purchases or refunds
    public void transact(Product product, int method) {
        if (method == 0) {
            removeProduct(product);
            income += Float.parseFloat(product.getPrice());
        } else {
            addProduct(product);
            income -= Float.parseFloat(product.getPrice());
        }
    }
}

class Customer {
    private static int cnt = 1; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> tempShoppingCart = new ArrayList<>(); //record purchase order
    private ArrayList<Product> shoppingCart = new ArrayList<>();// The list of purchased products; default is empty.
    private float wallet;


    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        this.id = cnt;
        cnt++;
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }


    public boolean purchaseProduct(Store store, Product product) {

        if (store.hasProduct(product) && Float.parseFloat(product.getPrice()) <= wallet) {
            //put the product into the cart and remove it from the store
            store.removeProduct(product);
            tempShoppingCart.add(product);
            shoppingCart = tempShoppingCart;
            updateWallet(-Float.parseFloat(product.getPrice()));
            store.setIncome(store.getIncome() + Float.parseFloat(product.getPrice()));
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (tempShoppingCart.size()!=shoppingCart.size()){
            tempShoppingCart = shoppingCart;
        }
        shoppingCart = tempShoppingCart;
        if (sortMethod.equals(SortBy.Rating)) {
        for (int i = 0; i < shoppingCart.size() - 1; i++) {
                for (int j = 0; j < shoppingCart.size() - i - 1; j++) {
                    if (shoppingCart.get(i).getAvgRating() > shoppingCart.get(i + 1).getAvgRating()) {
                        Product temp = shoppingCart.get(i);
                        shoppingCart.remove(i);
                        shoppingCart.add(i + 1, temp);
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());

            }

        }
        else if (sortMethod.equals(SortBy.Price)) {
            for (int i = 0; i < shoppingCart.size() - 1; i++) {
                for (int j = 0; j < shoppingCart.size() - i - 1; j++) {
                    if (shoppingCart.get(i).getTruePrice() > shoppingCart.get(i + 1).getTruePrice()) {
                        Product temp = shoppingCart.get(i);
                        shoppingCart.remove(i);
                        shoppingCart.add(i + 1, temp);
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());

            }
        }
        else if (sortMethod.equals(SortBy.PurchaseTime)){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());

            }
        }


    }

    public boolean refundProduct(Store store, Product product) {
        if (purchaseProduct(store, product)) {
            store.addProduct(product);
            updateWallet(product.getTruePrice());
            tempShoppingCart.remove(product);
            store.setIncome(store.getIncome() + Float.parseFloat(product.getPrice()));
            return true;
        } else {
            return false;
        }
    }

}
























