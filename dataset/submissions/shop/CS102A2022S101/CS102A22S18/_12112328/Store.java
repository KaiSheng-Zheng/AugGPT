import java.util.ArrayList;
public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        cnt++;
        id=cnt;
          this.income=0;
          this.name=name;
    }
    public Store(String name, ArrayList<Product> productList, float income){
          cnt++;
          id=cnt;
          this.income=income;
          this.name=name;
          this.productList=productList;
    }
    public boolean hasProduct(Product product){
          for (Product a:getProductList()){
              if (a.getId()==product.getId()){
                  return true;
              }
          }
          return false;
    }

    public String getName() {
        return name;
    }

    public boolean addProduct(Product product){
        for (Product a:getProductList()){
            if (a.getId()==product.getId()){
                return false;
            }
        }
       // product.setStore(this);
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        for (Product a:getProductList()){
            if (a.getId()==product.getId()){
                productList.remove(product);
              //  product.setStore(new Store("@"));
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
                  if (removeProduct(product)) this.income+=product.getPrice();

              }
              if (method==1){
                  if (addProduct(product)) this.income-=product.getPrice();

              }
    }
}
