import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    public static ArrayList<Store> storeList=new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=new ArrayList<>();
        this.income=0;
        storeList.add(this);
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
        storeList.add(this);
    }

    public boolean hasProduct(Product product){
        int counter=0;
        while (counter<this.productList.size()){
            if (product.getID()==this.productList.get(counter).getID()) return true;
            counter++;
        }
        return false;
    }
    public boolean addProduct(Product product){
        if (!this.productList.contains(product)){
            this.productList.add(product);
            product.setStoreID(this.id);
            return true;
        }
        return false;
    }
    public boolean removeProduct(Product product){
        if (this.productList.contains(product)){
            this.productList.remove(product);
            return true;
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            float temp=this.income;
            this.income=temp+product.getPrice();
            this.productList.remove(product);
        } else if (method==1){
            float temp=this.income;
            this.income=temp-product.getPrice();
            this.productList.add(product);
        }
    }
}