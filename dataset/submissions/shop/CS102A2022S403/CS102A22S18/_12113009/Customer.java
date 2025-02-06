import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    // The list of purchased products; default is empty.
    private Store[] storelist= new Store[10000000];
    private float wallet;

    public Customer(String name, float wallet){
this.name=name;
this.wallet=wallet;
cnt++;
this.id=cnt;
    }


    public boolean rateProduct(Product product, int rating) {
//whether it has problem
return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet+=amount;
    }


    public boolean purchaseProduct(Store store, Product product) {
if(product.getPrice()<=wallet&&store.getProductList().contains(product))
{
    int a=product.getId();
    storelist[a]=store;
    updateWallet(-product.getPrice());
    store.getProductList().remove(product);
    shoppingCart.add(product);

    store.setIncome(store.getIncome()+ product.getPrice());
    return true;
}
else
    return false;

    }



        public void viewShoppingCart(SortBy sortMethod) {


            if (sortMethod == SortBy.Price) {
                ArrayList<Product> s1=new ArrayList<>();
                s1.addAll(shoppingCart);
                Collections.sort(s1, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getPrice() - o2.getPrice() > 0) return 1;
                        else if (o1.getPrice() - o2.getPrice() < 0) return -1;
                        else return 0;
                    }
                });

                for (Product product : s1) {
                    System.out.println(product);
                }


            }
            if (sortMethod == SortBy.Rating){
                ArrayList<Product> s2=new ArrayList<>();
                s2.addAll(shoppingCart);
                Collections.sort(s2, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getAvgRating() - o2.getAvgRating() > 0) return 1;
                        else if (o1.getAvgRating() - o2.getAvgRating() < 0) return -1;
                        else return 0;
                    }
                });

                for (Product product : s2) {
                    System.out.println(product);
                }

            }
            if(sortMethod==SortBy.PurchaseTime){
                for (Product product : shoppingCart) {
                    System.out.println(product);
                }
            }
        }



    public boolean refundProduct(Product product) {
        if(shoppingCart.contains(product))
        {
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            storelist[product.getId()].getProductList().add(product);
            storelist[product.getId()].setIncome(storelist[product.getId()].getIncome()-product.getPrice());
            return true;
        }
        else return false;
    }
}
 enum SortBy {
    PurchaseTime, Rating, Price;
}