import java.util.ArrayList;

class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.cnt++;
        this.id = cnt;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        boolean p2;
        p2 = product.setRating(rating);
        return p2;
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        boolean p3;
        p3 = store.hasProduct(product);
        if (this.wallet >= product.getPrice() && p3) {
            store.transact(product, 0);
            this.wallet -= product.getPrice();
            this.shoppingCart.add(product);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }break;

            case Rating:
                for (int i = 1; i < shoppingCart.size(); i++) {
                    for (int j = 0; j < shoppingCart.size()-i; j++) {
                        if (shoppingCart.get(j).getAvgRating() > shoppingCart.get(j+1).getAvgRating()) {
                            Product c = shoppingCart.get(j);
                            shoppingCart.set(j, shoppingCart.get(j + 1));
                            shoppingCart.set(j + 1, c);
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }break;

            case Price:
                for (int i = 1; i < shoppingCart.size(); i++) {
                    for (int j = 0; j < shoppingCart.size()-i; j++) {
                            if (shoppingCart.get(j).getPrice() > shoppingCart.get(j + 1).getPrice()) {
                                Product a = shoppingCart.get(j);
                                shoppingCart.set(j, shoppingCart.get(j + 1));
                                shoppingCart.set(j + 1, a);
                            }
                        }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }break;
        }

    }


    public boolean refundProduct(Product product) {
        return false;
    }
}