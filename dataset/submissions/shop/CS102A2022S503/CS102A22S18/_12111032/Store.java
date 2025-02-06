import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        this.name = name;
        cnt++;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.income = income;
        this.productList = productList;
        cnt++;
        this.id = cnt;
        for (int i = 0; i < productList.size(); i++) {
            this.productList.get(i).setStore(this) ;
        }

    }

    public void setId(int id) {
        this.id = cnt;
    }

    public boolean hasProduct(Product product) {
        int counter=0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) == product) {
                counter++;
            }
        }
        if(counter!=0){return true;}else{return false;}
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        } else {
            productList.add(product);
            product.setStore(this) ;
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        int counter=0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) == product) {
                productList.remove(productList.get(i));
                counter++;
            }
        }
        if(counter!=0){return true;}else{return false;}
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        //this.product=
        if(method==0){
            productList.remove(product);
            income+=product.getPrice();
        }
        if(method==1){
            productList.add(product);
            income-=product.getPrice();
        }
    }
}