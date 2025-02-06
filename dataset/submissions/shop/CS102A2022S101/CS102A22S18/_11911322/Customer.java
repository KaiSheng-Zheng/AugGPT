import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Store> fromWhere = new ArrayList<>();
    private float wallet;
    private static int Cnt = 0;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public void updateWallet(float amount) {
        setWallet(amount+getWallet());
    }

    public boolean purchaseProduct(Store store, Product product) {
        boolean isSuccess = (store.hasProduct(product) && getWallet() >= product.getPrice());
        if (isSuccess) {
            updateWallet(-1*product.getPrice());
            this.shoppingCart.add(product);
            store.transact(product,0);
            product.setFromStore(store.getId());
            this.fromWhere.add(store);
            Cnt++;
            product.setPurchaseTime(Cnt);
        }
        return isSuccess;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> shoppingCart1 = new ArrayList<>();
        shoppingCart1.addAll(this.shoppingCart);
//        ArrayList<Product> shoppingCart1 = this.shoppingCart;
        switch (sortMethod) {
            case PurchaseTime :
                for (int i = 1; i < shoppingCart1.size()-1; i++) {
                    for (int j = 0; j < shoppingCart1.size()-i; j++) {
                        if (shoppingCart1.get(j).getPurchaseTime() > shoppingCart1.get(j+1).getPurchaseTime()) {
                            Collections.swap(shoppingCart1,j,j+1);
                        }
                    }
                }
                break;
            case Rating :
                for (int i = 1; i < shoppingCart1.size(); i++) {
                    for (int j = 0; j < shoppingCart1.size()-i; j++) {
                        if (shoppingCart1.get(j).getAvgRating() < shoppingCart1.get(j+1).getAvgRating()) {
                            continue;
                        }
                        if (shoppingCart1.get(j).getAvgRating() > shoppingCart1.get(j+1).getAvgRating()) {
                            Collections.swap(shoppingCart1,j,j+1);
                            continue;
                        }
                        if (shoppingCart1.get(j).getAvgRating() == shoppingCart1.get(j+1).getAvgRating()) {
                            if (shoppingCart1.get(j).getPurchaseTime() > shoppingCart1.get(j+1).getPurchaseTime()) {
                                Collections.swap(shoppingCart1,j,j+1);
                            }
                        }
                    }
                }
                break;
            case Price :
                for (int i = 1; i < shoppingCart1.size(); i++) {
                    for (int j = 0; j < shoppingCart1.size()-i; j++) {
                        if (shoppingCart1.get(j).getPrice() < shoppingCart1.get(j+1).getPrice()) {
                            continue;
                        }
                        if (shoppingCart1.get(j).getPrice() > shoppingCart1.get(j+1).getPrice()) {
                            Collections.swap(shoppingCart1,j,j+1);
                            continue;
                        }
                        if (shoppingCart1.get(j).getPrice() == shoppingCart1.get(j+1).getPrice()) {
                            if (shoppingCart1.get(j).getPurchaseTime() > shoppingCart1.get(j+1).getPurchaseTime()) {
                                Collections.swap(shoppingCart1,j,j+1);
                            }
                        }
                    }
                }
                break;
            default :
                break;

        }
        for (Product product : shoppingCart1) {
            System.out.println(product);
        }
    }

    public boolean refundProduct(Product product) {
        boolean hasPurchased = false;
        for (int i = 0; i < this.shoppingCart.size(); i++) {
            if (product.getId() == this.shoppingCart.get(i).getId()) {
                hasPurchased = true;
                break;
            }
        }
        if (hasPurchased) {
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            for (Store store : fromWhere) {
                if (store.getId() == product.getFromStore()) {
                    store.transact(product,1);
                    break;
                }
            }
        }
        return hasPurchased;
    }
}