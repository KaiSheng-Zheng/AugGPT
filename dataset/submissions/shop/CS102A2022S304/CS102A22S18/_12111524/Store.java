import java.util.ArrayList;


public class Store {


    // Attributes
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;


    // Constructors
    public Store(String name) {

        // Alter counter
        cnt += 1;

        // Input
        this.name = name;
        this.id = cnt;
        this.productList = new ArrayList<Product>();
        this.income = 0;

    }

    public Store(String name, ArrayList<Product> productList, float income) {

        // Alter counter
        cnt += 1;

        // Input
        this.name = name;
        this.id = cnt;
        this.productList = productList;
        this.income = income;

    }


    // Methods
    // hasProduct
    public boolean hasProduct(Product product) {

        // Attributes
        boolean hasProduct;

        // Operations
        hasProduct = this.productList.contains(product);

        // Return
        return hasProduct;

    }


    // addProduct
    public boolean addProduct(Product product) {

        // Attributes
        boolean validity;

        // Operations
        if (!hasProduct(product)) {
            productList.add(product);
            validity = true;
        } else {
            validity = false;
        }

        return validity;

    }


    // removeProduct
    public boolean removeProduct(Product product) {

        // Attributes
        boolean validity;

        // Operations
        if (hasProduct(product)) {
            productList.remove(product);
            validity = true;
        } else {
            validity = false;
        }

        // Return
        return validity;

    }


    // getProductList
    public ArrayList<Product> getProductList() {
        return productList;
    }


    //transact: 0 to purchase, 1 to refund
    public void transact(Product product, int method) {

        if (method == 0){
            productList.remove(product);
            income += product.getPrice();
        }

        if (method == 1){
            productList.add(product);
            income -= product.getPrice();
        }

    }


}