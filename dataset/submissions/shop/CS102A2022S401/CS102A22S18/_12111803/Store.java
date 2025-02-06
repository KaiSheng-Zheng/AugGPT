import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;
        cnt=cnt+1;
        this.id = cnt;
    }
    public Store(String name,ArrayList<Product> productList,float income){
        cnt=cnt+1;
        this.id = cnt;
        this.name=name;
        this.productList =productList;
        this.income=income;
    }
    public boolean hasProduct(Product product){
        for(int i = 0; i< productList.size(); i++){
            if(product== productList.get(i)){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;

        }else{
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
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
        if(method==0){
            income=income+ product.getPrice();
            removeProduct(product);
        }
        if(method==1){
            income=income- product.getPrice();
            addProduct(product);

        }
    }
}
