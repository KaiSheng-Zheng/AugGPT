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
        this.income=0;
        this.productList=new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.income=income;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        int N=0;
        for (int i = 0; i < productList.size(); i++) {
            if (product==productList.get(i)){
                N++;
            }
        }
        if (N==1){
            return true;
        }else {
            return false;
        }
    }
    public boolean addProduct(Product product){
        int N=0;
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId()== productList.get(i).getId()){
                N++;}
            }
            if (N==0){
                productList.add(product);
                return true;
            }else {
                return false;
            }
        }
    public boolean removeProduct(Product product){
        int N=0;
        int sequence=0;
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId() == productList.get(i).getId()) {
                N++;
                sequence = i;
            }
        }
            if (N==0){
                return false;
            }else {
                productList.remove(sequence);
                return true;
            }
        }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            int N=0;
            int S1=0;
            for (int i = 0; i < productList.size(); i++) {
                if (product.getId()== productList.get(i).getId()){
                    N++;
                    S1=i;}}
            removeProduct(product);
            this.income+=product.getPrice();
            }
        if (method==1){
            productList.add(product);
            this.income-=product.getPrice();
        }
    }
}




