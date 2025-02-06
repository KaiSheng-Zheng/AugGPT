import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList= new ArrayList<Product>();
    private float income;

    public Store(String name){
        cnt++;
        id=cnt;
        this.name=name;
        income=0;
        productList=new ArrayList<>();
    }
    public Store(String name,ArrayList<Product> productList,float income){
        cnt++;
        id=cnt;
        this.name=name;
        this.income=income;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        if (productList.contains(product)){
            return true;
        }else{
            return false;
        }
    }
    public boolean addProduct(Product product){
        if (productList.contains(product)) {
            return false;
        }else{
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
//        if (hasProduct(product)){
//            for (int i = 0; i < productList.size(); i++) {
//                if (productList.get(i)==product){
//                    product.setFormalposition(i);
//                    productList.remove(i);
//                }
//            }
//            return true;
//        }else {
//            return false;
//        }
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product,int method){
        if (method==0){
            income+=product.getPrice();
            removeProduct(product);
        }
        if (method==1){
            income-=product.getPrice();
//            productList.add(product.getFormalposition(),product);
            productList.add(product);
        }
    }
}
