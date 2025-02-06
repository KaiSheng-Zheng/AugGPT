import java.util.ArrayList;
public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<Product>();
    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    private float income = 0f;
    public Store(String name){
        cnt++;
        id = cnt;
        this.name = name;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id = cnt;
        this.name = name;
        this.income = income;
        this.productList = productList;
    }
    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public boolean addProduct(Product product) {
        if (productList.contains(product)) {
            return false;
        } else {
            productList.add(product);
            return true;
        }
    }
     public boolean removeProduct (Product product) {
         if (productList.contains(product)) {
             productList.remove(product);
             return true;
         } else {
             return false;
         }
     }
    public ArrayList<Product> getProductList () {
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            income+=product.getprice();
        }else if (method==1){
            productList.add(product);
            income-=product.getprice();
        }
    }
    public int getId() {
        return id;
    }
}


