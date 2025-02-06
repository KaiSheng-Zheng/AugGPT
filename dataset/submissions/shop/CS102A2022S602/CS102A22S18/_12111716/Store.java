import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;


    public Store(String name){
        this.name=name;
        cnt++;
        this.id=cnt;
    }
    public int getId() {
        return id;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        this.id=cnt;
    }
    public boolean hasProduct(Product product){
        for (Product value : productList) {
            if (product.getId() == value.getId()) {
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }else if(product.getS()!=null){
            return false;
        }else {productList.add(product);
        return true;
    }}
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            this.productList.remove(product);
            return true;
        }else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            productList.remove(product);
            this.income+=product.getPrice();

        }
        if(method==1){
            productList.add(product);
            this.income-=product.getPrice();
        }
    }

}

