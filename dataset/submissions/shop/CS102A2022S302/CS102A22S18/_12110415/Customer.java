import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    HashMap<Product,Store> mapWhereBuy=new HashMap<>();



    public Customer(String name,float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product,int rating){
        if(product.setRating(rating)){
            return true;
        }
        return false;
    }
    public void updateWallet(float amout){
        wallet+=amout;
    }
    public boolean purchaseProduct(Store store,Product product){
        if (store.hasProduct(product)){
            if (product.getPrice()<=wallet){
                store.transact(product,0);
                shoppingCart.add(product);
                wallet-=product.getPrice();
                mapWhereBuy.put(product,store);
                return true;
            }
            else return false;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        else if (sortMethod.equals(SortBy.Price)){
            ArrayList<Integer> ratingssdfds=new ArrayList<>();
            ratingssdfds.add(-909);
            ratingssdfds.add(-90997766);

            Product defultProduct=new Product("q,fheoix,",-567,-999999999f,ratingssdfds);

            float[] price=new float[shoppingCart.size()];

            for (int i = 0; i < shoppingCart.size(); i++) {
                price[i]=shoppingCart.get(i).getPrice();
            }

            Product[] products=new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                products[i]=shoppingCart.get(i);
            }

            Arrays.sort(price);

            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if (price[i]==products[j].getPrice()){
                        System.out.println(shoppingCart.get(j).toString());
                        products[j]=defultProduct;
                        break;
                    }
                }
            }
        }
        else if (sortMethod.equals(SortBy.Rating)){
            ArrayList<Integer> ratingssdfds=new ArrayList<>();
            ratingssdfds.add(-909);
            ratingssdfds.add(-90997766);

            Product defultProduct=new Product("q,fheoix,",-567,-999999999f,ratingssdfds);


            float[] ratings=new float[shoppingCart.size()];

            for (int i = 0; i < shoppingCart.size(); i++) {
                ratings[i]=shoppingCart.get(i).getAvgRating();
            }

            Product[] products=new Product[shoppingCart.size()];

            for (int i = 0; i < shoppingCart.size(); i++) {
                products[i]=shoppingCart.get(i);
            }

            Arrays.sort(ratings);

            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if (ratings[i]==products[j].getAvgRating()){
                        System.out.println(shoppingCart.get(j).toString());
                        products[j]=defultProduct;
                        break;
                    }
                }
            }

        }
    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            for (int i = 0; i < shoppingCart.size(); i++) {
                if (product.equals(shoppingCart.get(i))){
                    shoppingCart.remove(i);
                    wallet+=product.getPrice();
                    mapWhereBuy.get(product).transact(product,1);
                    break;
                }
            }
            return true;
        }
        return false;
    }




}
