import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private final int id; // unique for each store and the value is set to cnt.
    private final String name;
    private ArrayList<Product> productList;
    private float income;


    public Store(String name) {
        this.name = name;
        this.productList = new ArrayList<>();
        this.income = 0;
        cnt ++;
        this.id = cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt ++;
        this.id = cnt;
    }


    public int Id() { return this.id;}

    public boolean hasProduct(Product product) {
        return productList.contains(product);
    }

    public boolean addProduct(Product product) {
        for(Product product_i : productList) {
            if (product_i.Id() == product.Id())
                return false;
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        for(Product product_i : productList) {
            if (product_i.Id() == product.Id()) {
                productList.remove(product_i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList() { return this.productList;}


    public void transact(Product product, int method) {
        if (method == 0) {                                      // There is no need to check whether the required product exists.
            removeProduct(product);
            this.income += product.Price();
        }
        else if (method == 1) {
            this.income -= product.Price();
            addProduct(product);
        }
    }

}
