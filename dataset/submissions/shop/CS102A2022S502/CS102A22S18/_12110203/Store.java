import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList= new ArrayList<>();
    private float income;
    public Store(String name){
        cnt++;
        id=cnt;
        this.name=name;
        income = 0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.name=name;
        this.income=income;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        return !hasProduct(product)&&productList.add(product);
    }
    public boolean removeProduct(Product product){
        return productList.remove(product);
    }
    private ArrayList<Product> listofSales = new ArrayList<>();
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0&&removeProduct(product)){
            listofSales.add(product);
            income+=product.getPrice();
        }else
        if(method==1&&listofSales.contains(product)&&addProduct(product)){
            addProduct(product);
            listofSales.remove(product);
            income -= product.getPrice();
        }
    }
}