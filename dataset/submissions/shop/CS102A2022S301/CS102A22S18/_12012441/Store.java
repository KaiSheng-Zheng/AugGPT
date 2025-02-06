import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=new ArrayList<>();
        this.income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }

    public boolean hasProduct(Product product){
        int i=0;
        while(i<this.productList.size()){
            if(this.productList.get(i).equals(product)){
                return true;
            }
            i++;
        }
        return false;
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }else{
            this.productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        int i=0;
        while(i<this.productList.size()){
            if(this.productList.get(i).equals(product)){
                this.productList.remove(i);
                return true;
            }else{
                i++;
            }
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        if(method==0 && removeProduct(product)){
            this.income+=product.getPrice();
        }
        if(method==1 && addProduct(product)){
            this.income-=product.getPrice();
        }
    }
}
