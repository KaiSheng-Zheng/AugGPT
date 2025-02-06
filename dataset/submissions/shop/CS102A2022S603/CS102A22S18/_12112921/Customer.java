import java.util.ArrayList;
public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        cnt++;
        this.name=name;
        this.wallet=wallet;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            wallet-=product.getPrice();
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }
        else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            case Rating:
                float[] ratingArray = new float[shoppingCart.size()];
                for (int j = 0; j < shoppingCart.size(); j++) {
                    ratingArray[j] = shoppingCart.get(j).getAvgRating();
                }
                float minimum = -1f;
                for (int i = 0; i < shoppingCart.size(); i++) {
                    float min = 100000000f;
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        if (ratingArray[j] < min && ratingArray[j] > minimum) {
                            min = ratingArray[j];
                        }
                    }
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        if (shoppingCart.get(j).getAvgRating() == min) {
                            System.out.println(shoppingCart.get(j).toString());
                        }
                    }
                    minimum = min;
                }
                break;
            case Price:
                float[] priceArray = new float[shoppingCart.size()];
                for (int j = 0; j < shoppingCart.size(); j++) {
                    priceArray[j] = shoppingCart.get(j).getPrice();
                }
                float minimum1 = -1f;
                for(int i=0;i<shoppingCart.size();i++){
                    float min = 100000000f;
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        if (priceArray[j] < min &&priceArray[j] > minimum1) {
                            min = priceArray[j];
                        }
                    }
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        if (shoppingCart.get(j).getPrice() == min) {
                            System.out.println(shoppingCart.get(j).toString());
                        }
                    }
                    minimum1 = min;
                }
                break;
        }
    }

    public boolean refundProduct(Product product){
        int m=0;
        for(int i=0;i<shoppingCart.size();i++){
            if(shoppingCart.get(i).equal(product)){
                m=1;
                break;
            }
        }
        if(m==1){
            shoppingCart.remove(product);
            wallet+=product.getPrice();
            product.getFromStore().transact(product,1);
            return true;
        }
        else{
            return false;
        }
    }
    
}