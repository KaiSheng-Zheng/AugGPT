import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private  ArrayList<Product> removedproductlist;
    private float income;

    public Store(String name){
        this.name = name;
        this.income = 0;
        cnt++;
        this.id = cnt;
        this.productList = new ArrayList<Product>();
        this.removedproductlist = new ArrayList<Product>();
    }

    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.income =income;
        this.productList = productList;
        cnt++;
        this.id = cnt;
        this.removedproductlist = new ArrayList<Product>();
    }

    public boolean hasProduct(Product product){
        for(int i=0;i<this.productList.size();i++){
            if(this.productList.get(i).getId()==product.getId()){
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product){
        if(this.productList.contains(product)){
            return false;
        }else {
            this.productList.add(product);
            return true;
        }

    }

    public boolean removeProduct(Product product){
        if(this.productList.contains(product)){
            this.productList.remove(product);
            return true;
        }else return false;
    }

    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            this.productList.remove(product);
            this.updateincome(product.getPrice());
            this.updeteremovedproductlist(product);
        }else if(method==1){
            addProduct(product);
            this.removeremovedproductlist(product);
            this.updateincome(-product.getPrice());
        }
    }

    public void updateincome(float income){
        this.income += income;
    }

    public void updeteremovedproductlist(Product product){
        this.removedproductlist.add(product);
    }

    public void removeremovedproductlist(Product product){
        this.removedproductlist.remove(product);
    }


    public boolean hasremovedProduct(Product product){
        for(int i=0;i<this.removedproductlist.size();i++){
            if(this.removedproductlist.get(i).getId()==product.getId()){
                return true;
            }
        }
        return false;
    }
}
