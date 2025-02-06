import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    public static ArrayList<Product> allproductList;
    private float income;
    public Store(String name){
        this.income=0;
        this.name=name;
        cnt++;
        id=cnt;
        productList=new ArrayList<>();
        allproductList=new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.productList=productList;
        this.income=income;
        this.name=name;
        cnt++;
        id=cnt;
        for(int i=0;i<productList.size();i++){
        allproductList.add(productList.get(i));}
    }
    public boolean hasProduct(Product product){
        int t=0;
        for(int i=0;i<productList.size();i++){
            if(product.getID()==productList.get(i).getID()) {
                t++;
            }
        }
        if(t>0){
            return true;
        }else return false;
    }
    public boolean addProduct(Product product){
        return !hasProduct(product)?productList.add(product) :false;
    }
    public boolean removeProduct(Product product){
        return hasProduct(product)?productList.remove(product) :false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            if(removeProduct(product)){
            income+=product.getPrice();}
        }
        if(method==1){
            if(addProduct(product)){
            income-=product.getPrice();}
        }
    }


}