import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private ArrayList<Product> productTrash=new ArrayList<>();
    private float income;
    public Store(String name){this.name=name;this.income=0;Store.cnt++;id=Store.cnt;}
    public Store(String name,ArrayList<Product> productList,float income){
        this.name=name;this.productList=productList;this.income=income;Store.cnt++;id=Store.cnt;
    }
    public boolean hasProduct(Product product){
        boolean t=false;
        for (Product p:productList){
            if(p.equals(product)){t=true;break;}}
        return t;
    }
    public boolean hasProduct2(Product product){
        boolean t=false;
        for (Product p:productTrash){
            if(p.equals(product)){t=true;break;}}
        return t;
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)){return false;}
        else productList.add(product);return true;
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){productList.remove(product);return true;}
        else return false;
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product,int method) {
        if (method==0) {if (hasProduct(product)) {productTrash.add(product);
                productList.remove(product);income+=product.getPrice();}}
            if (method==1){if (productTrash.contains(product)&&addProduct(product)){
                productTrash.remove(product);income-=product.getPrice();}}
        }
    }