import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;
        cnt=cnt+1;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt=cnt+1;
        id=cnt;
    }
    public boolean hasProduct(Product product){
        return productList.contains(product);
    }

    public boolean addProduct(Product product){
        if (!hasProduct(product)){
            productList.add(product);
            return true;}
        else return false;
    }

    public boolean removeProduct(Product product){
            if(hasProduct(product)){
                productList.remove(product);
                return true;}
        else return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            income=income+product.getPrice();}
        if (method==1){
            addProduct(product);
            income=income-product.getPrice();}
    }
}