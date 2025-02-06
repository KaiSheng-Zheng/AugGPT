
import java.util.ArrayList;
import java.util.Objects;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    private static ArrayList<Store>StoreList=new ArrayList<>();


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return id == store.id && name.equals(store.name);
    }

    private  int getId(){
        return id;
    }


    public Store(String name){
        this.name=name;
        this.income=0;
        cnt++;
        id=cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        for(int i=0;i<productList.size();i++){
            productList.get(i).home=this;
        }
        this.income=income;
        cnt++;
        id=cnt;
        StoreList.add(this);
    }

    public boolean hasProduct(Product product){
        return productList.contains(product);
    }

    public boolean addProduct(Product product){
        if(!hasProduct(product)) {
            product.home = this;
            productList.add(product);
            return true;
        }else {
            return false;
        }
    }

    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            removeProduct(product);
            income=income+product.getPrice();
        } else if (method == 1) {
            income=income-product.getPrice();
           productList.add(product);
        }
    }

    public static Store TuiKuanHelper(Product product){
        for(int i=0;i<StoreList.size();i++){
            if(StoreList.get(i).getId()==product.home.getId()){
                return StoreList.get(i);
            }
        }
        return null;
    }
}
