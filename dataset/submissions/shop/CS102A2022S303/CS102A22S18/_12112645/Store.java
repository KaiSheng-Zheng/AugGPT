import java.util.ArrayList;

public class Store {
    //???6
    private static int cnt=0; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    //Constructors
    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.income=income;
        this.name=name;
        for (Product p:productList) {
          this.productList.add(p);
        }
    }
    //Methods
    //???13+14
    public boolean hasProduct(Product product){
       if(!productList.contains(product)){return false;}
       else {return true;}
    }
    //???8+9
    public boolean addProduct(Product product){
       if(productList.contains(product)){return false;}
       else {productList.add(product);return true;}
    }
    //???10+11
    public boolean removeProduct(Product product){
        if (productList.contains(product)){productList.remove(product);return true;}
        else {return false;}
    }
    //???12
    public ArrayList<Product> getProductList(){
        return productList;
    }
    //???15+16
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);income+=product.getPrice();
        }
        if (method==1){
            productList.add(product);income-=product.getPrice();
        }
    }

    public  void  minusIncome(float money){
        this.income-=money;
    }
    public  void  addIncome(float money){this.income+=money;}

    public void setProductList(Product product) {
        productList.add(product);
    }
}
