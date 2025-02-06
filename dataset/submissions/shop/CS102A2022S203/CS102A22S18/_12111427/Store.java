import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name=name;
        this.income=0;
        this.productList=null;
        cnt++;
        id = cnt;
        this.productList = new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.income = income;
        this.productList = productList;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product){
        return productList.contains(product);
    }

    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        switch (method){
            case 0:
                removeProduct(product);
                income+= product.getPrice();
                break;
            case 1:
                addProduct(product);
                income-= product.getPrice();
                break;
        }

    }
}
