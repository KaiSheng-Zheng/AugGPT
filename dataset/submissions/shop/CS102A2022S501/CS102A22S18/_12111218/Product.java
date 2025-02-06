import java.util.ArrayList;


public class Product {
    private static int cnt=0;



    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;

    }
    public boolean setRating(int rating){
        boolean a=true;
        if(rating>=1&&rating<=5){
            ratings.add(rating);

        }
        else{a=false;}
        return a;

    }

    public int getId() {
        return id;
    }

    public float getAvgRating(){
        float b=0;
        for (int al=0;al<ratings.size();al++){
            b+=ratings.get(al);
        }
        if(ratings.size()>0){return b/ ratings.size();}
        else{return b;}

    }
    public float getPrice() {
        return price;
    }
    public String toString(){
        String s="Product ID "+String.format("%d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
        return s;
    }

}
class Store{private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){this.name=name;cnt++;id=cnt;income=0;}
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;this.productList=productList;this.income=income;cnt++;id=cnt;
    }
    public boolean hasProduct(Product product) {
        boolean ha = false;
        for (int o = 0; o < productList.size(); o++) {
            if (productList.get(o).getId() == product.getId()) {
                ha = true;
                break;
            }
        }
        return ha;
    }
    public boolean addProduct(Product product){
        boolean c=true;
        if(hasProduct(product)){
            c=false;

        }
        else {productList.add(product);}
        return c;
    }
    public boolean removeProduct(Product product){
        boolean lh=true;
        if(!hasProduct(product)){
            lh=false;
        }
        else {productList.remove(product);}
        return lh;
    }
    public ArrayList<Product> getProductList(){return productList;}
    public void transact(Product product, int method){if(method==0){if(hasProduct(product)){income+=product.getPrice();}removeProduct(product);}}


    public void setIncome(float income) {
        this.income +=income;
    }
}
class Customer{
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;

    }
    public boolean rateProduct(Product product, int rating){return product.setRating(rating);}
    public void updateWallet(float amount){wallet+=amount;}
    public boolean purchaseProduct(Store store, Product product) {
        boolean ml = false;
        if (store.hasProduct(product)&&wallet >=product.getPrice()) {
            updateWallet(-product.getPrice());
            ml=true;
            shoppingCart.add(product);
            store.transact(product,0);

        }
        return ml;
    }
    public void viewShoppingCart() {for (int f = 0;  f< shoppingCart.size(); f++) {System.out.println(shoppingCart.get(f));}}


    public void viewShoppingCart(SortBy sortMethod) {


            ArrayList<Product> lm = new ArrayList<>();
            for (int f = 0; f < shoppingCart.size(); f++) {
                lm.add(shoppingCart.get(f));

            }
            if (sortMethod == SortBy.PurchaseTime) {
                for (int f = 0; f < lm.size(); f++) {

                    System.out.println(shoppingCart.get(f));
                }
            } else if (sortMethod == SortBy.Rating) {
                ArrayList<Product> p = new ArrayList<>();
                for (int f = 0; f <lm.size();f++) {
                    boolean pl = true;
                    for (int k = 0; k < lm.size(); k++) {
                        if (lm.get(f).getAvgRating() > lm.get(k).getAvgRating()) {

                            pl = false;
                            break;

                        }
                    }

                    if (pl) {
                        p.add(lm.get(f));
                        lm.remove(f);
                        f = -1;
                    }


                }

                for (int f = 0; f < p.size(); f++) {

                    System.out.println(p.get(f));
                }
            }
            else {
                ArrayList<Product> p = new ArrayList<>();
                for (int f = 0; f < lm.size(); f++) {
                    boolean pl = true;
                    for (int k = 0; k < lm.size(); k++) {
                        if (lm.get(f).getPrice() > lm.get(k).getPrice()) {

                            pl = false;
                            break;

                        }
                    }

                    if (pl) {
                        p.add(lm.get(f));
                        lm.remove(f);
                        f = -1;
                    }
                }
                for (int f = 0; f < p.size(); f++) {

                    System.out.println(p.get(f));
                }

            }
        }


    public boolean refundProduct(Product product){return true;}
}