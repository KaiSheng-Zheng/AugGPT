import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when th constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    /*The id of the first customer is 1. The given wallet is always valid.
     */
    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = new String(name);
        this.wallet = wallet;
    }

    /*A customer can rate a product using this method.
For invalid rating, return false; otherwise return true.
*/
    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    /*Update the wallet of this customer. The amount could be positive (gaining money) or negative (consuming
    money). Assume that arguments are always valid.
         */
    public void updateWallet(float amount) {
        this.wallet = this.wallet + amount;
    }


    /*Purchase product from store.
Return true if the store has this product and the customer has enough money in the wallet to
purchase this product; return false otherwise. Note that the shoppingCart of this customer as well
as his/her wallet should be updated accordingly
     */
    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) & product.getPrice() <= this.wallet) {
            this.wallet = this.wallet - product.getPrice();
            store.transact(product,0);
            store.removeProduct(product);
            this.shoppingCart.add(product);
            return true;
        } else {
            return false;
        }
    }

    /*Display the purchased products in the shoppingCart of this customer. The order of displaying is specified by
sortMethod. Below we provide an Enum SortBy, which says that sorting could be performed by the
PurchaseTime, Rating, or the Price of products.
     */
    public void viewShoppingCart(SortBy sortMethod) {
        List<Product> list = new ArrayList<>(this.shoppingCart);

        if (sortMethod==SortBy.Rating) {
            Collections.sort(this.shoppingCart, Product.rateComparator);
        } else if (sortMethod==SortBy.Price) {
            Collections.sort(this.shoppingCart, Product.priceComparator);
        }

        for (Product info:this.shoppingCart){
            System.out.println(info.toString());
        }
    }


    /*(Bonus): Return the product to the store where it was sold and get the money back. Return true if this
customer has indeed purchased this product before and false otherwise. Note that the shoppingCart and
wallet of this customer should be updated accordingly. In addition, the corresponding store should enable
the refund process to update the productList and income.
     */

    public boolean refundProduct(Product product){
        return false;
    }




}


