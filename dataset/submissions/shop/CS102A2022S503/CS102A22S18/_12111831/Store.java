import java.util.ArrayList;

public class Store {
    private static int cnt = 0;//initial: 0; one construct one increase
    private int id;//unique for each store
    private String name;
    private ArrayList<Product> productList;
    private float income;


    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.income = 0;
        this.productList = new ArrayList<>();

    }


    public Store(String name, ArrayList<Product> product, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.income = income;
        this.productList = product;

        }




    public boolean hasProduct(Product product) {
        if (this.productList.contains(product)) {
            return true;

        } else {
            return false;

        }

    }


    public boolean addProduct(Product product) {//one product can only be one in one particular store
        if (productList.contains(product)) {
            return false;

        } else {
            this.productList.add(product);
            return true;

        }

    }


    public boolean removeProduct(Product product) {
        if (this.productList.contains(product)) {
            this.productList.remove(product);
            return true;

        } else {
            return false;

        }

    }


    public ArrayList<Product> getProductList() {
        return this.productList;

    }


    public void transact(Product product, int method) {
        if (method == 0) {
            this.productList.remove(product);
            this.income += product.getPrice();

        } else if (method == 1) {
            this.productList.add(product);
            this.income -= product.getPrice();

        }
    }

}
