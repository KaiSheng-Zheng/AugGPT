import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;


    private float income;


    public Store(String name) {
        productList=new ArrayList<>();
        cnt++;
        this.name = name;
        income =0;
        id=cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.name = name;
        this.productList =productList;
        this.income=income;

        id=cnt;
    }
    public boolean hasProduct(Product product){
        if (productList.contains(product) )
            return true;
        else
            return false;
    }

    public boolean addProduct(Product product){//
        if (!hasProduct(product)){
        productList.add(product);
        return true;
        }
        else
            return false;
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
        return true;}
         else
             return  false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
        income +=product.getPrice() ;}
        if (method==1){
            addProduct(product);
            income-=product.getPrice();
        }
    }


}
