import java.util.ArrayList;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;
    private ArrayList<Store> storelist = new ArrayList<>();


    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        int n = 0;
        if (store.hasProduct(product)) {
            n = 1;
        }
        int a = 0;
        if (n == 1 && wallet >= product.getPrice()) {
            wallet -= product.getPrice();
            shoppingCart.add(product);
            for (Store store1 : storelist) {
                if (store.getId() == store1.getId()) {
                    a++;
                }
            }
            if (a == 0) {
                storelist.add(store);
            }
            store.transact(product, 0);
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if(shoppingCart.size()==0){
            System.out.println();
        }
        switch (sortMethod) {
            case PurchaseTime:
                for (Product product : shoppingCart) {
                    System.out.println(product);
                }
                break;
            case Rating:
                shoppingCart.sort((o1, o2) -> Float.compare(o1.getAvgRating(), o2.getAvgRating()));
                for (Product product : shoppingCart) {
                    System.out.println(product);
                }
                break;
            case Price:
                shoppingCart.sort((o1, o2) -> Float.compare(o1.getPrice(), o2.getPrice()));
                for (Product product : shoppingCart) {
                    System.out.println(product);
                }
                break;
        }
    }

    public boolean refundProduct(Product product) {
        for (Product ignored : shoppingCart) {
            if (ignored.getId() == product.getId()) {
                shoppingCart.remove(product);
                wallet += product.getPrice();
                for (Store store : storelist) {
                    for (Product products : store.getOldlist()) {
                        if (product.getId() == products.getId()) {
                            store.transact(product, 1);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }


    public static int getCnt() {
        return cnt;
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
}
