import java.util.*;

public class Customer {


    // Attributes
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products default is empty.
    private float wallet;


    // Constructor
    public Customer(String name, float wallet) {

        // Alter counter
        cnt += 1;

        //Input
        this.name = name;
        this.id = cnt;
        this.shoppingCart = new ArrayList<Product>();
        this.wallet = wallet;

    }


    // Methods
    // rateProduct
    public boolean rateProduct(Product product, int rating) {

        // Attributes
        boolean validity;

        // Operation
        validity = product.setRating(rating);

        // Return
        return validity;

    }


    // updateWallet
    public void updateWallet(float amount) {

        this.wallet += amount;

    }


    // purchaseProduct
    public boolean purchaseProduct(Store store, Product product) {

        // Attributes
        boolean storeValidity = store.hasProduct(product);
        boolean customerValidity = (wallet > product.getPrice());
        boolean purchaseValidity;

        // Operation
        if (storeValidity && customerValidity) {

            store.transact(product, 0);
            updateWallet(((-1.0f) * product.getPrice()));
            shoppingCart.add(product);

            purchaseValidity = true;

            product.setStore(store);

        } else {

            purchaseValidity = false;

        }


        return purchaseValidity;

    }


    // viewShoppingCart
    public void viewShoppingCart(SortBy sortMethod) {


        if (sortMethod.equals(SortBy.PurchaseTime)) {

            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }

        }

        else if (sortMethod.equals(SortBy.Rating)) {

            ArrayList<Product> shoppingCartCopy;
            shoppingCartCopy = shoppingCart;

            // Sort by ratings
            for (int i = 0; i < shoppingCartCopy.size(); i++) {
                for (int j = i + 1; j < shoppingCartCopy.size(); j++) {
                    if (shoppingCartCopy.get(i).getAvgRating() > shoppingCartCopy.get(j).getAvgRating()) {
                        Collections.swap(shoppingCartCopy, i, j);
                    }
                }
            }

            // Sort by time
            for (int i = 0; i < shoppingCartCopy.size(); i++) {
                for (int j = i + 1; j < shoppingCartCopy.size(); j++) {

                    if (shoppingCartCopy.get(i).getAvgRating() == shoppingCartCopy.get(j).getAvgRating() && shoppingCartCopy.get(i).getId() > shoppingCartCopy.get(j).getId()) {
                            Collections.swap(shoppingCartCopy, i, j);
                    }

                }
            }

            // Output
            for (int i = 0; i < shoppingCartCopy.size(); i++) {
                System.out.println(shoppingCartCopy.get(i).toString());
            }

        }

        else if (sortMethod.equals(SortBy.Price)) {

            ArrayList<Product> shoppingCartCopy;
            shoppingCartCopy = shoppingCart;

            // Sort by ratings
            for (int i = 0; i < shoppingCartCopy.size(); i++) {
                for (int j = i + 1; j < shoppingCartCopy.size(); j++) {
                    if (shoppingCartCopy.get(i).getPrice() > shoppingCartCopy.get(j).getPrice()) {
                        Collections.swap(shoppingCartCopy, i, j);
                    }
                }
            }

            // Sort by time
            for (int i = 0; i < shoppingCartCopy.size(); i++) {
                for (int j = i + 1; j < shoppingCartCopy.size(); j++) {

                    if (shoppingCartCopy.get(i).getPrice() == shoppingCartCopy.get(j).getPrice() && shoppingCartCopy.get(i).getId() > shoppingCartCopy.get(j).getId()) {
                        Collections.swap(shoppingCartCopy, i, j);
                    }

                }
            }

            // Output
            for (int i = 0; i < shoppingCartCopy.size(); i++) {
                System.out.println(shoppingCartCopy.get(i).toString());
            }
            
        }

    }


    /*
    // Special Method
    // Sorting
    public static Comparator<Product> sortByRating = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            float avgRating1 = o1.getAvgRating();
            float avgRating2 = o2.getAvgRating();
            return avgRating1 - avgRating2;
        }
    };

     */


    // Bonus Method
    // refundProduct
    public boolean refundProduct(Product product) {

        // Attributes
        boolean validity = shoppingCart.contains(product);

        // Operations
        if (validity) {

            product.getStore().transact(product, 1);
            shoppingCart.remove(product);
            updateWallet((product.getPrice()));

        }

        // Return
        return validity;

    }


}
