import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name) {
        cnt++;
        this.name = name;
        income = 0;
        id=cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.name = name;
        this.productList = productList;
        this.income = income;
        id=cnt;
    }

    public boolean hasProduct(Product product){
        int det=0;
for(Product product1:productList){
    if (product1 == product) {
        det = 1;
        break;
    }
}
        return det == 1;
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)){return false;}
        else productList.add(product);return true;
    }

    public boolean removeProduct(Product product){
        if(hasProduct(product)){productList.remove(product);return true;}
        else return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0&&hasProduct(product)){removeProduct(product);income=income+product.getPrice();}
        if(method==1&&(!hasProduct(product))){addProduct(product);income=income-product.getPrice();}
    }

}
