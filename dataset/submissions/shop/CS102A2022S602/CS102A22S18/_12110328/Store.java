import java.util.ArrayList;;
public class Store {
    private static int cnt=0;
    private final int id;
    private final String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
        income=0;
        productList=new ArrayList<>();
    }
    public Store( String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id = cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }
    public boolean hasProduct(Product product){
        int le= productList.size();
        for(int i=0;i<le;i++){
            if(productList.get(i)==product){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        boolean re= productList.stream().anyMatch(i-> product.getId() == i.getId());
        if(!re){
            productList.add(product);
            return true;
        }else{
            return false;
        }
    }
    public boolean removeProduct(Product product){
        boolean re= productList.stream().anyMatch(i-> product.getId() == i.getId());
        if(re){
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
            income=income+product.getPrice();
            productList.remove(product);
            return;
        }else if(method==1){
            income=income-product.getPrice();
            productList.add(product);
            return;
        }
    }
    public ArrayList<Product> getproductList(){
        return productList;
    }
}
