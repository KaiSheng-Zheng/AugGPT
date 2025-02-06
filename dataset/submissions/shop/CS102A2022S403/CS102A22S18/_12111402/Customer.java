import java.util.ArrayList;


public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart= new ArrayList<>();
    private float wallet;



    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt += 1;
        this.id  = cnt;
        this.shoppingCart = new ArrayList<>();
    }


    public boolean rateProduct(Product product, int rating){
        if(rating == 1 | rating == 2 | rating == 3 | rating == 4 | rating == 5) {
            product.setRating(rating);
            return true;
        }
        else{
            return false;
        }
    }


    public void updateWallet(float amount){
        wallet += amount;

    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet >= product.getPrice()){
            updateWallet(-product.getPrice());
            store.removeProduct(product);
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }
        else return false;

    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod.equals(SortBy.PurchaseTime)){
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if(sortMethod.equals(SortBy.Rating)){
            Product[] array = new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                array[i] = shoppingCart.get(i);
            }
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - 1 - i; j++) {
                    Product sort;
                    if(array[i].getAvgRating()>array[j+1].getAvgRating()){
                        sort = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = sort;
                    }

                }

            }
            for (Product product : array) {
                System.out.println(product.toString());

            }
        }


        if(sortMethod.equals(SortBy.Price)){
            Product[] array = new Product[shoppingCart.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = shoppingCart.get(i);
            }
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - 1 - i; j++) {
                    Product sort;
                    if(array[i].getPrice()>array[j+1].getPrice()){
                        sort = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = sort;
                    }

                }

            }
            for (Product product : array) {
                System.out.println(product.toString());

            }
        }

    }
    public boolean refundProduct(Product product){
            if(!this.shoppingCart.contains(product)){
                return false;
            }
            else{
                shoppingCart.remove(product);
                updateWallet(product.getPrice());
                product.whichStore.transact(product,1);
                return true;
            }

    }

}
