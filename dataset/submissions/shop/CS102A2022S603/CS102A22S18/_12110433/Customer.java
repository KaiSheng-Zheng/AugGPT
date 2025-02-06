import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;



    public Customer(String name, float wallet){
        cnt++;
        this.name = name;
        this.id = cnt;
        this.wallet = wallet;
    }


    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet>=product.getPrice()){
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }else {
            return false;
        }
    }
    public ArrayList<Product> bubbleSort1(ArrayList<Product> arrayList){
        ArrayList<Product> arrayList1 = new ArrayList<>(arrayList);
        int len = arrayList1.size();
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arrayList1.get(j).getAvgRating() > arrayList1.get(j+1).getAvgRating()) {
                    Product temp = arrayList1.get(j+1);
                    arrayList1.set(j+1,arrayList1.get(j));
                    arrayList1.set(j, temp);
                }
            }
        }
        return arrayList1;
    }
    public ArrayList<Product> bubbleSort2(ArrayList<Product> arrayList){
        ArrayList<Product> arrayList2 = new ArrayList<>(arrayList);
        int len = arrayList2.size();
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arrayList2.get(j).getPrice() > arrayList2.get(j+1).getPrice()) {
                    Product temp = arrayList2.get(j+1);
                    arrayList2.set(j+1,arrayList2.get(j));
                    arrayList2.set(j, temp);
                }
            }
        }
        return arrayList2;
    }
    public void viewShoppingCart(SortBy sortMethod){
//        if (sortMethod.equals(SortBy.PurchaseTime)){
//            for (Product product: shoppingCart) {
//                System.out.println(product.toString());
//            }
//        }
//        if (sortMethod.equals(SortBy.Rating)){
//            ArrayList<Float> ratings = new ArrayList<>();
//            for (int i = 0; i < shoppingCart.size(); i++) {
//                ratings.add(shoppingCart.get(i).getAvgRating());
//            }
//            ratings.sort(Comparator.naturalOrder());
//
//            for (int i = 0; i < ratings.size(); i++) {
//                for (int j = 0; j < ratings.size(); j++) {
//                    if (ratings.get(i)==shoppingCart.get(j).getAvgRating()){
//                        System.out.println(shoppingCart.get(j));
//                        shoppingCart.remove(j);
//                        break;
//                    }
//                }
//            }
//        }
//        if (sortMethod.equals(SortBy.Price)){
//            ArrayList<Float> pricess = new ArrayList<>();
//            for (int i = 0; i <shoppingCart.size() ; i++) {
//                pricess.add(shoppingCart.get(i).getPrice());
//            }
//            pricess.sort(Comparator.naturalOrder());
//            for (int i = 0; i < pricess.size(); i++) {
//                for (int j = 0; j < pricess.size(); j++) {
//                    if (pricess.get(i)==shoppingCart.get(j).getPrice()){
//                        System.out.println(shoppingCart.get(j).toString());
//                        shoppingCart.remove(j);
//                        break;
//                    }
//
//                }
//            }
//
//        }
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (Product product: shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod.equals(SortBy.Rating)){
            ArrayList<Product> products = bubbleSort1(shoppingCart);
            for (Product product: products) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod.equals(SortBy.Price)){
            ArrayList<Product> products = bubbleSort2(shoppingCart);
            for (Product product: products) {
                System.out.println(product.toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        int id = product.getId();
        for (Product product1: shoppingCart) {
            if (product1.getId()==id){
                shoppingCart.remove(product);
                updateWallet(product.getPrice());
                return true;
            }
        }
        return false;
    }
}

