import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

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
        wallet +=amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.removeProduct(product);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
                if (sortMethod == SortBy.PurchaseTime) {
                    for (int i = 0; i < shoppingCart.size(); i++) {
                        System.out.println(shoppingCart.get(i).toString());
                    }
                } else if (sortMethod == SortBy.Rating) {
                    Product[] a = new Product[shoppingCart.size()];
                    for (int i = 0; i < shoppingCart.size(); i++) {
                        a[i] = shoppingCart.get(i);
                    }
                    for (int i = 0; i < a.length - 1; i++) {
                        boolean b = true;
                        for (int j = 0; j < a.length - 1 - i; j++) {
                            Product temp;
                            if (a[j].getRating() > a[j + 1].getRating()) {
                                b = false;
                                temp = a[j];
                                a[j] = a[j + 1];
                                a[j + 1] = temp;
                            }
                        }
                        if (b) {
                            for (int t = a.length-1; t >=0; t--) {
                                System.out.println(a[t].toString());
                            }
                            break;
                        }
                    }
                } else {
                    Product[] a = new Product[shoppingCart.size()];
                    for (int i = 0; i < shoppingCart.size(); i++) {
                        a[i] = shoppingCart.get(i);
                    }
                    for (int i = 0; i < a.length - 1; i++) {
                        boolean b = true;
                        for (int j = 0; j < a.length - 1 - i; j++) {
                            Product temp;
                            if (a[j].getPrice() > a[j + 1].getPrice()) {
                                b = false;
                                temp = a[j];
                                a[j] = a[j + 1];
                                a[j + 1] = temp;
                            }
                        }
                        if (b) {
                            for (int t = 0; t < a.length; t++) {
                              System.out.println(a[t].toString());
                            }
                            break;
                        }
                    }

                }
             }

    public boolean refundProduct(Product product) {
        return false;
    }
}
