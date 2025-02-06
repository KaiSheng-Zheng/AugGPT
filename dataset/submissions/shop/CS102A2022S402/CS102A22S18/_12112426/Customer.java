import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if (product.setRating(rating)){
            return true;
        }else {
            return false;
        }
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&product.getPrice()<=wallet){
            shoppingCart.add(product);
            wallet-= product.getPrice();
            store.transact(product,0);
            return true;
        }else {return false;}
    }
    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (Product product : shoppingCart) {
                    System.out.println(product);
                }
            case Rating:
                Product[] a = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    a[i] = shoppingCart.get(i);
                }
                for (int i = 0; i < shoppingCart.size() - 1; i++) {
                    for (int j = 0; j < shoppingCart.size() - 1 - i; j++) {
                        if (shoppingCart.get(j).getAvgRating() > shoppingCart.get(j + 1).getAvgRating()) {
                            Product temp = shoppingCart.get(j + 1);
                            a[j + 1] = shoppingCart.get(j);
                            a[j] = temp;
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(a[i]);
                }
            case Price:
                Product[] awe = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    awe[i] = shoppingCart.get(i);
                }
                for (int i = 0; i < shoppingCart.size() - 1; i++) {
                    for (int j = 0; j < shoppingCart.size() - 1 - i; j++) {
                        if (shoppingCart.get(j).getPrice() > shoppingCart.get(j + 1).getPrice()) {
                            Product temp = shoppingCart.get(j + 1);
                            awe[j + 1] = shoppingCart.get(j);
                            awe[j] = temp;
                        }
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(awe[i]);
                }
        }

    }


        public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet+=product.getPrice();
            return true;
        }else {
            return false;
        }
    }
}
