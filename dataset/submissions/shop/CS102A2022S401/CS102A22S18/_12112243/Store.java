import java.util.ArrayList;
public class Store {
    private static int cnt = 0 ;// initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(String name){
        this.name = name;
        income = 0;
        cnt  +=1;
        id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt += 1;
        id = cnt;
    }

    public boolean hasProduct ( Product product ) {
        int a = 0 ;
        for( int i = 0 ; i< productList.size(); i++ ){
            if(product.equals(productList.get(i))){
                a=1;
            }
        }
        if ( a==1 ) return true;
        else return false;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
                return false;
        }
        else{
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }
    public float changeIncome(float price){
        income = income + price;
        return income;
    }

    public void transact(Product product, int method){
        if( method ==0 ){
            productList.remove(product);
            income = income + product.getPrice();
        }
        if( method == 1){
            productList.add(product);
            income = income - product.getPrice();
        }
    }
}
