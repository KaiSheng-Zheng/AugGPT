import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;
        income = 0;
        cnt++;this.id=cnt;
        this.productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.income = income;
        this.productList = productList;cnt++;this.id=cnt;
    }


    public boolean hasProduct(Product product) {
        boolean bool = false;
            if (productList.contains(product)) {
                bool = true;
            }
        return bool;
    }

    public boolean addProduct(Product product) {
        boolean bool = true;
            if (productList.contains(product)) {
                bool = false;
            }
        if (bool) {
            productList.add(product);
        }
        return bool;
    }

    public boolean removeProduct(Product product) {
        boolean bool = false;
            if (productList.contains(product)) {
                productList.remove(product);
                bool = true;
        }
        return bool;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
       if(method==0){
           removeProduct(product);
           income = income+product.getPrice();
       }else if(method==1){
           addProduct(product);
           income = income-product.getPrice();
       }
    }
}