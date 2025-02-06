import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        cnt++;this.id=cnt;
        this.name=name;
        this.productList=new ArrayList<>();
        this.income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;this.id=cnt;
        this.name=name;
        this.productList=new ArrayList<>(productList);
        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).setStore(this);
        }
        this.income=income;
    }
    public boolean hasProduct(Product product){
        boolean a=false;
        for (Product value : this.productList) {
            if (value == product) {
                a=true;
                break;
            }
        }return a;
    }
    public boolean addProduct(Product product){
        if(!hasProduct(product)) {
            productList.add(product);
            product.setStore(this);
            return true;
            }else return false;
    }

    public boolean removeProduct(Product product){
        if(this.hasProduct(product)){
            this.productList.remove(product);
            return true;
        }else return false;
    }

    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    public void transact(Product product, int method){
        switch (method){
            case 0:removeProduct(product);income+=product.getPrice();break;
            case 1:addProduct(product);income-=product.getPrice();break;
        }
    }
}
