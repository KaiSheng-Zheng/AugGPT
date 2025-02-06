import java.util.ArrayList;
public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public static ArrayList<Store> st = new ArrayList<>();
    public static ArrayList<Store> st1 = new ArrayList<>();



    public Store(String name){
        this.name=name;
        cnt++;
        this.id=cnt;
        income=0;
        st.add(this);
        st1.add(this);
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name=name;
        this.productList=productList;
        this.income=income;
        this.id=cnt;
        st.add(this);
        st1.add(this);
    }



    public boolean hasProduct(Product product){ int a=0;
        for(int i=0;i<productList.size();i++){
            if(product.getId()==productList.get(i).getId()){
                a=1;
            }
        }
        if(a==1){return true;}
        else return false;
    }

    public boolean addProduct(Product product){
        if(hasProduct(product))
            return false;
        else{
            productList.add(product);
            for (int i=0;i<st.size();i++){
                if(st.get(i).hasProduct(product)){
                    st.set(i,this);
                }
            }
            for (int i=0;i<st1.size();i++){
                if(st1.get(i).hasProduct(product)){
                    st1.set(i,this);
                }
            }
            return true;
        }

    }

    public boolean removeProduct(Product product){
        if(hasProduct(product)) {
            productList.remove(product);
            for (int i=0;i<st1.size();i++){
                if(st1.get(i).hasProduct(product)){
                    st1.set(i,this);
                }
            }
            return true;
        }
        else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            income=income+product.getPrice();

        }else {
            productList.add(product);
            income=income-product.getPrice();
            for (int i=0;i<st.size();i++){
                if(st.get(i).hasProduct(product)){
                    st.set(i,this);
                }
            }
        }
    }


}
