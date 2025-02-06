import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        id = ++cnt;
        this.name = name; this.income = 0; this.productList = null;productList=new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        id = ++cnt;
        this.name = name; this.productList = productList; this.income = income;
    }
    public boolean hasProduct(Product product){
        boolean flag = false;
        for (int i = 0; i<productList.size(); i++){
            if (productList.get(i).getID() == product.getID()){
                flag = true;
                break;
            }
        }
        return flag;
    }
    public boolean addProduct(Product product){
        boolean flag = true;
        for (Product value : productList) {
            if (value.getID() == product.getID()) {
                flag = false;
                break;
            }
        }
        if (flag){
            productList.add(product);
        }
        return flag;
    }
    public boolean removeProduct(Product product) {
        boolean flag = false;
        for (Product value : productList) {
            if (value.getID() == product.getID()) {
                flag = true;
                break;
            }
        }
        if (flag) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getID() == product.getID()) {
                    productList.remove(i);
                    break;
                }
            }
        }
        return flag;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method == 0){
            if (removeProduct(product)){
                income = income+product.getPrice();
            }
        }else {
            if(addProduct(product)){
                income = income-product.getPrice();
            }
        }
    }
}
