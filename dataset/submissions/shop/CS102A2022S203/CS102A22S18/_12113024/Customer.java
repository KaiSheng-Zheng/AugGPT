import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private int buyTime;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        id = ++cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (!store.hasProduct(product)) return false;
        if(product.getPrice() > wallet) return false;

        updateWallet(-product.getPrice());
        store.transact(product,0);
        product.setBuyTime(++buyTime);
        shoppingCart.add(product);

        return true;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                shoppingCart.sort((o1, o2) -> {
                    if(o1.getBuyTime() > o2.getBuyTime()) return 1;
                    else return -1;
                });
                break;

            case Rating:
                shoppingCart.sort((o1, o2) -> {
                    if(o1.getAvgRating() > o2.getAvgRating()) return 1;
                    else if(o1.getAvgRating() == o2.getAvgRating()) {
                        if(o1.getBuyTime() > o2.getBuyTime()) return 1;
                        else return -1;
                    }
                    else return -1;
                });
                break;
            case Price:
                shoppingCart.sort((o1, o2) -> {
                    if(o1.getPrice() > o2.getPrice()) return 1;
                    else if(o1.getPrice() == o2.getPrice()) {
                        if(o1.getBuyTime() > o2.getBuyTime()) return 1;
                        else return -1;
                    }
                    else  return -1;
                });
                break;
        }
        for(Product product : shoppingCart)
            System.out.println(product);
    }

    public boolean refundProduct(Product product) {
        for(int i = 0 ; i < shoppingCart.size(); i++) {
            if(shoppingCart.get(i).equals(product)) {
                Product aProduct = shoppingCart.get(i);
                Store backToStore = aProduct.getBelongStore();
                backToStore.transact(product,1);
                updateWallet(product.getPrice());
                shoppingCart.remove(i);

                return true;
            }
        }
        return false;
    }
}
