import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        this.name = name;
        cnt +=1;
        id =cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        boolean result = false;
        if (Product.getCnt() != 0) {
            result = true;
        }
        return result;
    }
    public boolean addProduct(Product product){
        boolean result=true;
        for(int i = 0; i < productList.size();i++) {
            if (product.getId()==productList.get(i).getId()){
                result =false;
                break;
            }
        }
        if(result){
            productList.add(product);
        }
        return  result;
    }
    public boolean removeProduct(Product product){
        boolean result = false;
        for(int i = 0; i < productList.size();i++) {
            if (product.getId()==productList.get(i).getId()){
                result =true;
                break;
            }
        }
        if(result){
            productList.remove(product);
        }
        return  result;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method ==0){
            productList.remove(product);
            income =income+product.getPrice();
        }
        if(method ==1){
            productList.add(product);
            income=income-product.getPrice();
        }
    }

}
