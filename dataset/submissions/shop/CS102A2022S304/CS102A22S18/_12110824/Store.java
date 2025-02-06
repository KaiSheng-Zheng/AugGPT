import java.util.ArrayList;

public class Store {
    private int id;
    private static int cnt;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;
        income=0;
        cnt++;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        for (Product product : productList) {
            product.setThestore(this);
        }
        cnt++;
        id=cnt;
    }
    public boolean hasProduct(Product product){
        if (productList.contains(product)){
            return true;
        }else{
            return false;
        }
    }
    public boolean addProduct(Product product){
        if (productList.contains(product)){
            return false;
        }else{
            productList.add(product);
            product.setThestore(this);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (this.hasProduct(product)){
            productList.remove(product);
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            this.removeProduct(product);
            income+=product.getPrice();
        }
        if (method==1){
            this.addProduct(product);
            income-=product.getPrice();
        }
    }

}
