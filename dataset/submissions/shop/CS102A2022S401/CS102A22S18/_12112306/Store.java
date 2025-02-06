import java.util.ArrayList;

public class Store{
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    private ArrayList<Integer> idList = new ArrayList<>();

    public Store(String name){
        this.name = name;
        income = 0;
        productList = new ArrayList<>(0);
        cnt++;
        id = cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.income = income;
        this.productList = productList;
        cnt += 1;
        this.id = cnt;
    }

    public ArrayList<Product> getproductList() {
        return productList;
    }public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public boolean hasProduct(Product product){
       for (int x = 0;x<productList.size();x++){
           if (product.getId() == productList.get(x).getId()){return true;}
       }
       return false;
    }
    public boolean addProduct(Product product){
        boolean result = false;
        if(!hasProduct(product)){//not ths same kind
            productList.add(product);
            result = true;
            idList.add(this.id);
        }
        return result;
    }
    public boolean removeProduct(Product product){
        boolean result = false;
        if(hasProduct(product)){
            result = true;
            productList.remove(product);
        }return result;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method == 0){
            productList.remove(product);
            income += product.getPrice();
        }if(method==1){
            productList.add(product);
            income -= product.getPrice();
        }
    }
}
