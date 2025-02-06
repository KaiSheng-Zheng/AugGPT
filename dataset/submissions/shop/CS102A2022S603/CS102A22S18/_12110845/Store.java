import java.util.ArrayList;

public class Store {
    private static int cnt = 0; 
    private int id; 
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        ++cnt;
        this.id = cnt;
        this.name = name;
        this.income=0;

    }

    public Store(String name, ArrayList<Product> productList, float income) {
        ++cnt;
        this.id = cnt;
        this.name = name;
        this.income = income;
       if (productList!=null && productList.size() > 0) {
            for (Product a :
                    productList) {
                this.productList.add(a);
            }
        }
        
    }
    public boolean hasProduct(Product product){
        boolean flag = false;
        for (int i = 0; i < this.productList.size(); i++) {
            if (this.productList.get(i).getId() == product.getId()){
                flag = true;
                break;
            }
        }
        if(flag){
        return true;
        }else{
        return false;
        }
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }else{
            this.productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(!hasProduct(product)){
            return false;
        }else{
            this.productList.remove(product);
            return true;
        }
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        if (method == 0){
            if(this.productList.contains(product)){
                removeProduct(product);
                this.income += product.getPrice();
            }
        }else if (method == 1){
            if(!this.productList.contains(product)){
                addProduct(product);
                this.income -= product.getPrice();
            }
        }
    }
}
