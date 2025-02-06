import java.text.DecimalFormat;
import java.util.Scanner;import java.util.Arrays;
import java.lang.Math;import java.util.ArrayList;
public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private ArrayList<Store> stores=new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;
        cnt++;id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        for (int i=0;i< productList.size();i++){
            this.productList.add(productList.get(i));
        }
        this.income=income;
        cnt++;id=cnt;
    }

    public float getIncome() {
        return income;
    }

    public boolean hasProduct(Product product){
        if (productList.contains(product)){
            return true;
        }
        else return false;
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }
        else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }
        else return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public String getName(){
        return name;
    }
    public void transact(Product product, int method){
        if(method==0){
            if(removeProduct(product)){
                income=income+product.getPrice();
            }
        }
        if(method==1){
            if(income>=product.getPrice()){
                if(addProduct(product)){
                    income=income-product.getPrice();
                }
            }
        }
    }
}
