import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private int order;
    private HashMap proSto;
    ArrayList<Product> sp;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
        sp = new ArrayList<>();
        proSto = new HashMap();
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        boolean b = product.setRating(rating);
        product.getCr().put(this, rating);
        return b;
    }

    public void updateWallet(float amount){ wallet += amount; }

    public boolean purchaseProduct(Store store, Product product){
        if(store.getProductList().contains(product) && wallet >= product.getPrice()){
            store.transact(product, 0);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            order++;
            proSto.put(product, store);
            sp = (ArrayList<Product>) shoppingCart.clone();
            return true;
        }else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
//        ArrayList<Product> sp = (ArrayList<Product>) shoppingCart.clone();
        switch (sortMethod) {
            case PurchaseTime:
                for (Product p : shoppingCart) {
                    System.out.println(p);
                }
                sp = (ArrayList<Product>) shoppingCart.clone();
                break;
            case Rating:
               /* int l = shoppingCart.size();
                Product[] newSC = new Product[l];
                for (int i = 0; i < l; i++) {
                    newSC[i] = shoppingCart.get(i);
                }
                for (int i = 0; i < l; i++) {
                    for (int j = i; j < l; j++) {
                        float ri = newSC[i].getAvgRating(), rj = newSC[j].getAvgRating();
                        if(ri > rj){
                            Product temp = newSC[i];
                            newSC[i] = newSC[j];
                            newSC[j] = temp;
                        }
                    }
                }
                for (int i = 0; i < l; i++) {
                    System.out.println(newSC[i]);
                }*/
                shoppingCart.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return (int) ((o1.getAvgRating() - o2.getAvgRating()) * 100);
                    }
                });
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
                break;
        }
            if(sortMethod.equals(SortBy.Price)){
                int l1 = sp.size();
                Product[] newSC1 = new Product[l1];
                for (int i = 0; i < l1; i++) {
                    newSC1[i] = sp.get(i);
                }
                for (int i = 0; i < l1; i++) {
                    for (int j = i; j < l1; j++) {
                        if(newSC1[i].getPrice() > newSC1[j].getPrice()){
                            Product temp = newSC1[i];
                            newSC1[i] = newSC1[j];
                            newSC1[j] = temp;
                        }
                    }
                }
                for (int i = 0; i < l1; i++) {
                    System.out.println(newSC1[i]);
                }
              /*  sp.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return (int) ((o1.getPrice()-o2.getPrice())*100);
                    }
                });
                for (int i = 0; i < sp.size(); i++) {
                    System.out.println(sp.get(i));
                }*/
        }


    }

    public boolean refundProduct(Product product){
        Store store = (Store) proSto.get(product);
        if(shoppingCart.contains(product)){
            store.transact(product, 1);
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            proSto.remove(product);
            sp = (ArrayList<Product>) shoppingCart.clone();
            return true;
        }else return false;
    }
}

enum SortBy{
    PurchaseTime, Rating, Price
}

class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id = cnt;
    }

    public Store(String name){
        this.name = name;
        this.productList = new ArrayList<>();
        this.income = 0;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product){
        if(productList.contains(product)) return true;
        else return false;
    }

    public boolean addProduct(Product product){
        boolean b = true;
        for (int i = 0; i < productList.size(); i++) {
            if(product.getId() == productList.get(i).getId()){
                b = false;
                break;
            }
        }
        if(b) productList.add(product);
        return b;
    }

    public boolean removeProduct(Product product){
        if(productList.contains(product)){
            productList.remove(product);
            return true;
        }else return false;
    }

    public ArrayList<Product> getProductList(){ return productList; }

    public void transact(Product product, int method){
        switch (method){
            case 0:
                removeProduct(product);
                income += product.getPrice();
                break;
            case 1:
                addProduct(product);
                income -= product.getPrice();
                break;
            default:
                System.out.println("Invalid!");
        }
    }

    //GS
    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Store.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}

class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private HashMap cr;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
        cr = new HashMap();
        cnt++;
        id = cnt;
    }

    public boolean setRating(int rating){
        if(rating >= 1 && rating <= 5){
            int r = rating;
            ratings.add(r);
            return true;
        }else return false;
    }

    public float getAvgRating(){
        //original form
        if(ratings.size() == 0) return 0;
        int sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum += ratings.get(i);
        }
        return ((float) sum)/((float) ratings.size());

        //hashmap form
       /* int sum = 0;
        for (Object key : cr.keySet()) {
            sum += (int) cr.get(key);
        }
        return ((float) sum)/((float) cr.size());*/

        //combine form
        /*int sum = 0;
        if(cr.size() >= ratings.size() && cr.size() != 0){
            for (Object key : cr.keySet()) {
                sum += (int) cr.get(key);
            }
        }else {
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
        }
        return ((float) sum)/((float) ratings.size());*/
    }

    public String toString() {
        double r = getAvgRating();
        double f = Math.floor(100*r)-10*Math.floor(10*r);
        if(f > 4.9) r += 0.1;
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, Math.floor(r*10)/10);
    }

    //GS
    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public HashMap getCr() { return cr; }
}
