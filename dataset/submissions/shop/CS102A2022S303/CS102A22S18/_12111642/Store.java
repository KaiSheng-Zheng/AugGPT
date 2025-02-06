import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public static ArrayList<Store> storeList = new ArrayList<>();


    public Store(String name){
        cnt++;
        this.id= cnt;
        income = 0;
        this.name = name;
        this.productList = new ArrayList<>();
        storeList.add(this);
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = new ArrayList<>(productList);
        this.income = income;
        cnt++;
        this.id= cnt;
        storeList.add(this);
    }

    public boolean hasProduct(Product product){//true and false
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId() == productList.get(i).getId())
                return true;
        }
        return false;
    }

    public boolean addProduct(Product product){
        if(hasProduct(product))
            return false;
        else {
            this.productList.add(product);
            //this.income = this.income - product.getPrice();
            return true;}
    }

    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            //this.income = this.income + product.getPrice();
            return true;}
        return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if( method == 0){
            //removeProduct(product);
            if( removeProduct(product) )
            this.income = this.income + product.getPrice();
        }
        if( method == 1){
            //addProduct(product);
            if( addProduct(product) )
                this.income = this.income - product.getPrice();
        }
    }

    public int getId() {
        return id;
    }
}
