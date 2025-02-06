import java.util.ArrayList;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
        this.shoppingCart=new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);


    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>= product.getPrice()){

            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.removeProduct(product);
            return true;
        }else return false;

    }
    public void viewShoppingCart(SortBy sortMethod){


        switch (sortMethod){
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());

                }
                break;
            case Rating:

                ArrayList<Product> newlist =  new ArrayList<>(shoppingCart);
                for(int i=0;i<newlist.size();i++){
                    for(int j=0;j<newlist.size()-1-i;j++){
                        if(newlist.get(j).getAvgRating()>newlist.get(j+1).getAvgRating()){
                            Product temp = newlist.get(j);
                            newlist.set(j,newlist.get(j+1));
                            newlist.set(j+1,temp);
                        }
                    }
                }
                for(int i=0;i<newlist.size();i++){
                    System.out.println(newlist.get(i).toString());
                }
                break;

            case Price:
                ArrayList<Product> sortP =  new ArrayList<>(shoppingCart);
                for(int i=0;i<sortP.size();i++){
                    for(int j=0;j<sortP.size()-1;j++){
                        if(sortP.get(j).getPrice()>sortP.get(j+1).getPrice()){
                            Product temp = sortP.get(j);
                            sortP.set(j,sortP.get(j+1));
                            sortP.set(j+1,temp);
                        }
                    }
                }
                for(int i=0;i<sortP.size();i++){
                    System.out.println(sortP.get(i).toString());
                }
                break;

        }
    }




    }