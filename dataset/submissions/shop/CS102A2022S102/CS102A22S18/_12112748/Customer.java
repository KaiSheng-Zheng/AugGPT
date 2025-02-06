import java.util.*;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;

    //    public static int lxqshh = 0;//purchase time count
    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        shoppingCart = new ArrayList<>();
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
//            lxqshh++;
//            product.pt = lxqshh;
            shoppingCart.add(product);
            store.removeProduct(product);
            product.setStore(store);
            store.setIncome(store.getIncome() + product.getPrice());
            wallet -= product.getPrice();
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product lxq = new Product();
        ArrayList<Product> Cart = new ArrayList<>(shoppingCart);
//        Cart.sort(new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                return Float.compare(o1.getPrice(), o2.getPrice());
//                // comparing given Product o1 and o2
//                // return -1 if o1 < o2
//                //         0 if o1 == o2
//                //         1 if o1 > o2
//            }
//        });
//        Cart.sort(new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                return Float.compare(o1.getAvgRating(), o2.getAvgRating());
//            }
//        });
//        System.out.println(Cart);
        switch (sortMethod) {
            case Price: {
                for (int i = 0; i < Cart.size() - 1; i++) {
                    for (int j = 0; j < Cart.size() - 1 - i; j++) {
                        if (Cart.get(j).getPrice() > Cart.get(j + 1).getPrice()) {
                            // swap card j j+1
                            Product p = Cart.get(j);
                            Cart.set(j, Cart.get(j+1));
                            Cart.set(j+1, p);
//                            trans(Cart.get(j), lxq);
//                            trans(Cart.get(j + 1), Cart.get(j));
//                            trans(lxq, Cart.get(j + 1));
                        }
//                        if (Cart.get(j).getPrice() == Cart.get(j + 1).getPrice()
//                                && Cart.get(j).pt > Cart.get(j + 1).pt) {
//                            trans(Cart.get(j), lxq);
//                            trans(Cart.get(j + 1), Cart.get(j));
//                            trans(lxq, Cart.get(j + 1));
//                        }
                    }
                }
                break;
            }
            case Rating: {
                for (int i = 0; i < Cart.size() - 1; i++) {
                    for (int j = 0; j < Cart.size() - 1 - i; j++) {
                        if (Cart.get(j).getAvgRating() > Cart.get(j + 1).getAvgRating()) {
//                            trans(Cart.get(j), lxq);
//                            trans(Cart.get(j + 1), Cart.get(j));
//                            trans(lxq, Cart.get(j + 1));
                            Product p = Cart.get(j);
                            Cart.set(j, Cart.get(j+1));
                            Cart.set(j+1, p);
                        }
//                        if (Cart.get(j).getAvgRating() == Cart.get(j + 1).getAvgRating()
//                                && Cart.get(j).pt > Cart.get(j + 1).pt) {
//                            trans(Cart.get(j), lxq);
//                            trans(Cart.get(j + 1), Cart.get(j));
//                            trans(lxq, Cart.get(j + 1));
//                        }
                    }
                }
                break;
            }
            case PurchaseTime: {
//                for (int i = Cart.size() - 1; i > 0; i--) {
//                    for (int j = 0; j < i; j++) {
//                        if (Cart.get(j).pt > Cart.get(j + 1).pt) {
//                            trans(Cart.get(j), lxq);
//                            trans(Cart.get(j + 1), Cart.get(j));
//                            trans(lxq, Cart.get(j + 1));
//                        }
//                    }
//                }
//                break;
            }
        }
        for (int i = 0; i < Cart.size(); i++) {
            System.out.println(Cart.get(i).toString());
        }
    }

    public boolean refundProduct(Product product) {
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).getId() == product.getId()
                    && shoppingCart.get(i).getName().equals(product.getName())
                    && shoppingCart.get(i).getStore().equals(product.getStore())) {
                wallet += product.getPrice();
                shoppingCart.remove(product);
                product.getStore().transact(product, 1);
                return true;
            }
        }
        return false;
    }

    //copy product a to b
    public void trans(Product a, Product b) {
        b.setId(a.getId());
        b.setPrice(a.getPrice());
        b.setName(a.getName());
        b.setStore(a.getStore());
        b.clear();
        for (int i = 0; i < a.getsize(); i++) {
            b.setRating(a.getRatings(i));
        }
//        b.pt = a.pt;
    }

}
