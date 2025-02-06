import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet>=product.getPrice()){
            store.transact(product,0);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            return true;
        }
        else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case Price:
                for(int i=0;i<shoppingCart.size();i++){
                    for (int j = 0; j < shoppingCart.size() - i - 1; j++) {
                        if (shoppingCart.get(i).getPrice()> shoppingCart.get(j + 1).getPrice()) {
                            Product t = shoppingCart.get(j);
                            shoppingCart.set(j,shoppingCart.get(j + 1));
                            shoppingCart.set(j + 1,t);
                        }


                    }
                }
                for(Product product:shoppingCart){
                    System.out.println(product.toString());
                }
                break;
            case Rating:
                for(int i=0;i<shoppingCart.size();i++){
                    for (int j = 0; j < shoppingCart.size() - i - 1; j++) {
                        if (shoppingCart.get(i).getAvgRating()> shoppingCart.get(j + 1).getAvgRating()) {
                            Product t = shoppingCart.get(j);
                            shoppingCart.set(j,shoppingCart.get(j + 1));
                            shoppingCart.set(j + 1,t);
                        }
                    }
                }
                for(Product product:shoppingCart){
                    System.out.println(product.toString());
                }
                break;
            case PurchaseTime:
                for(Product product:shoppingCart){
                    System.out.println(product.toString());
                }
                break;

        }
    }


}


