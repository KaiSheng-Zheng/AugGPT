import java.util.ArrayList;
public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.

    private int id;  // unique for each product and the value is set to cnt.


    public static void setCnt(int cnt) {
        Store.cnt = cnt;
    }
    public int getCnt(){
        return Store.cnt;
    }
    public void setId(int id){
        this.id=cnt+1;
    }
    public int getId(){
        return this.id;
    }


    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }




    private ArrayList<Product> productList=new ArrayList<>();

    private float income;


    public boolean hasProduct(Product product) {
        if (productList.contains(product)){ return true;}
        else return false;
    }


    public boolean addProduct(Product product){
          if (!hasProduct(product)){
              productList.add(product);
              product.setStore(this);
              return true;
          }
          else return false;
          }
    public boolean removeProduct(Product product){
            if (hasProduct(product)){
                productList.remove(product);
                return true;
        }
            else return false;
        }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method == 0){
            productList.remove(product);
            income = income + product.getPrice();
        }
        else if (method ==1){
            productList.add(product);
            income = income - product.getPrice();
        }
    }
    public Store(String name){
        cnt += 1;
        this.id = cnt;
        this.name = name;

    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt += 1;
        this.id = cnt;
        for (Product ABC:productList)ABC.setStore(this);
        this.name = name;
        this.productList = productList;
        this.income =income;
    }
}
