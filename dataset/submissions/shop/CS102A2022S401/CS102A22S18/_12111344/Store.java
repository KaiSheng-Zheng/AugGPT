import java.util.ArrayList;
public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        this.name = name;
        cnt+=1;
        id=cnt;
        income=0;
        productList=new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList,float income){
        cnt+=1;
        id=cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }
    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        if(productList.contains(product)){return false;}
        else{return productList.add(product);}
    }
    public boolean removeProduct(Product product){
       if(productList.contains(product)){
           return productList.remove(product);
       }else{
           return false;
       }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public float getIncome(){return income;}
    public void transact(Product product, int method) {
        if (method == 0) {
            removeProduct(product);
            income =income+product.getPrice();

        }
        if (method == 1) {
            addProduct(product);
           income=income-product.getPrice();
        }
    }
}
