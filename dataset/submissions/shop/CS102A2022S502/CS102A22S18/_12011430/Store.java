import java.util.ArrayList;
import java.util.Objects;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;
        this.id+=1;
        cnt=this.id;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }
    public boolean hasProduct(Product product){
        for (int i=0;i<productList.size();i++){
            if (productList.get(i) == product){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        for (int i=0;i<this.productList.size();i++){
            if (Objects.equals(this.productList.get(i).getId(), product.getId())){
                return false;
            }
        }
        this.productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        for (int i=0;i<this.productList.size();i++){
            if (this.productList.get(i).equals(product)){
                this.productList.remove(i);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            this.income+=product.getPrice();
            removeProduct(product);
        }else {
            this.income-=product.getPrice();
            addProduct(product);
        }
    }



}
