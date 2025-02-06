import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
public class Store {

    private static AtomicInteger count = new AtomicInteger();

    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList(); ;
    private float income;

    public Store(String name){
        count.set(cnt);
        count.incrementAndGet();
        int i = count.get();
        this.id = i;
        cnt = i;

        this.name = name;
        this.income = 0;
        this.productList = new ArrayList();
    }

    public Store(String name, ArrayList<Product> productList, float income){
        count.set(cnt);
        count.incrementAndGet();
        int i = count.get();
        this.id = i;
        cnt = i;

        this.name = name;
        this.productList = productList;
        this.income = income;

    }

    /**
     * A method to determine whether this store has the given product . Return true if the product is in the
     * productList of the store; otherwise, return false.
     * @param product
     * @return
     */
    public boolean hasProduct(Product product){
        if (productList.contains(product)){
            return true;
        }
        return false;

    }

    /**
     * Add product to the productList; return a boolean indicating whether the operation succeeds.
     * @param product
     * @return
     */
    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }
        productList.add(product);
        return true;

    }

    /**
     *  If product exists in productList, remove it from productList and return true; otherwise, return
     * false and productList remains the same.
     * @param product
     * @return
     */
    public boolean removeProduct(Product product){
        if (!hasProduct(product)){
            return false;
        }
        productList.remove(product);
        return true;
    }


    public ArrayList<Product> getProductList(){
        return productList;
    }

    /**
     * method = 0 means purchasing the product from this store. The product should be removed from the
     * productList and the income of this store should increase by an amount equal to the price of the
     * product.
     * (Bonus) method = 1 means refunding the product to the store. The productList and income of the
     * store should also be updated accordingly (suppose that the store adds this product back to its
     * productList and could re-sell this product).
     * @param product
     * @param method
     */
    public void transact(Product product, int method){
        if (method == 0){
            boolean flag = removeProduct(product);
            if (flag){
                income += product.getPrice();
            }

        }else {
            boolean flag = addProduct(product);
            if (flag) {
                income -= product.getPrice();
            }
        }
    }


}
