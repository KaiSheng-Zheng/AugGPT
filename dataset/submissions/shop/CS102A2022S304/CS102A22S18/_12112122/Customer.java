import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private ArrayList<Product> cartByRate;
    private ArrayList<Product> cartByPrice;
    private float wallet;
    private ArrayList<Store> footPrint;

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
        cartByRate = new ArrayList<>();
        cartByPrice = new ArrayList<>();
        footPrint = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            footPrint.add(store);
            shoppingCart.add(product);
            this.updateWallet(-1 * product.getPrice());
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (Product i : shoppingCart) {
                    System.out.println(i);
                }
                break;
            case Rating:
                setCartByRate();
                for (Product i : cartByRate) {
                    System.out.println(i);
                }
                break;
            case Price:
                setCartByPrice();
                for (Product i : cartByPrice) {
                    System.out.println(i);
                }
                break;
            default:
                break;
        }
    }

    public boolean refundProduct(Product product) {
        if (this.hasProduct(product)) {
            shoppingCart.remove(product);
            cartByPrice.remove(product);
            cartByRate.remove(product);
            for (Store store : footPrint) {
                if (store.rootHas(product)) {
                    store.transact(product, 1);
                    this.wallet += product.getPrice();
                    break;
                }
            }
            return true;
        }
        return false;
    }

    public void setCartByRate() {
        for (Product product : shoppingCart) {
            if (hasProduct(cartByRate, product)) {
                if (cartByRate.size() == 1) {
                    if (cartByRate.get(0).getAvgRating() <= product.getAvgRating()) {
                        cartByRate.add(product);
                        continue;
                    } else {
                        cartByRate.add(0, product);
                        continue;
                    }
                }
                boolean done = false;
                for (int i = 0; i < cartByRate.size() - 1; i++) {
                    if (product.getAvgRating() < cartByRate.get(0).getAvgRating()) {
                        cartByRate.add(0, product);
                        done = true;
                        break;
                    } else if (product.getAvgRating() >= cartByRate.get(i).getAvgRating() && product.getAvgRating() < cartByRate.get(i + 1).getAvgRating()) {
                        cartByRate.add(i + 1, product);
                        done = true;
                        break;
                    }
                }
                if (done) continue;
                cartByRate.add(product);
            }
        }
    }

    public void setCartByPrice() {
        /*for (Product product : shoppingCart) {
            if (hasProduct(cartByPrice, product)) {
                if (cartByPrice.size() == 1) {
                    if (cartByPrice.get(0).getPrice() <= product.getPrice()) {
                        cartByPrice.add(product);
                        continue;
                    } else {
                        cartByPrice.add(0, product);
                        continue;
                    }
                }
                boolean done = false;
                for (int i = 0; i < cartByPrice.size() - 1; i++) {
                    if (product.getPrice() < cartByPrice.get(0).getPrice()) {
                        cartByPrice.add(0, product);
                        done = true;
                        break;
                    } else if (product.getPrice() >= cartByPrice.get(i).getPrice() && product.getPrice() < cartByPrice.get(i + 1).getPrice()) {
                        cartByPrice.add(i + 1, product);
                        done = true;
                        break;
                    }
                }
                if (done) continue;
                cartByPrice.add(product);
            }
        }*/
        ArrayList<Product> result = new ArrayList<>();
        ArrayList<Product> copy = new ArrayList<>();
        ArrayList<Float> price = new ArrayList<>();
        for (Product product : shoppingCart) {
            copy.add(product);
            price.add(product.getPrice());
        }
        Collections.sort(price);
        for (int i = 0; i < price.size(); i++) {
            for (int j = 0; j < copy.size(); j++) {
                if (copy.get(j).getPrice() == price.get(i)) {
                    result.add(copy.get(j));
                    copy.remove(copy.get(j));
                }
            }
        }
        cartByPrice=result;
    }

    private boolean hasProduct(Product product) {
        for (Product i : shoppingCart) {
            if (product.getId() == i.getId()) return true;
        }
        return false;
    }

    private boolean hasProduct(ArrayList<Product> cart, Product product) {
        for (Product i : cart) {
            if (product.getId() == i.getId()) return false;
        }
        return true;
    }
}