import java.util.*;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        cnt++;
        this.income = 0;
        this.id = cnt;
        this.name = name;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.income = income;
        this.productList = productList;
    }

    public boolean hasProduct(Product product) {
        if(this.productList.contains(product)) {
            return true;
        }
        else
            return false;
    }

    public boolean addProduct(Product product) {
        if(!hasProduct(product) && this.productList.add(product)) {
           return true;
       }
       else 
       return false;
    }

    public boolean removeProduct(Product product) {
        if(this.productList.remove(product)){
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            if (removeProduct(product)) {
                this.income += product.getPrice();

            }
        }
        if (method == 1) {
            if (addProduct(product)) {
                this.income -= product.getPrice();

            }
        }
    }
}
