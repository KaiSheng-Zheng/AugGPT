

import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
       this.name = name;
       this.income = 0;
       this.productList = new ArrayList<Product>();
       this.cnt = this.cnt + 1;
       this.id = this.cnt;
    }
    public Store(String name,ArrayList<Product> productList,float income){
        this.name = name;
        this.productList = new ArrayList<Product>();
        this.productList = productList;
        this.income = income;
        this.cnt = this.cnt + 1;
        this.id = this.cnt;
    }

    public int getId(){
        return id;
    }
    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }

    public boolean addProduct(Product product){
        for (int i = 0; i < this.productList.size(); i++) {
            if(product.getId() == this.productList.get(i).getId()){
                return false;
            }
        }
        this.productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product){
        return this.productList.remove(product);
    }

    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    public void transact(Product product,int method){
        if(method==0){
            this.productList.remove(product);
            this.income = this.income + product.getPrice();
        }
        if(method==1){
            this.productList.add(product);
            this.income = this.income - product.getPrice();
        }
    }



}
