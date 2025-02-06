import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;



public Store(String name){
    this.name=name;
    this.income=0;
    this.productList=new ArrayList<>();
    cnt++;
    this.id=cnt;
}

public Store(String name,ArrayList<Product> productList,float income){
    this.name=name;
    this.income=income;
    this.productList=productList;
    cnt++;
    this.id=cnt;
}

    public float getIncome() {
        return income;
    }

    public boolean hasProduct(Product product){
    for (int i = 0; i < this.productList.size(); i++) {
        if(this.productList.get(i).equals(product)){
            return true;
        }
    }
    return false;
}

public boolean addProduct(Product product){
    for (int i = 0; i < this.productList.size(); i++) {
        if(this.productList.get(i).equals(product)){
            return false;
        }
    }
    this.productList.add(product);
    return true;
}

public boolean removeProduct(Product product){
    for (int i = 0; i <this.productList.size(); i++) {
        if(this.productList.get(i).equals(product)){
            this.productList.remove(this.productList.get(i));
            return true;
        }
    }
    return false;
}

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method){
    if(method==0){
    productList.remove(product);
    this.income+=product.getPrice();
    return;
}
    if(method==1){
        productList.add(product);
        this.income-=product.getPrice();
    }
}



}
