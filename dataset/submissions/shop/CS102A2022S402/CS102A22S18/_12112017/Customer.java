import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    static ArrayList<Store> storeAdd = new ArrayList<>();
    static ArrayList<Product> productsBuy = new ArrayList<>();
    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if (rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        }

        return false;
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (product.getPrice()<=wallet&&store.getProductList().contains(product)){
            shoppingCart.add(product);
            store.transact(product,0);
            updateWallet(-product.getPrice());
            storeAdd.add(store);
            productsBuy.add(product);
            return true;
        }
        return false;
    }


    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        else if (sortMethod==SortBy.Rating){
            Product[] ratingArray = new Product[shoppingCart.size()];
            for (int i=0;i<shoppingCart.size();i++){
                ratingArray[i] = shoppingCart.get(i);
            }
            boobSort(ratingArray);
            for (Product product : ratingArray) {
                System.out.println(product.toString());
            }
        }
        else if (sortMethod==SortBy.Price){
            Product[] priceArray = new Product[shoppingCart.size()];
            for (int i=0;i<shoppingCart.size();i++){
                priceArray[i] = shoppingCart.get(i);
            }
            BoobSort(priceArray);
            for (Product product : priceArray) {
                System.out.println(product.toString());
            }
        }

    }
    public void boobSort(Product[] sortArray){
        Product tmp;
        for (int i=0;i<sortArray.length-1;i++){
            for (int j=0;j<sortArray.length-1-i;j++){
                if (sortArray[j].getAvgRating()>sortArray[j+1].getAvgRating()){
                    tmp = sortArray[j];
                    sortArray[j] = sortArray[j+1];
                    sortArray[j+1] = tmp;
                }
            }
        }
    }
    public void BoobSort(Product[] sortArray){
        Product tmp2;
        for (int i=0;i<sortArray.length-1;i++){
            for (int j=0;j<sortArray.length-1-i;j++){
                if (sortArray[j].getPrice()>sortArray[j+1].getPrice()){
                    tmp2 = sortArray[j];
                    sortArray[j] = sortArray[j+1];
                    sortArray[j+1] = tmp2;
                }
            }
        }
    }
    public boolean refundProduct(Product product){
        if (productsBuy.contains(product)&&shoppingCart.contains(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            storeAdd.get(productsBuy.indexOf(product)).transact(product,1);
            return true;
        }
        return false;
    }


}
enum SortBy {
    PurchaseTime, Rating, Price
}

