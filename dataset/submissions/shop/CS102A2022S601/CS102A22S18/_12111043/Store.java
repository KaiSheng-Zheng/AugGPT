import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private final int id;
    private final String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        this.productList=new ArrayList<>();
        income=0;
        this.name=name;
        cnt++;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.income=income;
        this.productList=productList;
        cnt++;
        id=cnt;
    }
    public boolean hasProduct(Product product) {
        int t = 0;
        if (productList.size()!=0) {
            if (productList.contains(product)) {
                t = 1;
            }

            return t == 1;
        }else {
            return false;
        }
    }

    public boolean addProduct(Product product){
        if (!hasProduct(product)) {
            productList.add(product);
            return true;
        }else {
            return false;
        }
    }
    public boolean removeProduct(Product product){
        int n=getProductList().size();
        for(int i=0;i<getProductList().size();i++){
            if(getProductList().get(i).getId()==product.getId()){
                n=i;
                break;
            }
        }
        if(n<getProductList().size()){
            getProductList().remove(n);
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            income+=product.getPrice();
        }else{
            addProduct(product);
            income-=product.getPrice();
        }

    }

    public int getId() {
        return id;
    }
}
