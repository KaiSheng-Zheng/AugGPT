import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        this.name = name;
        this.income = 0;
        cnt++;
        id = cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        if (productList==null)productList = new ArrayList<>();
        this.name = name;
        this.income = income;
        this.productList = productList;
        cnt++;
        id = cnt;
    }
    public boolean hasProduct(Product product){
        int a=0;
        for (int i=0;i<productList.size();i++){
            if (product.getId()==productList.get(i).getId())
                a++;
        }
        if (a!=0)return true;
        else return false;
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)) return false;
        else {
            productList.add(product);
            return true;
        }

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
        if (method==0){
            removeProduct(product);
            this.income+=product.getPrice();
        }
        if (method==1){
            addProduct(product);
            this.income-=product.getPrice();
        }
    }
}