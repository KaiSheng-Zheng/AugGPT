import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;
        this.id=cnt+1;
        cnt++;
    }
    public Store(String name,ArrayList<Product> productList,float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        this.id=cnt+1;
        cnt++;
    }
    public boolean hasProduct(Product product){
        if (this.productList.contains(product)){return true;}
        else{return false;}
    }
    public boolean addProduct(Product product){
        if (this.hasProduct(product)){
            return false;
        }
        else{
            this.productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (this.hasProduct(product)){
            this.productList.remove(product);
            return true;
        }
        else{return false;}
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product,int method){
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
