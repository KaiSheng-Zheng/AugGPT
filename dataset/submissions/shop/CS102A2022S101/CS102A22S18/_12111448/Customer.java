import java.util.ArrayList;

public class Customer {
    private static int cnt;  // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();  // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        ++cnt;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        //rate can be used as a verb
        if (product.setRating(rating)) {
            return true;
        }
        return false;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product,0);
            wallet -= product.getPrice();
            shoppingCart.add(product);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        else if (sortMethod == SortBy.Price) {
            ArrayList<Product> ans = new ArrayList<>();
            ArrayList<Product> origin = new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                origin.add(shoppingCart.get(i));
            }
//            System.out.println(shoppingCart.size());
            float min;
            int minIndex;
            for (int i = 0; i < shoppingCart.size(); i++) {
//                System.out.println("yes1");
                min=origin.get(0).getPrice();
                minIndex=0;
                for (int j = 0; j < origin.size(); j++) {
//                    System.out.println("yes2");
                    if (origin.get(j).getPrice()<min){
                        min=origin.get(j).getPrice();
                        minIndex=j;

                    }
                }
                ans.add(origin.get(minIndex));
                origin.remove(minIndex);
            }
            for (int i = 0; i < ans.size(); i++) {
                System.out.println(ans.get(i).toString());
            }
        }
        else if (sortMethod == SortBy.Rating) {
            ArrayList<Product> ans = new ArrayList<>();
            ArrayList<Product> origin = new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                origin.add(shoppingCart.get(i));
            }
            float min;
            int minIndex;
            for (int i = 0; i < shoppingCart.size(); i++) {
                min=origin.get(0).getAvgRating();
                minIndex=0;
                for (int j = 0; j < origin.size(); j++) {
                    if (origin.get(j).getAvgRating()<min){
                        min=origin.get(j).getAvgRating();
                        minIndex=j;
                    }
                }
                ans.add(origin.get(minIndex));
                origin.remove(minIndex);
            }
            for (int i = 0; i < ans.size(); i++) {
                System.out.println(ans.get(i).toString());
            }
        }
    }

    public boolean refundProduct(Product product){
        //bonus
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet+=product.getPrice();
            product.soldStore.transact(product,1);
            return true;
        }
        else {
            return false;
        }
    }
}