import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;//initial: 0; one construct one increase
    private int id;//unique for each customer
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();//The list of purchased products; default: empty
    private float wallet;
    private static HashMap hashMap = new HashMap<>();

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;//always valid

    }


    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);

    }


    public void updateWallet(float amount) {//arguments are valid
        this.wallet += amount;

    }


    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            int productId = product.getId();
            hashMap.put(productId, store);//record which store is the product bought from

            this.updateWallet(-product.getPrice());
            this.shoppingCart.add(product);

            store.transact(product, 0);
            return true;

        } else {
            return false;

        }

    }


    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : shoppingCart) {
                System.out.println(product.toString());

            }

        } else if (sortMethod == SortBy.Rating) {
            ArrayList<Product> shoppingCartAgent = new ArrayList<>(shoppingCart);
            shoppingCartAgent.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getAvgRating() > o2.getAvgRating()) {
                        return 1;//exchange positions of o1 & o2

                    } else if (o1.getAvgRating() == o2.getAvgRating()) {
                        if (shoppingCart.indexOf(o1) > shoppingCart.indexOf(o2)) {
                            return 1;

                        } else {
                            return -1;//change noting

                        }
                    } else {
                        return -1;

                    }

                }
            });
            for (Product product : shoppingCartAgent) {
                System.out.println(product.toString());;

            }

        } else if (sortMethod == SortBy.Price) {
            ArrayList<Product> shoppingCartAgent = new ArrayList<>(shoppingCart);
            shoppingCartAgent.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getPrice() > o2.getPrice()) {
                        return 1;

                    } else if (o1.getPrice() == o2.getPrice()) {
                        if (shoppingCart.indexOf(o1) > shoppingCart.indexOf(o2)) {
                            return 1;

                        } else{
                            return -1;

                        }

                    } else {
                        return -1;

                    }
                }
            });
            for (Product product : shoppingCartAgent) {
                System.out.println(product.toString());

            }
        }
    }


    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            Store store = (Store) hashMap.get(product.getId());
            store.transact(product, 1);

            this.updateWallet(+product.getPrice());
            this.shoppingCart.remove(product);

            return true;

        } else {
            return false;

        }

    }
}
enum SortBy {
    PurchaseTime, Rating, Price
}

