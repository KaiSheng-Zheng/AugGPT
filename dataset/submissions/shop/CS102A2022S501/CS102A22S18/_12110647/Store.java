import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productArrayList;
    private float income;

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public Store(String name){
        return;
    }
    public Store(String name,ArrayList<Product> productList,float income){//given income and productList
        getProductList();
    }
    public boolean hasProduct(Product product){

            if (productArrayList.contains(product)) {//judge if the productList contains the given product

                return true;
            } else {
                return false;
            }

    }
    public boolean addProduct(Product product){//add product to productList，and judge if it's successful
        addProduct(product);
        ArrayList<Product> productList=productArrayList;
        //System.out.println(productList);
        return true;
    }
    public boolean removeProduct(Product product){
        if(productArrayList.contains((product))){
            for (int i = 0; i < productArrayList.size(); ++i) {
                String v = String.valueOf(productArrayList.get(i));
                productArrayList.remove(v);
            }
        }
        return true;
    }
    public ArrayList<Product> getProductList(){
        return productArrayList;
    }
    public void transact(Product product,int method){
        if(method==0){//remove product change the income
            product.getPrice();
            income=income+ product.getPrice();//+产品价格
            this.removeProduct(product);
        }
    }
}