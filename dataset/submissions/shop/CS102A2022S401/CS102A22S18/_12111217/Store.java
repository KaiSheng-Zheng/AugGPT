import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;
        cnt++;
        id=cnt;
    }
    public Store(String name,ArrayList<Product> productList,float income){
        this.name=name;
        this.productList.addAll(productList);
        this.income=income;
        cnt++;
        id=cnt;
    }
    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        boolean t=true;
        for (Product value : productList) {
            if (product.getId() == value.getId()) {
                t = false;
                break;
            }
        }
        if (t){
            productList.add(product);
        }
        return t;
    }
    public boolean removeProduct(Product product){
        boolean t=false;
        for (int n=0;n<productList.size();n++)
            if (product.getId() == productList.get(n).getId()) {
                t = true;
                productList.remove(product);
                break;
            }
        return t;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product,int method){
        if (method == 0) {
            if (this.removeProduct(product)) {
                this.income = this.income + product.getPrice();
            }
        }
        if (method==1){
            if (this.addProduct(product)) {
                this.income = this.income - product.getPrice();
            }
        }
    }
}
