import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id = 0;  // unique for each customer and the value is set to cnt.
    private String name;
    private int[] purchaseId = new int[1000001];
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.

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
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (wallet >= product.getPrice() && store.hasProduct(product))
        {
            shoppingCart.add(product);
            product.setTime(shoppingCart.size());
            wallet -= product.getPrice();
            store.setIncome(store.getIncome() + product.getPrice());
            store.removeProduct(product);
            purchaseId[product.getId()] = 1;
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> shoppingCartAlt = new ArrayList<>();
        for (int i = 0; i < shoppingCart.size(); i++)
            shoppingCartAlt.add(shoppingCart.get(i));
//        if (sortMethod == SortBy.PurchaseTime)
//            shoppingCart.sort(new ProductTimeComparator());
        if (sortMethod == SortBy.Rating)
            shoppingCartAlt.sort(new ProductRatingComparator());
        if (sortMethod == SortBy.Price)
            shoppingCartAlt.sort(new ProductPriceComparator());
        for (int i = 0; i < shoppingCartAlt.size(); i++)
            System.out.println(shoppingCartAlt.get(i));

    }
    public boolean refundProduct(Product product){
        int count = 0;
        if (purchaseId[product.getId()] == 1)
        {
            for (int i = 0; i < Store.getStoreList().size(); i++)
            {
                if (Store.getStoreList().get(i).getId() == product.getStoreId())
                {
                    count = 1;
                    shoppingCart.remove(product);
                    Store.getStoreList().get(i).addProduct(product);
                    wallet += product.getPrice();
                    Store.getStoreList().get(i).setIncome(Store.getStoreList().get(i).getIncome() - product.getPrice());
                    purchaseId[product.getId()] = 0;
                    return true;
                }
            }
        }
        return false;
    }

}
