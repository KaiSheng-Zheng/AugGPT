import java.util.ArrayList;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;
    private ArrayList<Store> storelist = new ArrayList<>();
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating))return true;
        else return false;
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            //store.removeProduct(product);
            store.transact(product,0);
            wallet=wallet-product.getPrice();
            storelist.add(store);
            shoppingCart.add(product);
            return true;
        }
        else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime){
            ArrayList<Product>sortPurchaseTime=shoppingCart;
            for(int i=0;i<sortPurchaseTime.size();i++){
                System.out.println(sortPurchaseTime.get(i));
                        //Product ID 2, Laptop, RMB 10000.00, Rating 4.5
            }

        }
        if(sortMethod==SortBy.Rating){
            ArrayList<Product>sortPurchaseRating=shoppingCart;
            for(int i=0;i<sortPurchaseRating.size();i++){
                float min=sortPurchaseRating.get(0).getAvgRating();
                int count=0;
                for(int j=0;j<sortPurchaseRating.size()-i;j++){
                    if(sortPurchaseRating.get(j).getAvgRating()<min){
                        min=sortPurchaseRating.get(j).getAvgRating();
                        count=j;
                    }
                    sortPurchaseRating.add(sortPurchaseRating.get(count));
                    sortPurchaseRating.remove(count);
                }
            }
            for(int i=0;i<sortPurchaseRating.size();i++){
                System.out.println(sortPurchaseRating.get(i));
                //Product ID 2, Laptop, RMB 10000.00, Rating 4.5
            }


        }
        if(sortMethod==SortBy.Price){
            ArrayList<Product>sortPurchasePrice=shoppingCart;
            for(int i=0;i<sortPurchasePrice.size();i++){
                float min=sortPurchasePrice.get(0).getPrice();
                int count=0;
                for(int j=0;j<sortPurchasePrice.size()-i;j++){
                    if(sortPurchasePrice.get(j).getPrice()<min){
                        min=sortPurchasePrice.get(j).getPrice();
                        count=j;
                    }
                    sortPurchasePrice.add(sortPurchasePrice.get(count));
                    sortPurchasePrice.remove(count);
                }
            }
            for(int i=0;i<sortPurchasePrice.size();i++){
                System.out.println(sortPurchasePrice.get(i));
                //Product ID 2, Laptop, RMB 10000.00, Rating 4.5
            }

        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)&&storelist.get(shoppingCart.indexOf(product)).getIncome()>product.getPrice()){
            storelist.get(shoppingCart.indexOf(product)).transact(product,1);
            storelist.remove(shoppingCart.indexOf(product));
            shoppingCart.remove(product);
            wallet=wallet+ product.getPrice();
            return true;

        }
        else return false;
    }
}
enum SortBy {
    PurchaseTime, Rating, Price;
}