import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.id = cnt+1;
        this.name = name;
        this.productList = new ArrayList<>();
        this.income =0;
        cnt++;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.id = cnt+1;
        this.name = name;
        this.productList = productList;
        this.income =income;
        cnt++;
    }
    public boolean hasProduct(Product product){
        if(this.productList.contains(product)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean addProduct(Product product){
        for(int i=0;i<productList.size();i++){
            if(product.getId()==this.productList.get(i).getId()){
                return false;
            }
        }
        this.productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        for(int i=0;i<productList.size();i++){
            if(product.getId()==this.productList.get(i).getId()){
                this.productList.remove(product);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method == 0){
            this.productList.remove(product);
            this.income += product.getPrice();
        }
        else if (method == 1){
            this.productList.add(product);
            this.income -= product.getPrice();
        }
    }
}
