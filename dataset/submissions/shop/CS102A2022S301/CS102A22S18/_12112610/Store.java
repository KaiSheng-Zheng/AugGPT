

import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        cnt++;
        this.name = name;
        this.productList= new ArrayList<>();
        this.income = income;
        this.id = cnt;}
    public Store(String name,ArrayList<Product>productList,float income){
        cnt++;
        this.name = name;
        this.productList = productList;
        this.income = income;
        this.id = cnt;

    }
    public Store(){}
    public boolean hasProduct(Product product){
        for (int i = 0; i<productList.size();i++){
           if (productList.get(i)== product){
               return true;
           }
        }
        return false;
    }
    public boolean addProduct(Product product){
        for (int i = 0; i< productList.size();i++){
            if (product.pid== productList.get(i).pid){
                return false;
            }
        }
        productList.add(product);
        product.store=this;
       return true;
    }
    public boolean removeProduct(Product product){
        for (int i = 0; i< productList.size();i++){
            if (product.pid== productList.get(i).pid){
                productList.remove(product);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Product> getProductList(){return productList;}
    public void transact(Product product,int method){
        if ( method == 0){
            productList.remove(product);
            income = income + product.getPrice();
        }
        if (method ==1){
            productList.add(product);
            income = income - product.getPrice();
        }
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}
