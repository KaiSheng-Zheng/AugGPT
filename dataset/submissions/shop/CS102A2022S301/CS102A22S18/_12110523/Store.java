import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<Product>();
    private float income;

    public Store(String name) {
        this.name = name;
        cnt++;
        id=cnt;

    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        for (int i=0;i< productList.size();i++){
            this.productList.add(productList.get(i));
        }
        this.income = income;
        cnt++;
        id=cnt;
    }
    public boolean hasProduct(Product product){
       for (int i=0;i< productList.size();i++){if (product.equals(productList.get(i))){return true;}}
       return false;
    }
    public boolean addProduct(Product product){
      for (int i=0;i< productList.size();i++){ if (product.equals(productList.get(i)))return false;}
      productList.add(product);return true;
    }
    public boolean removeProduct(Product product){
        for (int i=0;i< productList.size();i++){ if (product.equals(productList.get(i))) {
            productList.remove(i);
            return true;}}
        return false;}
    public ArrayList<Product> getProductList(){
        ArrayList<Product> a=new ArrayList<Product>();
        for (int i=0;i<productList.size();i++){
            a.add(productList.get(i));
        }
        return a;


    }
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            income+=product.getPrice();
        }
        else {productList.add(product);
            income-=product.getPrice();

        }
    }
}
