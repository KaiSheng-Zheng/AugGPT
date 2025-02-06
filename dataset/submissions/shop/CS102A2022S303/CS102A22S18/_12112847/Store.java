import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        this.name=name;cnt++;this.id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        this.name=name;
        this.productList =productList;
        this.income=income;
        cnt++;
        this.id=cnt;
    }

    public boolean hasProduct(Product product){
        if((!productList.isEmpty())&&productList.contains(product)){return true;}else{return false;}}
    public boolean addProduct(Product product){
        if((!productList.isEmpty())){
            if(productList.contains(product)){
                return false;
            }else{
                productList.add(product);
                return true;
            }
        }else{
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if((!productList.isEmpty())&&productList.contains(product)){
            productList.remove(product);return true;}
        else{return false;}
    }
    public ArrayList<Product> getProductList(){
        return productList;}
    public void transact(Product product, int method){
        if(method == 0){
            removeProduct(product);
            income+=product.getPrice();
        }else if(method==1){
            addProduct(product);
            income-=product.getPrice();
        }
    }

    public int getId() {
        return id;
    }
}

