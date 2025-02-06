import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt = cnt + 1;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        } else {
            product.setRating(rating);
            return true;
        }
    }

    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        float income;
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.getProductList().remove(product);
            shoppingCart.add(product);
            wallet = wallet - product.getPrice();
            income = store.getIncome() + product.getPrice();
            store.setIncome(income);
            product.setStore(store);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }

        } else if (sortMethod.equals(SortBy.Rating)) {
       /*     getShoppingCart().sort(new Comparator<Product>() {
                @Override
                public int compare(Product product1, Product product2) {
                    if(product1.getAvgRating()!=product2.getAvgRating())
                        return (int) (product1.getAvgRating() - product2.getAvgRating());
                    return (int) (product1.getAvgRating() - product2.getAvgRating());
                }

            });*/
            for(int i=0;i<shoppingCart.size();i++){
                for(int j=0;j<shoppingCart.size()-1-i;j++){
                    if(shoppingCart.get(j).getAvgRating()>shoppingCart.get(j+1).getAvgRating()){
                        Product product=shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j+1,product);
                    }
                }
            }

            for (int i = 0; i < shoppingCart.size(); i++) {

                System.out.println(shoppingCart.get(i).toString());
            }


        } else if (sortMethod.equals(SortBy.Price)) {

          /*  getShoppingCart().sort(new Comparator<Product>() {

                @Override
                public int compare(Product product1, Product product2) {
                    if (product1.getPrice() == product2.getPrice()){

                        for (int i = 0; i < shoppingCart.size(); i++) {
                            System.out.println(shoppingCart.get(i).toString());
                        }

                    }else {
                        return (int)(product1.getPrice() - product2.getPrice());
                    }

                }
            });
*/
            for(int i=0;i<shoppingCart.size();i++){
                for(int j=0;j<shoppingCart.size()-1-i;j++){
                    if(shoppingCart.get(j).getPrice()>shoppingCart.get(j+1).getPrice()){
                        Product product=shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j+1,product);
                    }
                }
            }
            for(int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i));
            }
        }

    }


    public ArrayList<Product> getShoppingCart () {
        return shoppingCart;
    }
     public boolean refundProduct (Product product){
        if(shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet=wallet+ product.getPrice();
            product.getStore().transact(product,1);
            return true;
        } else {
            return false;
        }
    }
}


