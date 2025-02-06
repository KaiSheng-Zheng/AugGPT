import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id=cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.getProductList().contains(product)==true&&wallet >= product.getPrice()){
            wallet-=product.getPrice();
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }
        else {return false;}
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> shoppingCart1=shoppingCart;
        switch (sortMethod){
            case PurchaseTime:
                for(int i=0;i<shoppingCart1.size();i++){
                    System.out.println(shoppingCart1.get(i).toString());
                }
                break;

            case Rating:
                float[] score=new float[shoppingCart1.size()];
                for(int i=0;i<shoppingCart1.size();i++){
                    score[i]=shoppingCart1.get(i).getAvgRating();
                }
                Arrays.sort(score);
                
                for(int i =0;i<shoppingCart1.size();i++){
                    for (int j=0;j<shoppingCart1.size();j++){
                        if(shoppingCart1.get(j).getAvgRating()==score[i]){
                            System.out.println(shoppingCart1.get(j));
                        }
                    }
                }
                break;

            case Price:
                float[] score1=new float[shoppingCart1.size()];
                for(int i=0;i<shoppingCart1.size();i++){
                    score1[i]=shoppingCart1.get(i).getPrice();
                }
                Arrays.sort(score1);
                for(int i =0;i<shoppingCart1.size();i++){
                    for (int j=0;j<shoppingCart1.size();j++){
                        if(shoppingCart1.get(j).getPrice()==score1[i]){
                            System.out.println(shoppingCart1.get(j));
                        }
                    }
                }
                break;
        }
    }

}
