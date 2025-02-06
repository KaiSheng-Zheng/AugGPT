import java.util.ArrayList;
public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;

    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList.addAll(productList);
        this.income=income;
    }

    public boolean hasProduct(Product product){
        int a=0;
        for(int i=0;i<this.productList.size();i++){
            if(this.productList.get(i).getId()==product.getId()){
                a++;
                break;
            }
        }
        if(a==0){
            return false;
        }else {
            return true;
        }
    }

    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }else {
            this.productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            this.productList.remove(product);
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            removeProduct(product);
            this.income=this.income+product.getPrice();
        }
        if(method==1){
            addProduct(product);
            this.income=this.income-product.getPrice();
        }
    }

}