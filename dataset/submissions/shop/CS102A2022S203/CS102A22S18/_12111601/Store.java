import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;income=0;
        id=++cnt;
    }
    public Store(String name,ArrayList<Product> productList,float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        id=++cnt;
    }
    public boolean hasProduct(Product product){
        for(Product p:productList){
            if(p.equals(product))return true;
        }
        return false;
    }
    public boolean addProduct(Product product){
        if(hasProduct(product))return false;
        productList.add(product);return true;
    }
    public boolean removeProduct(Product product){
        if(!hasProduct(product))return false;
        productList.remove(product);return true;
    }
    public ArrayList<Product> getProductList(){
     return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            income+=product.getPrice();
            productList.remove(product);
        }
        else {
            income-=product.getPrice();
            productList.add(product);
        }
    }
}
