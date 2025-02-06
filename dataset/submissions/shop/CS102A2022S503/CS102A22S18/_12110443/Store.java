import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    private ArrayList<Product> soldList;
    public Store(String name){
        this.name =name;
        Store.cnt++;
        this.id=cnt;
        this.income=0;
        this.soldList = new ArrayList<>();
        this.productList = new ArrayList<>();
    }
    public Store(String name,ArrayList<Product> productList,float income){
        this.name = name;
        Store.cnt++;
        this.id =cnt;
        this.productList = productList;
        this.income =income;
        this.soldList = new ArrayList<>();
    }
    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)) return false;
        this.productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        if(!hasProduct(product)) return false;
        this.productList.remove(product);
        return true;
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product,int method){
        switch (method){
            case 0:
                if(removeProduct(product)){
                    this.income += product.getPrice();
                    this.soldList.add(product);
                }
                break;
            case 1:
                if(this.soldList.contains(product) && addProduct(product)){
                    this.income -= product.getPrice();
                    this.soldList.remove(product);
                }
        }
    }
}
