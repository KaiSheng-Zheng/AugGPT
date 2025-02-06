import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name) {
        cnt++;
        id=cnt;
        this.name=name;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        id=cnt;
        this.name=name;
        this.income=income;
        this.productList=productList;
    }

    public boolean hasProduct(Product product) {
        boolean result=false;
        for (Product product0 : productList) {
            if (product == product0) {
                result= true;
            }
        }
        return result;
    }

    public boolean addProduct(Product product){
        boolean result=true;
        if (hasProduct(product)){
            result=false;
        }
        else {
            productList.add(product);
        }
        return result;
    }

    public boolean removeProduct(Product product){
        boolean result=false;
        if (hasProduct(product)){
            result=true;
            productList.remove(product);
        }
        return result;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            removeProduct(product);
            this.income+=product.getPrice();
        }
        if(method==1){
            addProduct(product);
            this.income-=product.getPrice();
        }
    }

    public void setIncome(float income) {
        this.income+= income;
    }
}
