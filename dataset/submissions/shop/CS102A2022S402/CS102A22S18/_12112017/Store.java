import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(String name) {
        this.name = name;
        this.income = 0;
        cnt++;
        this.id = cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;
    }
    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        for (int i=0;i< productList.size();i++){
            if (product.getId()==productList.get(i).getId())
                return false;
        }
        if (productList.contains(product))
            return false;
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        if (productList.contains(product)){
            productList.remove(product);
            return true;
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            income += product.getPrice();
        }
        if (method==1){
            addProduct(product);
            income -= product.getPrice();
        }
    }
}
