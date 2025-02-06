import java.util.*;
import java.io.*;
import java.math.*;
//import Product;

public class Store{ 
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
      this.name = name; this.income = 0; this.productList = new ArrayList<Product>(); this.id = ++cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
      this.name = name; this.income = income; this.productList = productList; this.id = ++cnt;
    }
    public boolean hasProduct(Product product){
      if(productList.contains(product) == true) return true;
      else return false;
    }
    public boolean addProduct(Product product){
      if(hasProduct(product) == true) return false;
      else{
         this.productList.add(product); return true;
      }
    }
    public boolean removeProduct(Product product){
      if(hasProduct(product) == true){
        this.productList.remove(product);
        return true;
      }
      else{
         return false;
      }
    }
    public ArrayList<Product> getProductList(){
         return productList;
    }
    public void transact(Product product, int method){
       if(method == 0){
         this.productList.remove(product); this.income += product.getPrice(); 
       }
       if(method == 1){
          this.productList.add(product); this.income -= product.getPrice();
       }
    } 
   

    public  static void main(String[] args){
          float price = 1.2f; String name = "sock";
    	    Product my = new Product(name, price); my.setRating(3); my.setRating(5);my.setRating(4);
          //System.out.println(my.toString());
          String store_name = "xiaotian";
          Store st = new Store(name);
          st.addProduct(my);
          st.transact(my, 0);
          System.out.println(st.income);

    }
}

