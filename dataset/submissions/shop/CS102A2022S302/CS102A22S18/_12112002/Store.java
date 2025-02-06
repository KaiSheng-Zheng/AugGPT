

import java.util.ArrayList;

public class Store {

    private static int cnt=0;//initial is 0 increase by 1 when the constructor is called
    private int id;//unique for each product and the value is set to cnt
    private String name;
    private float income;
    private ArrayList<Product> productList;
    private ArrayList<Product> buybuydePro;

    public ArrayList<Product> getBuybuydePro() {
        return buybuydePro;
    }



    public Store(String name) {
        cnt++;
        this.id=cnt;
        this.name = name;
        this.income = 0;
        this.productList = new ArrayList<>();
        this.buybuydePro=new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id=cnt;
        this.name = name;
        this.income = income;
        this.productList = productList;
        this.buybuydePro=new ArrayList<>();
    }


    public int getId() {
        return id;
    }



    public boolean hasProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId() == product.getId()){
                return true;
            }
        }
        return false;
    }

    public boolean hasbuybuydePro(Product product){
        for (int i = 0; i < buybuydePro.size(); i++) {
            if(buybuydePro.get(i).getId() == product.getId()){
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if (productList.contains(product)){
            productList.remove(product);
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if (method==0){
            this.removeProduct(product);
            this.buybuydePro.add(product);
            income+=product.getPrice();
        }else if (method==1){
            //refund

            this.productList.add(product);
            this.buybuydePro.remove(product);
            income-=product.getPrice();

        }
    }





}
