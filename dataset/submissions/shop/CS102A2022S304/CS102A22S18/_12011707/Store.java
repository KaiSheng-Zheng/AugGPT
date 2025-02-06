import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList =new ArrayList<>();
    private float income;

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Store.cnt = cnt;
    }

    public Store(String name){
        this.name=name;
        cnt+=1;
        this.id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.productList.addAll(productList);
        this.income=income;
        cnt+=1;
        this.id=cnt;
    }
    public boolean hasProduct(Product product){
        boolean a=false;
        for (int i = 0; i < productList.size(); i++) {
            if(Product.equals(productList.get(i),product)){
                a=true;
            }
        }
        return a;
    }
    public boolean addProduct(Product product){
        boolean a=true;
        for (int i = 0; i < productList.size(); i++) {
            if(Product.equals(product,productList.get(i))){
                a=false;
            }
        }
        if(a){
            productList.add(product);
        }
        return a;
    }
    public boolean removeProduct(Product product){
        boolean a=false;
        for (int i = 0; i < productList.size(); i++) {
            if(Product.equals(product,productList.get(i))){
                a=true;
                productList.remove(i);
            }
        }
        return a;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            for (int i = 0; i < productList.size(); i++) {
                if(Product.equals(product,productList.get(i))){
                    productList.remove(i);
                }
            }
            this.income+=product.getPrice();
        }
        if(method==1){
            productList.add(product);
            this.income-=product.getPrice();
        }
    }
}
