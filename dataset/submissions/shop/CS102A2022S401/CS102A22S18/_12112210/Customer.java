import java.util.ArrayList;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id =0;  // unique for each customer and the value is set to cnt.
    private String name = "";
    private ArrayList<Product> shoppingCart = new ArrayList<Product>(); // The list of purchased products; default is empty.
    private float wallet = 0;
    ArrayList<Product> temper = new ArrayList<Product>();

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        }
        return false;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        int flag;
        switch (sortMethod) {
            case PurchaseTime:
                for (Product pro : shoppingCart) {
                    System.out.println(pro);
                }
                break;

            case Price:
                for (Product a : shoppingCart) {
                    temper.add(a);
                }

                for (int a = 0; a < temper.size(); a++) {
                    flag = 0;
                    float compare = temper.get(a).getPrice();

                    for (int b = 0; b < temper.size(); b++) {
                        if (temper.get(b).getPrice() < compare) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        System.out.println(temper.get(a));
                        temper.remove(a);
                        a = -1;
                    }
                }
                break;
            case Rating:
                for (Product a : shoppingCart) {
                    temper.add(a);
                }
                for (int a = 0; a < temper.size(); a++) {
                    flag = 0;
                    float compare = temper.get(a).getAvgRating();

                    for (int b = 0; b < temper.size(); b++) {
                        if (temper.get(b).getAvgRating() < compare) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        System.out.println(temper.get(a));
                        temper.remove(a);
                        a = -1;
                    }
                }
                break;
        }
    }

    public boolean refundProduct(Product product) {
        int flag=0;
        for (Product pro : shoppingCart) {
            if (pro.getId() == product.getId()) {                 //??compare id?
                flag = 1;
            }
        }
        if(flag == 0) {
            return false;
        }
        if(product.getStoreId() == 0){
            return false;
        }
        Store s;
        s = Store.storeNamess.get(product.getStoreId()-1);
        s.transact(product, 1);
        updateWallet(product.getPrice());
        shoppingCart.remove(product);
        return true;
    }
}
enum SortBy {
    PurchaseTime, Rating, Price
}
