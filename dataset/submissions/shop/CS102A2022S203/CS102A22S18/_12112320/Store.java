import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;
        income=0;
        cnt++;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        for (Product p:productList){
        this.productList.add(p);}
        this.income=income;
            cnt++;
            id=cnt;
        }

        public boolean hasProduct(Product product){
            for (Product p:productList){
                if (p.equals(product)){return true;}
            }
            return false ;
        }

    public boolean addProduct(Product product){
        for (Product p:productList){
            if (p.equals(product)){return false;}
        }
        productList.add(product);
        return true;
    }

        public boolean removeProduct(Product product){
            for (Product p:productList){
                if (p.equals(product)){
                    productList.remove(p);
                    return true;}
            }
            return false;

        }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            income+=product.getPrice();}
        if (method==1){
            addProduct(product);
            income-=product.getPrice();
        }
        }

        }



