import java.util.ArrayList;
public class Store{
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.

    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;

        this.name=name;
        this.income=income;
        this.productList=new ArrayList<>();
        if(productList!=null){
            this.productList.addAll(productList);
        }
        if(productList==null){
            return;
        }

    }

    public Store(String name){
        this(name,null,0F);
    }



    public String getStoreName() {
        return name;
    }

    public boolean hasProduct(Product product){
        if(productList.contains(product)){
            return true;
        }else {
            return false;
        }
    }

    public void addIncome(float income) {
        this.income +=income;
    }

    public void minusIncome(float outcome){
        this.income -= outcome;
    }

    public boolean addProduct(Product product){
        if(productList.size()==0){
            productList.add(product);
            product.setTag(this);
            return true;
        }
        if(productList.contains(product)){
            return false;
        }
        if(!productList.contains(product)){
            for (int i = 0; i < productList.size(); i++) {
                if(productList.get(i).getId()==product.getId()){
                    return false;
                }
            }
            productList.add(product);
            product.setTag(this);
            return true;
        }
        return false;
    }
    public boolean removeProduct(Product product){
        if(productList==null){
            return false;
        }
        if(productList.contains(product)){
            productList.remove(product);
            return true;
        }
        if(!productList.contains(product)){
            for (int i = 0; i < productList.size(); i++) {
                if(productList.get(i).getId()==product.getId()){
                    productList.remove(product);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public ArrayList<Product> getProductList(){
        //NOTICE: we may need to guarantee the private safety.
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            if(productList.contains(product)){
                addIncome(product.getPrice());
                removeProduct(product);
            }
        }
        if (method==1){
            if(!productList.contains(product)){
                minusIncome(product.getPrice());
                addProduct(product);
            }
        }
    }
}