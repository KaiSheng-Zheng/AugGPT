import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;


    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.income=0;
    }
    public Store(String name,ArrayList<Product> productlist, float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=productlist;
        this.income=income;
    }

    public boolean hasProduct(Product product){         //
        return productList.contains(product);
    }

    public boolean addProduct(Product product){
        if(!hasProduct(product)){
            productList.add(product);
            return true;
        }
        else{
            return false;
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
        return this.productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            removeProduct(product);
            income+=product.getPrice();
        }
        if(method==1){
            productList.add(product);
            income-=product.getPrice();
        }
    }
    public int getID(){
        return this.id;
    }
}
