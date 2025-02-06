import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        id = cnt;
        this.name = name;
        income = 0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }
    public boolean hasProduct(Product product){
        boolean has = false;
        for (int i = 0 ; i < productList.size() ; i++) {
            if(productList.get(i)==product){
                has=true;
            }
        }
        return has;
    }
    public boolean addProduct(Product product){
        boolean has = false;
        for (int i = 0 ; i < productList.size() ; i++) {
            if(productList.get(i)==product){
                has=true;
            }
        }
        if(has){
            return false;
        }
        else {
            productList.add(product);
            return true;
        }//haven't judge if product appear in other store's list
    }

    public boolean removeProduct(Product product){
        for (int i = 0 ; i < productList.size() ; i++) {
            if(productList.get(i)==product){
                productList.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method == 0){
            for (int i = 0 ; i < productList.size() ; i++) {
                if(productList.get(i)==product){
                    productList.remove(i);
                }
            }
            income+=product.getPrice();
        }
        else if(method == 1){
            productList.add(product);
            income-=product.getPrice();
        }
    }
}