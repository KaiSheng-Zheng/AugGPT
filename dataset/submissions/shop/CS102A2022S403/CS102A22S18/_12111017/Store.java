import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name = name;
        this.income = 0;
        this.productList = new ArrayList<>();
        cnt++;
        id = cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        for (int i = 0; i < productList.size(); i++) {
            this.productList.get(i).setStore(this);
        }
        this.income = income;
        cnt++;
        id = cnt;
    }
    public boolean hasProduct(Product product){
        if (productList.contains(product)) return true;
        else return false;
    }
    public boolean addProduct(Product product){
        if (!productList.contains(product)) {
            productList.add(product);
            product.setStore(this);
            return true;
        }
        else return false;
    }
    public boolean removeProduct(Product product){
        if (productList.contains(product)) {
            productList.remove(product);
            return true;
        }
        else return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0) {
            productList.remove(product);
            this.income += product.getPrice();
        }
        if (method==1) {
            productList.add(product);
            this.income -= product.getPrice();
        }
    }
}
