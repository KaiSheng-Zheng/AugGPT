import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private static int cno = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        }
        product.setRating(rating);
        return true;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (!store.hasProduct(product)) {
            return false;
        } else if (product.getPrice() > wallet) {
            return false;
        } else {
            wallet -= product.getPrice();
            store.transact(product, 0);
            shoppingCart.add(product);
            cno++;
            product.setPurchaseTime(cno);
            product.setPurchased(true);
            product.setOriginalStore(store);
            return true;
        }
    }

    public boolean refundProduct(Product product) {
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).getId() == product.getId()) {
                shoppingCart.remove(i);
                shoppingCart.get(i).getOriginalStore().transact(product, 1);
                wallet += product.getPrice();
                product.setPurchaseTime(0);
                product.setPurchased(false);
                product.setOriginalStore(null);
                return true;
            }
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                shoppingCart.sort(new Comparator<Product>(){
                    @Override
                    public int compare(Product arg0 , Product arg1) {
                        if (arg0.getPurchaseTime() > arg1.getPurchaseTime()) {
                            return 1;
                        } else if (arg0.getPurchaseTime() < arg1.getPurchaseTime()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    };
                });
                break;
            case Price:
                shoppingCart.sort(new Comparator<Product>(){
                    @Override
                    public int compare(Product arg0 , Product arg1) {
                        if (arg0.getPrice() > arg1.getPrice()) {
                            return 1;
                        } else if (arg0.getPrice() < arg1.getPrice()) {
                            return -1;
                        } else {
                            if (arg0.getPurchaseTime() > arg1.getPurchaseTime()) {
                                return 1;
                            } else if (arg0.getPurchaseTime() < arg1.getPurchaseTime()) {
                                return -1;
                            } else {
                                return 0;
                            }
                        }
                    };
                });
                break;
            case Rating:
                shoppingCart.sort(new Comparator<Product>(){
                    @Override
                    public int compare(Product arg0 , Product arg1) {
                        if (arg0.getAvgRating() > arg1.getAvgRating()) {
                            return 1;
                        } else if (arg0.getAvgRating() < arg1.getAvgRating()) {
                            return -1;
                        } else {
                            if (arg0.getPurchaseTime() > arg1.getPurchaseTime()) {
                                return 1;
                            } else if (arg0.getPurchaseTime() < arg1.getPurchaseTime()) {
                                return -1;
                            } else {
                                return 0;
                            }
                        }
                    };
                });
                break;
        }
        for (int i = 0; i < shoppingCart.size(); i++) {
            System.out.println(shoppingCart.get(i));
        }
    }
}
