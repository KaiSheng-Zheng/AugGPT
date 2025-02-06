import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name=name;
        cnt++;
        this.id=cnt;
        income = 0;
        productList=new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product) {
        int i = 0;
        for (Product value : productList)
            if (value == product){
                i++;
            }
        return i >= 1;
    }

    public boolean addProduct(Product product) {
        boolean chuxian=true;
        for (Product value : productList) {
            if (value == product) {
                chuxian = false;
                break;
            }
        }
        if (chuxian){
            productList.add(product);
            return true;
        }
        else {
        return false;
        }
    }

    public boolean removeProduct(Product product) {
        boolean bucunzai=false;
        for (Product value : productList) {
            if (value == product) {
                bucunzai = true;
                break;
            }
        }
        if (bucunzai){
            productList.remove(product);
            return true;
        }
        else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method) {
        if (method==0){
            this.productList.remove(product);
            this.income=income+ product.getPrice();
        }else if (method==1){
            this.productList.add(product);
            this.income=income- product.getPrice();
        }
    }
}
