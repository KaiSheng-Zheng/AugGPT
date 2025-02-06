import java.util.ArrayList;

public class Customer {

    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    private ArrayList<Store> storelist= new ArrayList<>();

    public Customer(String name, float wallet) {
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;

    }
    public boolean rateProduct(Product product, int rating){
        if (rating<=5&&rating>=1){product.setRating(rating);return true;}
        return false;
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&product.getPrice()<=wallet){
            wallet-=product.getPrice();
            shoppingCart.add(product);
            store.transact(product,0);
            storelist.add(store);
            return true;

        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){


        if (sortMethod==SortBy.PurchaseTime){

            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i));
            }
        }
        if (sortMethod==SortBy.Rating){int size=shoppingCart.size();
            int []a=new int[size];
            for (int i=0;i<size;i++){
                int n=0;
                float r=shoppingCart.get(i).getAvgRating();
                for (int j=0;j<size;j++){
                    if (r>shoppingCart.get(j).getAvgRating()){
                        n++;
                    }
                    else if (r==shoppingCart.get(j).getAvgRating()&&i>j){n++;}
                }
                    a[n]=i;
            }
            for (int i=0;i<size;i++){
                System.out.println(shoppingCart.get(a[i]));
            }

        }
        if (sortMethod==SortBy.Price){
            int size=shoppingCart.size();
            int []a=new int[size];
            for (int i=0;i<size;i++){
                int n=0;
                float p=shoppingCart.get(i).getPrice();
                for (int j=0;j<size;j++){
                    if (p>shoppingCart.get(j).getPrice()){
                        n++;
                    }
                    else if (p==shoppingCart.get(j).getPrice()&&i>j){n++;}
                }
                a[n]=i;
            }
            for (int i=0;i<size;i++){
                System.out.println(shoppingCart.get(a[i]));
            }
        }

    }


    public boolean refundProduct(Product product){
        boolean y=false;int stn=0;
        for (int i=0;i<shoppingCart.size();i++){
            if (shoppingCart.get(i).equals(product)){
                y=true;stn=i;
                break;
            }
        }
        if (y==false){return false;}
        else {wallet+=product.getPrice();
            shoppingCart.remove(product);
            storelist.get(stn).transact(product,1);
            storelist.remove(stn);
            return true;
        }
    }


}
