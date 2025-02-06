import java.util.ArrayList;
public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(String name){
        this.name = name;
        cnt += 1;
        this.id = cnt;
    }
    public Store(String name,ArrayList<Product> productList,float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt += 1;
        this.id = cnt;
    }
    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        int num = 0;
        for (Product value : productList) {
            if (product.getID() == value.getID()) {
                num++;
            }
        }
        if (num != 0){
            return false;
        }
        else
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        if(productList.contains(product)){
            productList.remove(product);
            return true;
        }
        else return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method == 0){
            productList.remove(product);
            this.income += product.getPrice();
        }
        if(method== 1){
            productList.add(product);
            income -= product.getPrice();
        }
    }
    public float getIncome(){
        return income;
    }
    public void setIncome(float income){
        this.income = income;
    }
}
