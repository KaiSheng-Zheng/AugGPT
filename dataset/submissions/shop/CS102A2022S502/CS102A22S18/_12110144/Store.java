import java.util.ArrayList;
import java.util.Iterator;

public class Store {
    private static int cnt=0; // will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private ArrayList<Product> his=new ArrayList<>();
    private float income;
    public Store(String name){
        cnt++;
        id=cnt;
        this.name=name;
        income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }
    public boolean hasProduct(Product product){
        boolean k=false;
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId()==product.getId()){k=true;break;}
        }
        return k;
    }
    public boolean addProduct(Product product){
        boolean k=!hasProduct(product);
        if(k)productList.add(product);
        return k;
    }
    public boolean removeProduct(Product product){
        boolean k=false;
        for (Iterator<Product> i=productList.iterator();i.hasNext();) {
            if(i.next().getId()==product.getId()){k=true;i.remove();break;}
        }
        return k;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){if(removeProduct(product))income+=product.getPrice();his.add(product);}
        if(method==1&&!hasProduct(product)&&his.contains(product)){addProduct(product);income-=product.getPrice();his.remove(product);}
    }
}