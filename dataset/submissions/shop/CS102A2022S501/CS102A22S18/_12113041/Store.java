import java.util.ArrayList;
import java.util.Objects;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        cnt++;
        id=cnt;
        this.name=name;
        income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.name=name;
        this.income=income;
        this.productList=productList;
    }

    public boolean hasProduct(Product product){
        boolean b=false;
        if(product!=null) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId() == product.getId()) {
                    b = true;
                    break;
                }
            }
        }
            return b;
    }

    public boolean addProduct(Product product){
        boolean b=true;
        if (hasProduct(product)) {
            this.productList=productList;
            b = false;
        }
        else {
            productList.add(product);
            b=true;
        }
        return b;
    }

    public boolean removeProduct(Product product){
        boolean b=false;
        if (hasProduct(product)) {
            productList.remove(product);
            b = true;
        }
        else {
            this.productList=productList;
            b=false;
        }
        return b;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            productList.remove(product);
            income+=product.getPrice();
        }
        else if(method==1){
            productList.add(product);
            income-=product.getPrice();
        }

    }
}
