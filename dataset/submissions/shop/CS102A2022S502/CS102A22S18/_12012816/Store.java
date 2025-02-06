import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name=name;

        income=0;
        productList=new ArrayList<>();
        cnt++;this.id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;

        this.income=income;
        this.productList=productList;//may cause some problem;
        for (int i = 0; i < this.productList.size(); i++) {
            this.productList.get(i).setSource(this);
        }
        cnt++;this.id=cnt;
    }

    public boolean hasProduct(Product product){
        for (int i = 0; i < this.productList.size(); i++) {
            if (this.productList.get(i).getId()==product.getId())
                return true;
        }
        return false;
    }
    public boolean addProduct(Product product){
        if (hasProduct(product))
            return false;
        else {
            this.productList.add(product);
            product.setSource(this);
            return true;
        }

    }
    public boolean removeProduct(Product product){
        int index=-1;
        if (this.hasProduct(product)){
            for (int i = 0; i < this.productList.size(); i++) {
                if (this.productList.get(i).getId()==product.getId()){
                    index=i;
                    break;
                }
            }
            this.productList.remove(index);
            return true;
        }
        else return false;
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
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
