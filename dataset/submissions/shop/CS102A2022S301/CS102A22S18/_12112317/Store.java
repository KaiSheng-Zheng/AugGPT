import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        cnt++;
        id = cnt;
        income = 0;
        productList = new ArrayList<>();
        this.name = name;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public int getId(){
        return id;
    }

    public boolean hasProduct(Product product){
        for (int i = 0; i <=productList.size()-1 ; i++) {
            if(productList.get(i).getId()== product.getId()){
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }else{
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            for (int i = 0; i <=productList.size()-1 ; i++) {
                if(productList.get(i).getId()==product.getId()){
                    productList.remove(i);
                    return true;
                }
            }
        }else{
            return false;
        }
        return true;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            income+=product.getPrice();
            removeProduct(product);
        }
        if(method==1){
            income-=product.getPrice();
            addProduct(product);
        }
    }
}
