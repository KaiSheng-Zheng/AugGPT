import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList= new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;
        cnt=cnt+1;
        id=cnt;
        income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt=cnt+1;
        id=cnt;
    }
    public boolean hasProduct(Product product){
        int a=0;
        for (int i=0;i<productList.size();i++){
            if (productList.get(i)==product){
                a=a+1;
            }
        }
        if (a!=0){
            return true;
        }
        else return false;
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)==true){
            return false;
        }
        else productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)==true){
            productList.remove(product);
            return true;
        }
        else return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            income=income+product.getPrice();
            productList.remove(product);
        }
        if (method==1){
            income=income- product.getPrice();
            productList.add(product);

        }
    }
}
