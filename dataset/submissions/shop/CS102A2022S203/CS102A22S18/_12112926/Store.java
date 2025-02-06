import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;
        cnt++;
        id = cnt;
        productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product) {
        boolean a = false;
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId()!=productList.get(i).getId()) {
                a = false;
            } else {
                a = true;
                break;
            }
        }
       return a;
    }

    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        } else{
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product,int method){
        if(method==0){
            removeProduct(product);
            income = income+product.getPrice();
        }
    }
}
