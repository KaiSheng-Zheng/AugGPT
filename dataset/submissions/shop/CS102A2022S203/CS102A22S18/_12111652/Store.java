import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;
        income = 0;
        this.productList =new ArrayList<>();
        cnt+=1;
        id=cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this(name);
        this.name = name;
        this.productList = productList;
        this.income = income;

    }
    public boolean hasProduct(Product product){
        int count=0;
        for(int i=0;i<productList.size();i++){
            if(productList.get(i).equals(product)){
                count++;
            }
        }
        return count != 0;
    }
    public boolean addProduct(Product product){
        int count=0;
        for (Product value : productList) {
            if (value.equals(product)) {
                count++;
            }
        }
        if(count==0){
            productList.add(product);
           return true;
        }
        else{return false;}
    }
    public boolean removeProduct(Product product){
        int count=0;
        for (int i=0;i<productList.size();i++) {
            if (productList.get(i).equals(product)) {
                productList.remove(i);
                count++;
            }
        }
        return count!=0;
        }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            removeProduct(product);
            income+=product.getPrice();
        }
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}