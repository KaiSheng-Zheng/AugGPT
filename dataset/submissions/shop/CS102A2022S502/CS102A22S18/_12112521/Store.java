import java.util.ArrayList;
public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList =new ArrayList<>();
    private float income;
    public Store(String name){
        this.name = name;
        income=0;
        id = cnt+1;
        cnt++;

    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.income = income;
        for(int i = 0; i< productList.size(); i++){
            this.productList.add(productList.get(i));
        }
        id = cnt+1;
        cnt++;
    }
    public boolean hasProduct(Product product){

        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        if(hasProduct(product) == true){
            return false;
        }else{
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product) {
        if (hasProduct(product) == true) {
            productList.remove(product);
            return true;
        } else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method == 0){
            income += product.getPrice();
            productList.remove(product);
        }else if(method == 1){
            income -= product.getPrice();
            productList.add(product);
        }
    }
}
