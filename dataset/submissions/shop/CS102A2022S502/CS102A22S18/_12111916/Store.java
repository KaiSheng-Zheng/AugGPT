

import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public Store(String name){
        this.name=name; this.income=0;
        cnt++;
        this.id=cnt;
        this.productList=new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.income = income;
        cnt++;
        this.id=cnt;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        int j=0;
        for (Product value : this.productList) {
            if (value.equals(product)) {
                j++;
            }
        }
        return j >= 1;

    }
    public boolean addProduct(Product product) {
        if (!hasProduct(product)) {
            this.productList.add(product);
            return true;
        } else {
            return false;
        }
    }
    public boolean removeProduct(Product product){
        int k=0;
        for(int i =0; i<this.productList.size();i++){
            if(this.productList.get(i).equals(product)){
                this.productList.remove(i);
                k++;
            }
        }
        return k>=1;
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            this.productList.remove(product);
            this.income+=product.getPrice();
        }else if(method==1){
            this.productList.add(product);
            this.income-=product.getPrice();
        }
    }
}
