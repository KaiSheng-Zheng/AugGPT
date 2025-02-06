import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    /*There are two constructors of the Store class. One for constructing a new store, with income = 0 and
      nothing in the productList. The other constructs an existing store with given income and productList.

          The id of the first store is 1. The given income and productList are always valid.
     */
    public Store(String name) {
        cnt++ ;
        this.id = cnt;
        this.name = new String(name);
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = new String(name);
        this.productList = new ArrayList<>(productList);
        this.income = income;
    }


    /*A method to determine whether this store has the given product . Return true if the product is in the
    productList of the store; otherwise, return false
     */
    public boolean hasProduct(Product product) {
        boolean b = this.productList.contains(product);
        return b;
    }


    /*Add product to the productList; return a boolean indicating whether the operation succeeds.

        Suppose each product, which is uniquely identified by its id, could only appear once in the
        productList of a particular store. That is, the same product will not appear in the productList of
        multiple stores (this kind of invalid case will not happen); and in the same productList, a product
        appears not more than once.

        If a product already exists in productList, return false and productList remains the same;
        otherwise, add product to productList and return true.
     */
    public boolean addProduct(Product product) {
        if (this.hasProduct(product)) {
            return false;
        } else {
            this.productList.add(product);
            return true;
        }
    }


    /*Remove product from productList; return a boolean indicating whether the operation succeeds.

        If product exists in productList, remove it from productList and return true; otherwise, return
    false and productList remains the same.
     */
    public boolean removeProduct(Product product) {
        if (this.hasProduct(product)) {
            this.productList.remove(product);
            return true;
        } else {
            return false;
        }
    }


    /*Return productList.
     */
    public ArrayList<Product> getProductList() {
        return this.productList;
    }


    /*This is an interface method for stores to handle customers' purchases or refunds. Suppose that all the
    arguments are valid here.

        method = 0 means purchasing the product from this store. The product should be removed from the
    productList and the income of this store should increase by an amount equal to the price of the
    product.

        (Bonus) method = 1 means refunding the product to the store. The productList and income of the
    store should also be updated accordingly (suppose that the store adds this product back to its
    productList and could re-sell this product)
     */
    public void transact(Product product, int method) {
        if (method == 0) {
            this.income = this.income + product.getPrice();
            this.removeProduct(product);
        }
        if (method == 1) {
            this.income = this.income - product.getPrice();
            this.addProduct(product);
        }
    }

}
