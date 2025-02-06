import java.util.*;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    public static int count=1;


    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }


    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.getProductList().contains(product)&&this.wallet>=product.getPrice()){
            this.shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product,0);
            product.belongedTo=store;
            product.order=count;
            count++;
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime :
                for (Product product : shoppingCart) System.out.println(product.toString());
                break;
            case Price:
                shoppingCart.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if(o1.getPrice()>o2.getPrice()) return 1;
                        else if(o1.getPrice()==o2.getPrice()){
                            if(o1.order>o2.order) return 1;
                            else if(o1.order==o2.order) return 0;
                            else return -1;
                        }
                        else return -1;
                    }
                });
                for (Product product : shoppingCart) System.out.println(product.toString());
                break;
            case Rating:
                shoppingCart.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if(o1.getAvgRating()>o2.getAvgRating()) return 1;
                        else if(o1.getAvgRating()==o2.getAvgRating()){
                            if(o1.order>o2.order) return 1;
                            else if(o1.order==o2.order) return 0;
                            else return -1;
                        }
                        else return -1;
                    }
                });
                for (Product product : shoppingCart) System.out.println(product.toString());
                break;

        }
    }

    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            updateWallet(product.getPrice());
            product.belongedTo.transact(product,1);
            shoppingCart.remove(product);
            return true;
        }
        return false;
    }


}
