
import java.util.ArrayList;

public class Store {
    private float income;
    private static int cnt = 1;
    private int id = cnt++;
    private String name;
    private ArrayList<Product>productList = new ArrayList<>();

    public Store(String name){
        this.name = name;
        income = 0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        for(Product product: productList){
            this.productList.add(product);
        }
        this.income = income;

    }
    public ArrayList<Product> getProductList() {
        return productList;
    }

    public boolean hasProduct(Product product){

        return productList.contains(product);
    }

    public boolean addProduct(Product product){
        if(!hasProduct(product)){
            productList.add(product);
            return true;
        }
        return false;
    }
    public boolean removeProduct(Product product){
        return productList.remove(product);
    }
    public void transact(Product product,int method){
        if(method==0){
            removeProduct(product);
            income += product.getPrice();
        }
        if(method==1){
            addProduct(product);
            income -= product.getPrice();
        }
    }




}
