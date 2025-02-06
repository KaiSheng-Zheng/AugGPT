import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        this.name=name;
        id=cnt;
    }
    public Store(String name,ArrayList<Product> productList, float income){
        cnt++;
        this.name=name;
        id=cnt;
        this.productList=productList;
        this.income=income;
    }
    public boolean hasProduct(Product product){
        for(int i=0;i<this.productList.size();i++){
            if (this.productList.get(i)==product){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }
        else{
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }
        else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product,int method){
        if(method == 0){
            removeProduct(product);
            income += product.getPrice();
        }
        if(method==1){
            addProduct(product);
            income-=product.getPrice();
        }
    }
}
