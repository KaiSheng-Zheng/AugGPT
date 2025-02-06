import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt = cnt + 1;
        id = cnt;
    }
//
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void  updateWallet(float amount){
        this.wallet = wallet + amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (this.wallet > product.getPrice() & store.getProductList().contains(product)){
            this.wallet = wallet - product.getPrice();
            store.getProductList().remove(product);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
                break;
            case Rating:
                ArrayList<Product> sC = new ArrayList<>(shoppingCart.size());
                Product x;
                for (int i = 0; i < shoppingCart.size(); i++) {
                    x = shoppingCart.get(i);
                    for (int j = i; j < shoppingCart.size(); j++) {
                        if(shoppingCart.get(i).getAvgRating() > shoppingCart.get(j).getAvgRating()){
                            x = shoppingCart.get(j);
                        }
                    }
                    sC.add(x);
                }
                for (Product product : sC) {
                    System.out.println(product.toString());
                }
                break;
            case Price:
                ArrayList<Product> SC = new ArrayList<>(shoppingCart.size());
                Product y;
                for (int i = 0; i < shoppingCart.size(); i++) {
                    y = shoppingCart.get(i);
                    for (int j = i; j < shoppingCart.size(); j++) {
                        if(shoppingCart.get(i).getPrice() < shoppingCart.get(j).getPrice()){
                            y = shoppingCart.get(j);
                        }
                    }
                    SC.add(y);
                }
                for (Product product : SC) {
                    System.out.println(product.toString());
                }
                break;
        }
    }
}
