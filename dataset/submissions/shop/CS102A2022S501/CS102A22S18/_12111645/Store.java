import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        this.name=name;
        income=0;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name=name;
        this.income=income;
        this.productList=productList;
        id=cnt;
    }

    public boolean hasProduct(Product product){
        boolean judge=false;
        int a =0;
        for(int i =0;i<productList.size();i++){
            if(product==productList.get(i)){
                judge=true;
                break;
            }
        }

        return judge;
    }

    public boolean addProduct(Product product){
        boolean judge = true;
        for(int i =0;i<productList.size();i++){
            if(product==productList.get(i)){
                judge=false;
                break;
            }
        }
        if(judge){
            productList.add(product);
        }

        return judge;
    }

    public boolean removeProduct(Product product){
        boolean judge=false;
        for(int i =0;i<productList.size();i++){
            if(product==productList.get(i)){
                judge=true;
                productList.remove(i);
            }
        }
        return judge;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            income=income+product.getPrice();
            productList.remove(product);
        }
        if(method==1){
            this.addProduct(product);
            income=income-product.getPrice();
        }
    }
}
