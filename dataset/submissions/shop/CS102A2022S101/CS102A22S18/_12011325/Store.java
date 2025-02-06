import java.util.ArrayList;
import java.util.Objects;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<Product>();
    private float income;
    public Store(String name){
        this.name = name;
        this.income = 0;
        cnt=cnt+1;
        id =cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt =cnt+1;
        id =cnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return id == store.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        if (this.hasProduct(product)){
            return false;
        }else{
            product.setStore(this);
        productList.add(product);
        return true;
        }
    }
    public boolean removeProduct(Product product){
        if (productList.contains(product)){
            productList.remove(product);
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            income = income + product.getPrice();
            productList.remove(product);
        }
        else if(method ==1){
            income = income - product.getPrice();
            productList.add(product);
        }
    }

    public void addIncome(float f){
        this.income += f;
    }
}
