import java.util.ArrayList;

public class Store {
    private static int cnt; 
    private int id;  
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name = name;
        cnt++;
        this.id = cnt;
        this.income = 0;
        productList = new ArrayList<>();

    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;
        for(int i = 0; i < productList.size(); i++ ){
            productList.get(i).setLocation(i);
        }
    }

    
    public boolean addProduct(Product product){
        if(productList.contains(product)){
            return false;
        }
        else{
            productList.add(product);
            return true;
        }
    }
    public boolean hasProduct(Product product){
        if(productList.contains(product))return true;
        else return false;
    }
    
    public boolean removeProduct(Product product){
        if(productList.contains(product)){
            this.productList.remove(product);
            return true;
        }
        else return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
    
    public void transact(Product product, int method){
        if(method == 0){
            this.productList.remove(product);
            income += product.getPrice();
        }
        else{
            this.productList.add(product);
            income -= product.getPrice();

        }
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Store.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
