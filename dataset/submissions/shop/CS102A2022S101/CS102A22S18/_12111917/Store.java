import java.util.ArrayList;

interface IA{
    void transact(Product product, int method) ;
}

public class Store implements IA{
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the     constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        this.id = ++cnt;
        this.name = name;
        this.income = 0;
    }


    public Store(String name, ArrayList<Product> productList, float income) {
        this.id = ++cnt;
        this.name = name;
        this.productList.addAll(productList);
        this.income = income;
    }


    public boolean hasProduct(Product product) {
        for (Product p : productList) {
            if (p.getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (!hasProduct(product)) {
            this.productList.add(product);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            income += product.getPrice();
            removeProduct(product);
        }else{
            income -= product.getPrice();
            addProduct(product);
        }
    }
}
