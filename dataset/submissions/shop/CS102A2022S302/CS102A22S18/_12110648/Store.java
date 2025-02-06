import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;this.income=0;
        cnt++;this.id=cnt;this.productList=new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;this.id=cnt;
    }
    public boolean hasProduct(Product product) {
        int flag = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) == product) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }
    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        } else {
            productList.add(product);
            return true;
        }
    }public boolean removeProduct(Product product){
        if (productList.contains(product)){
            productList.remove(product);return true;
        }else {return false;
    }
}

    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);income=income+product.getPrice();
        }if (method==1){
            productList.add(product);income=income-product.getPrice();
        }
    }
}