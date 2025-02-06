import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Customer {

    private static AtomicInteger count = new AtomicInteger();

    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList(); // The list of purchased products;default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        count.set(cnt);
        count.incrementAndGet();
        int i = count.get();
        this.id = i;
        cnt = i;

        this.name = name;
        this.wallet = wallet;
    }


    public boolean rateProduct(Product product, int rating){
        return  product.setRating(rating);
    }

    /**
     * Update the wallet of this customer. The amount could be positive (gaining money) or negative (consuming
     * money). Assume that arguments are always valid.
     * @param amount
     * @return
     */
    public void updateWallet(float amount){

        this.wallet += amount;
    }

    /**
     *  Return true if the store has this product and the customer has enough money in the wallet to
     * purchase this product; return false otherwise. Note that the shoppingCart of this customer as well
     * as his/her wallet should be updated accordingly.
     * @param store
     * @param product
     * @return
     */
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && this.wallet >= product.getPrice()){
            store.transact(product,0);

            product.setStore(store);//purchaseProduct record store
            this.shoppingCart.add(product);
            this.wallet -= product.getPrice();
            return true;
        }
        return false;
    }

    /**
     * Display the purchased products in the shoppingCart of this customer. The order of displaying is specified by
     * sortMethod. Below we provide an Enum SortBy, which says that sorting could be performed by the
     * PurchaseTime, Rating, or the Price of products.
     * @param sortMethod
     */
    public void viewShoppingCart(SortBy sortMethod){
        //Sort by purchase time by default
        if (sortMethod == SortBy.Price){
           shoppingCart = (ArrayList<Product>)shoppingCart.stream() .sorted(
                Comparator.comparing(Product::getPrice)
            ).collect(Collectors.toList());
        }else if (sortMethod == SortBy.Rating){
            shoppingCart = (ArrayList<Product>) shoppingCart.stream() .sorted(
                    Comparator.comparing(Product::getAvgRating)
            ).collect(Collectors.toList());
        }
        display(shoppingCart);
    }

    private void display(ArrayList<Product> shoppingCart) {
        for (Product product : shoppingCart){
            System.out.println(product.toString());
        }

    }

    /**
     *  (Bonus): Return the product to the store where it was sold and get the money back. Return true if this
     * customer has indeed purchased this product before and false otherwise. Note that the shoppingCart and
     * wallet of this customer should be updated accordingly. In addition, the corresponding store should enable
     * the refund process to update the productList and income.
     * @param product
     * @return
     */
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            Store store = product.getStore();
            if (store != null){
                store.transact(product,1);
            }

            shoppingCart.remove(product);
            wallet += product.getPrice();
            return true;
        }
        return false;
    }
}



