import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {

    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Product> newshoppingCart = new ArrayList<>();
    private float wallet;
    private HashMap<Integer, Store> shopAndProduct = new HashMap<>();

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating <= 5 && rating >= 1) {
            product.setRatings(rating);
            return true;
        } else
            return false;
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        boolean flag = false;
        if (wallet >= product.getPrice()) {
            for (int i = 0; i < store.getProductList().size(); i++) {
                if (store.getProductList().get(i).getId() == product.getId()) {
                    this.updateWallet(-product.getPrice());
                    this.shoppingCart.add(product);
                    this.newshoppingCart.add(product);
                    store.removeProduct(product);
                    store.setIncome(store.getIncome() + product.getPrice());
                    this.shopAndProduct.put(product.getId(), store);
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod.getId()) {
            case 3: {
                newshoppingCart.sort(new SortbyPrice());
                for (int i = 0; i < newshoppingCart.size(); i++) {
                    System.out.println(newshoppingCart.get(i));
                }
            }
            case 2: {
                for (int i = 0; i < newshoppingCart.size(); i++) {
                    for (int j = i + 1; j < newshoppingCart.size(); j++) {
                        if (newshoppingCart.get(j).getAvgRating() < newshoppingCart.get(i).getAvgRating()) {
                            Product n = newshoppingCart.get(j);
                            newshoppingCart.set(j, newshoppingCart.get(i));
                            newshoppingCart.set(i, n);
                        } else if (newshoppingCart.get(j).getAvgRating() == newshoppingCart.get(i).getAvgRating()) {
                            int n1 = 0, n2=0;
                            for (int k = 0; k < shoppingCart.size(); k++) {
                                if (shoppingCart.get(k).getId() == newshoppingCart.get(i).getId()) {
                                    n1 = k;
                                }
                                if (shoppingCart.get(k).getId() == newshoppingCart.get(j).getId()) {
                                    n2 = k;
                                }
                            }
                            if (n1 > n2) {
                                Product n = newshoppingCart.get(j);
                                newshoppingCart.set(j, newshoppingCart.get(i));
                                newshoppingCart.set(i, n);
                            }
                        }
                    }
                }
                for (int i = 0; i < newshoppingCart.size(); i++) {
                    System.out.println(newshoppingCart.get(i));
                }
            }
            case 1: {
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
            }
        }
    }

    public boolean refundProduct(Product product) {
        boolean flag = false;
        for (int i = 0; i < this.shoppingCart.size(); i++) {
            if (product.getId() == this.shoppingCart.get(i).getId()) {
                this.shoppingCart.remove(product);
                this.newshoppingCart.remove(product);
                this.updateWallet(product.getPrice());
                Store newStore = this.shopAndProduct.get(product.getId());
                newStore.addProduct(product);
                newStore.setIncome(newStore.getIncome() - product.getPrice());
                flag = true;
                break;
            }

        }
        return flag;
    }
}

class SortbyPrice implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}