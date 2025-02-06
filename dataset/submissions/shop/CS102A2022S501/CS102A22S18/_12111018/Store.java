

import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<Product>();
    private float income;
    public Store(String name){
        this.name=name;
        cnt++;
        this.id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList=productList;
        for (int i=0;i< productList.size();i++){
            productList.get(i).setStore(this);
        }
        this.income=income;
        cnt++;
        this.id=cnt;
    }
    public boolean hasProduct(Product product){
        boolean a=this.productList.contains(product);
        return a;
    }
    public boolean addProduct(Product product){
        boolean a=!(productList.contains(product));
        if (a){
            productList.add(product);
            product.setStore(this);
        }
        return a;
    }
    public boolean removeProduct(Product product){
        boolean a=productList.contains(product);
        if (a){
            productList.remove(product);
        }
        return a;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            setIncome(product.getPrice()+this.income);
        }
        if (method==1){
            productList.add(product);
            setIncome(this.income-product.getPrice());
        }
    }

    public float getIncome() {
        return income;
    }
}
