import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        cnt++;
        this.id=cnt;
        this.name = name;
        this.income=0;
        this.productList=new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id=cnt;
        this.name = name;
        this.income = income;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        int finalTest=0;
        for(Product i:productList){
            if(i.equals(product)){finalTest=1;break;}
        }
        return finalTest == 1;
    }
    public boolean addProduct(Product product){
        for(Product i:productList){
            if(i.equals(product)){return false;}
        }productList.add(product);return true;
    }
    public boolean removeProduct(Product product){
        for(Product i:productList){
            if(i.equals(product)){productList.remove(i); return true;}
        }return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){productList.remove(product);
            this.income = this.income + product.getPrice();}
        if(method==1){
            productList.add(product);
            this.income = this.income - product.getPrice();
        }
    }
    public void backIncome(float price) {
        this.income = this.income-price;
    }
}
