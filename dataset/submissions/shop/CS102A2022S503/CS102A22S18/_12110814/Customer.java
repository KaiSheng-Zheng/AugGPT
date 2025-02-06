import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private final int id; // unique for each customer and the value is set to cnt.
    private final String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private ArrayList<Store> shoresHasBeenTo = new ArrayList<>();  // The list of stores the customer has been to.
    private float wallet;
    int nowPurchaseTime = 0;


    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt ++;
        this.id = cnt;
    }


    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if ((store.hasProduct(product)) && (this.wallet >= product.Price())) {
            updateWallet(-product.Price());
            store.transact(product, 0);
            shoppingCart.add(product);
            shoresHasBeenTo.add(store);
            product.Id_ofStore_itBelong = store.Id();
            nowPurchaseTime ++;
            product.purchaseTime = nowPurchaseTime;
            return true;
        }
        else
            return false;
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            for (Store store : shoresHasBeenTo) {
                if (store.Id() == product.Id_ofStore_itBelong) {
                    shoppingCart.remove(product);
                    store.transact(product, 1);
                    updateWallet(product.Price());
                    return true;
                }
            }
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        shoppingCart_sortBy_(sortMethod);

        for (Product product : this.shoppingCart) {
            System.out.println(product.toString());
        }

    }


    public void shoppingCart_sortBy_(SortBy sortMethod) {
        int len = this.shoppingCart.size();
        Product crk;

        int cm = 0;         // CheckMark
        while (cm == 0) {
            for (int i = 0; i < len - 1; i++) {
                if (compare_AB(this.shoppingCart.get(i), this.shoppingCart.get(i + 1), sortMethod)){
                    crk = this.shoppingCart.get(i);
                    this.shoppingCart.remove(i);
                    this.shoppingCart.add(i + 1, crk);
                }
            }
            cm = 1;
            for (int i = 0; i < len - 1; i++) {
                if (compare_AB(this.shoppingCart.get(i), this.shoppingCart.get(i + 1), sortMethod)) {
                    cm = 0;
                    break;
                }
            }
        }
    }

    public boolean compare_AB(Product pA, Product pB, SortBy sortMethod) {      // A>B : true; A<=B : false.
        switch (sortMethod) {
            case Price:
                return pA.Price() > pB.Price();
            case Rating:
                return pA.getAvgRating() > pB.getAvgRating();
            case PurchaseTime:
                return pA.purchaseTime > pB.purchaseTime;
            default:
                return false;
        }
    }



}

