import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        Store.cnt++;
        this.id=cnt;
        this.name=name;
        this.income = 0;
        this.productList = new ArrayList<Product>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        Store.cnt++;
        this.id=cnt;
        this.name = name;
        this.income = income;
        this.productList = new ArrayList<Product>();
        for(int i=0;i<productList.size();i++)
            this.productList.add(productList.get(i));
    }

    public boolean hasProduct(Product product){
        if(this.productList.contains(product))
            return true;
        return false;
    }

    public boolean addProduct(Product product){
        if(hasProduct(product))
            return false;
        this.productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product){
        if(hasProduct(product)==false)
            return false;
        this.productList.remove(this.productList.indexOf(product));
        return true;
    }

    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    public void transact(Product product, int method){
        if(method==0&&removeProduct(product))
            this.income+=product.price;
        if(method==1){
            this.productList.add(product);
            this.income-=product.price;
        }
    }
}
