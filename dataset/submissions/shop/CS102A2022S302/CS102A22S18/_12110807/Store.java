import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList =new ArrayList<>();
    private float income;


    public Store(String name){
        cnt++;
        this.name = name;
        this.income = 0;
        id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name = name;
        id = cnt;
        this.productList = productList;
        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).setFrom(this);
        }
        this.income = income;
    }

    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }

    public boolean addProduct(Product product){
        if (this.hasProduct(product)){
            return false;
        } else {
            this.productList.add(product);
            product.setFrom(this);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if (this.hasProduct(product)){
            productList.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getProductList(){
        return  this.productList;
    }

    public void transact(Product product, int method){
        if (method == 0){
            this.removeProduct(product);
            income += product.getPrice();
        } else if (method == 1){
            this.addProduct(product);
            income -= product.getPrice();
        }
    }

}
