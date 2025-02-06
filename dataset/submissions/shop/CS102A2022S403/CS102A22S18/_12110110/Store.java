import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=new ArrayList<>();
        this.income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }

    public boolean hasProduct(Product product){
        for (Product x:productList){
            if (x.getName().equals(product.getName())){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        for (Product x:productList){
            if (x.getId()==product.getId()){
                return false;
            }
        }
        this.productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        for (Product x:productList){
            if (x.getId()==product.getId()){
                productList.remove(x);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            income+=product.getPrice();
        }
        if (method==1){
            productList.add(product);
            income-=product.getPrice();
        }
    }

























}
