import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id = ++cnt;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Store> purchasedStore = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (!store.hasProduct(product) || product.getPrice() > wallet) {
            return false;
        }

        wallet -= product.getPrice();
        store.transact(product, 0);
        shoppingCart.add(product);
        purchasedStore.add(store);
        return true;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (Product product : shoppingCart) {
                    System.out.println(product);
                }
            case Rating:
                shoppingCart.stream().sorted((one, another) -> {
                    float difference = one.getAvgRating() - another.getAvgRating();
                    if (difference != 0) {
                        return difference > 0 ? 1 : -1;
                    }

                    return shoppingCart.indexOf(one) - shoppingCart.indexOf(another);
                }).forEach(System.out::println);
            case Price:
                shoppingCart.stream().sorted((one, another) -> {
                    float difference = one.getPrice() - another.getPrice();
                    if (difference != 0) {
                        return difference > 0 ? 1 : -1;
                    }

                    return shoppingCart.indexOf(one) - shoppingCart.indexOf(another);
                }).forEach(System.out::println);
        }
    }

    public boolean refundProduct(Product product) {
        int index = shoppingCart.indexOf(product);
        if (index < 0) {
            return false;
        }

        purchasedStore.remove(index).transact(product, 1);
        shoppingCart.remove(index);
        wallet += product.getPrice();
        return true;
    }
}
