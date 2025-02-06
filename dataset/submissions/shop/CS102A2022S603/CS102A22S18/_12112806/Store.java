// package Exer2;

import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    //attribute
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    //constructor
    public Store(String name) {
        this.id = ++cnt;
        this.name = name;
        this.income=0;
        this.productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        id = ++cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    //method
    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }

    public boolean addProduct(Product product){
        if (this.hasProduct(product) == true){
            return false;
        } else {
            this.productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if (this.hasProduct(product) == true){
            this.productList.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method){
        switch (method){
            //purchase
            case 0:
                this.removeProduct(product);
                this.income += product.getPrice();
                break;
            //refund
            case 1:
                this.addProduct(product);
                this.income -= product.getPrice();
                break;
        }
    }
}
