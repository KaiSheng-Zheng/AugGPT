import java.util.ArrayList;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet +=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        boolean testIfProduct = false;
        boolean testIfWallet = false;
        for (int i=0;i<store.getProductList().size();i++){
            if (store.getProductList().get(i)==product){
                testIfProduct = true;
                break;
            }
        }
        if (product.getPrice()<=this.wallet){
            testIfWallet = true;
        }

        if (testIfProduct==true && testIfWallet==true){
            shoppingCart.add(product);
            wallet -= product.getPrice();
            return true;
        }
        else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (int i=0;i<this.shoppingCart.size();i++){
                System.out.println(this.shoppingCart.get(i).toString());
            }
        }
        else if (sortMethod==SortBy.Rating){
            for (int i=this.shoppingCart.size()-1;i>0;i--){
                for (int j=0;j<i;j++){
                    if (this.shoppingCart.get(i).getRatings().get(0)<this.shoppingCart.get(j).getRatings().get(0)){
                        Product temp = this.shoppingCart.get(i);
                        this.shoppingCart.set(i,this.shoppingCart.get(j));
                        this.shoppingCart.set(j,temp);
                    }
                }

            }
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                System.out.println(this.shoppingCart.get(i).toString());
            }
        }
        else if (sortMethod==SortBy.Price){
            for (int i=this.shoppingCart.size()-1;i>0;i--){
                for (int j=0;j<i;j++){
                    if (this.shoppingCart.get(i).getPrice()<this.shoppingCart.get(j).getPrice()){
                        Product temp = this.shoppingCart.get(i);
                        this.shoppingCart.set(i,this.shoppingCart.get(j));
                        this.shoppingCart.set(j,temp);
                    }
                }
            }
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                System.out.println(this.shoppingCart.get(i).toString());
            }
        }
    }
}
