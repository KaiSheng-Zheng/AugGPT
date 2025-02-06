import java.util.ArrayList;
import java.util.Collections;
import  java.util.Comparator;


public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;



    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        this.id=cnt;

    }
    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }else{
            return false;
        }
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);



            return true;

        }else{
            return false;
        }

    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());

                }
                break;
            case Rating:
                Collections.sort(shoppingCart, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getAvgRating()>o2.getAvgRating()){
                            return 1;
                        }
                        else if(o1.getAvgRating()<o2.getAvgRating()){
                            return -1;
                        }else{
                            if(o1.getId()>o2.getId()){
                                return 1;
                            }else{
                                return -1;
                            }
                        }
                    }
                });
                for (int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            case Price:
                Collections.sort(shoppingCart, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getPrice()>o2.getPrice()){
                            return 1;
                        }
                        else if(o1.getPrice()<o2.getPrice()){
                            return -1;
                        }
                           else{
                                if(o1.getId()>o2.getId()){
                                    return 1;
                                }else{
                                    return -1;
                                }
                            }

                    }
                });
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }

        }





    }


}
