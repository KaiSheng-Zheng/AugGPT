

import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    int p = 0;//indicate the purchaseTime;
    private ArrayList<Product> productsEverBought = new ArrayList<>();

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
        //  productsEverBought.addAll(shoppingCart);
    }//check

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.setWallet(getWallet() + amount);
    }

    public boolean purchaseProduct(Store store, Product product) {


        boolean flag1 = false;
        if (store.hasProduct(product)) flag1 = true;
        boolean flag2 = false;
        if (product.getPrice() <= this.getWallet()) flag2 = true;
        if (flag1 && flag2) {
            product.setBelongingStore(store);
            this.setWallet(getWallet() - product.getPrice());
            store.getProductList().remove(product);
            store.setIncome(store.getIncome()+product.getPrice());
            this.getShoppingCart().add(product);
            p++;
            product.setpTime(p);
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            // shoppingCart.sort(new Comparator<Product>() {
            //     @Override
            //     public int compare(Product o1, Product o2) {
            //         return o1.getpTime() - o2.getpTime();
            //     }
            // });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\n", shoppingCart.get(i).getId(), shoppingCart.get(i).getName(), shoppingCart.get(i).getPrice(), shoppingCart.get(i).getAvgRating());
            }
        } else if (sortMethod == SortBy.Price) {
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getPrice() == o2.getPrice()) {
                        return o1.getpTime() - o2.getpTime();
                    } else return (o1.getPrice() < o2.getPrice() ? -1 : 1);

                }

            });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\n", shoppingCart.get(i).getId(), shoppingCart.get(i).getName(), shoppingCart.get(i).getPrice(), shoppingCart.get(i).getAvgRating());
            }
        } else if (sortMethod == SortBy.Rating) {
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getAvgRating() == o2.getAvgRating()) {
                        return o1.getpTime() - o2.getpTime();
                    } else return (o1.getAvgRating() < o2.getAvgRating() ? -1 : 1);
                }
            });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\n", shoppingCart.get(i).getId(), shoppingCart.get(i).getName(), shoppingCart.get(i).getPrice(), shoppingCart.get(i).getAvgRating());
            }
        }

    }


    public boolean refundProduct(Product product) {

        if (!shoppingCart.contains(product)) return false;
            shoppingCart.remove(product);
            setWallet(getWallet() + product.getPrice());
            product.getBelongingStore().addProduct(product);
            product.getBelongingStore().setIncome(product.getBelongingStore().getIncome() - product.getPrice());
            return true;

    }
}

