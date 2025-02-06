import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;


    }

    public boolean rateProduct(Product product, int rating) {
        boolean flag;
        if (1 <= rating && rating <= 5) {
            flag = true;
            product.setRating(rating);
        } else {
            flag = false;
        }

        return flag;
    }

    public void updateWallet(float amount) {
        this.wallet = this.wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        boolean flag = false;
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            updateWallet(-product.getPrice());
            this.shoppingCart.add(product);
            store.removeProduct(product);
            store.setIncome(store.getIncome() + product.getPrice());
            flag = true;
        }
        return flag;
    }


    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case Rating:
                ArrayList<Product> c = new ArrayList<>();
                ArrayList<Product> d = new ArrayList<>();
                for (int j=0;j<this.shoppingCart.size();j++) {
                    d.add(shoppingCart.get(j));
                }
                float min = 6;
                int count3 = 0;
                do {
                    int i;
                    for (i=0;i<d.size();i++) {
                        if (min > d.get(i).getAvgRating()) {
                            min = d.get(i).getAvgRating();
                            count3 = i;
                        }
                    }
                    min = 6;
                    c.add(d.get(count3));
                    d.remove(count3);
                } while (d.size() > 0);

                for (int j=0;j<c.size();j++) {
                    System.out.println(c.get(j).toString());
                }
                break;
            case Price:
                ArrayList<Product> a = new ArrayList<>();
                ArrayList<Product> b = new ArrayList<>();
                for (int j=0;j<this.shoppingCart.size();j++) {
                    b.add(shoppingCart.get(j));
                }
                float max = -1;
                int count = 0;
                do {
                    int i;
                    for (i=0;i<b.size();i++) {
                        if (max <= b.get(i).getPrice()) {
                            max = b.get(i).getPrice();
                            count = i;
                        }
                    }
                    max = -1;
                    a.add(b.get(count));
                    b.remove(count);
                } while (b.size() > 0);

                for (int j=a.size()-1;j>=0;j--) {
                    System.out.println(a.get(j).toString());
                }
                break;
            case PurchaseTime:
                for (int i=0;i<this.shoppingCart.size();i++) {
                    System.out.println(this.shoppingCart.get(i).toString());
                }
        }
    }
    

}