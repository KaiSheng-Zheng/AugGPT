import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;
        cnt+=1;
        this.id=cnt;
        this.productList=new ArrayList<Product>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList=new ArrayList<Product>();
        for(int i=0;i<productList.size();i++){
            this.productList.add(productList.get(i));
        }
        this.income = income;
        cnt+=1;
        this.id=cnt;
    }

    public boolean hasProduct(Product product){
        if(productList.contains(product)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }
        else {
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

    public void transact(Product product, int method){
        if(method==0){
            removeProduct(product);
            income+=product.getPrice();
        }
    }
}