import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private ArrayList<Store> s=new ArrayList<>();
    public Customer(String name, float wallet) {
        cnt++;
        this.name = name;
        this.wallet = wallet;
        this.id = cnt;
    }


    public boolean rateProduct(Product product, int rating) {
        if (rating >= 1 && rating <= 5) {
            product.setRating(rating);
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            s.add(store);
            store.removeProduct(product);
            store.transact(product,0);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> sub=new ArrayList<>();
        sub=shoppingCart;
        switch (sortMethod) {
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
                break;
            case Rating:


                for (int i = 1; i < sub.size(); i++) {
                    for (int j = 0; j < sub.size() - 1; j++) {
                        if (sub.get(j).getAvgRating() > sub.get(j + 1).getAvgRating()) {
                            Product temp;
                            temp = sub.get(j);
                            sub.remove(j);
                            sub.add(j+1,temp);


                        }
                    }

                }
                for (int i = 0; i < sub.size(); i++) {
                    System.out.println(sub.get(i));

                }
                break;
            case Price:


                for (int i = 1; i < shoppingCart.size(); i++) {
                    for (int j = 0; j < shoppingCart.size() - 1; j++) {
                        if (sub.get(j).getPrice() > sub.get(j + 1).getPrice()) {
                            Product temp;
                            temp = sub.get(j);
                           sub.remove(j);
                           sub.add(j+1,temp);

                        }
                    }

                }
                for (int i = 0; i < sub.size(); i++) {
                    System.out.println(sub.get(i));
                }
break;
        }

    }

    public boolean refundProduct(Product product) {
        if(shoppingCart.contains(product))
        {
      s.get(shoppingCart.indexOf(product)).transact(product,1);
      s.remove((shoppingCart.indexOf(product)));
      shoppingCart.remove(product);

      updateWallet(product.getPrice());
      return true;
        }
        else {
            return false;
        }

    }
}




