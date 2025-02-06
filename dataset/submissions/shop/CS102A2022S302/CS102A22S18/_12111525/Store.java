import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        this.name = name;
        this.income = 0.0F;
        cnt++;
        this.id = cnt;
        this.productList = new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public boolean hasProduct(Product product){
        int a = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (product.equals(productList.get(i))){
                a++;
            }
        }
            if (a == 1){
                return true;
            }
            else {
                return false;
            }
    }
    public boolean addProduct(Product product){
        int a = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (product.equals(productList.get(i))){
                a++;
            }
        }
        if (a == 1){
            return false;
        }
        else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        int a = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (product.equals(productList.get(i))){
                productList.remove(i);
                a++;
            }
        }
        if (a == 1){
            return true;
        }
        else {
            return false;
        }
    }
    public void transact(Product product, int method){
        if (method == 0 ){
            for (int i = 0; i < productList.size(); i++) {
                if (product.equals(productList.get(i))){
                    productList.remove(i);
                }
            }
            income += product.getPrice();
        }
        if (method == 1){
            productList.add(product);
            income -= product.getPrice();
        }
    }
}


