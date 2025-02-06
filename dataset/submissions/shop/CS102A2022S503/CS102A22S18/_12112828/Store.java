import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        cnt++;
        id=cnt;
        this.name=name;
        income=0;
        productList=new ArrayList<>();
    }
    public Store(String name,ArrayList<Product> productList,float income){
        cnt++;
        id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }
    public boolean hasProduct(Product product){
        for(int i=0;i< productList.size();i++){
            if (product.getId()==productList.get(i).getId()){                               //
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(!hasProduct(product)){
            return false;
        }else{
            productList.remove(product);
            return true;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0&&hasProduct(product)){
            productList.remove(product);
            income=income+product.getPrice();
        }
    }
}
