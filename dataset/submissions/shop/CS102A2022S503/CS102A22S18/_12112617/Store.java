import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        cnt++;
        id =cnt;
        income = 0;
        ArrayList<Product> productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.income = income;
        this.productList = productList;
    }


    public boolean hasProduct(Product product) {
        if (productList.contains(product)) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList getproductlist(Store a){
        return a.productList ;
    }


    public boolean addProduct(Product product) {
        if (productList.contains(product)){
            return false;
        }else{
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (productList.contains(product)){
            productList.remove(product);
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            productList.remove(product);
            income += product.getprice(product);
        }
    }
}
