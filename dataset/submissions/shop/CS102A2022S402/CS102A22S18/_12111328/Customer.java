import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt ++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product,int rating){
        if(rating>=1&&rating<=5){
            product.getRatings().add(rating);
            return true;
        }
        else {
            return false;
        }
    }

    public void updateWallet(float amount){
        this.wallet = this.wallet + amount;
    }

    public boolean purchaseProduct(Store store,Product product){
        if(store.hasProduct(product)&&this.wallet>=product.getPrice()){
            this.wallet = this.wallet - product.getPrice();
            store.transact(product,0);
            this.shoppingCart.add(product);
            return true;
        }
        else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> sb=new ArrayList<>();
        sb=shoppingCart;
        switch (sortMethod) {
            case PurchaseTime:
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
                break;
            case Rating:
                for (int i = 1; i < shoppingCart.size() ; i++) {
                    for (int j = 0; j < shoppingCart.size() - 1; j++) {
                        if (shoppingCart.get(j).getPrice() > shoppingCart.get(j + 1).getPrice()) {
                            Product m = shoppingCart.get(j);
                            sb.add(j, shoppingCart.get(j + 1));
                            sb.add(j + 1, m);
                        }
                    }
                }
                for (Product product : shoppingCart) {
                    System.out.println(sb);
                }
            case Price:
                for (int i = 1; i < shoppingCart.size() ; i++) {
                    for (int j = 0; j < shoppingCart.size()  - 1; j++) {
                        if (shoppingCart.get(j).getPrice() > shoppingCart.get(j + 1).getPrice()) {
                            Product m = shoppingCart.get(j);
                            sb.add(j, shoppingCart.get(j + 1));
                            sb.add(j + 1, m);
                        }

                    }
                }
                for (Product product : shoppingCart) {
                    System.out.println(sb);
                }
        }
    }
        public boolean refundProduct (Product product){
            return true;
        }
}