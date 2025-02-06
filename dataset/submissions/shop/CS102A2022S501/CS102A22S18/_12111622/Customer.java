import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name= name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product,int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            shoppingCart.add(product);
            store.removeProduct(product);
            updateWallet(-product.getPrice());
            product.setItsStore(store);
            store.transact(product,0);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod.toString()){
            case "PurchaseTime":
                for(Product p1:shoppingCart){
                    System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\n",p1.getId(),p1.getName(),p1.getPrice(),p1.getAvgRating());
                }
                break;
            case "Rating":
                int []order=new int[shoppingCart.size()];
                for(int i=0;i<shoppingCart.size();i++){
                    order[i]=i;
                }
                for(int i=0;i<shoppingCart.size()-1;i++){
                    for(int j=i+1;j<shoppingCart.size();j++){
                        if(shoppingCart.get(order[j]).getAvgRating()<shoppingCart.get(order[i]).getAvgRating()){
                            int k=order[j];
                            order[j]=order[i];
                            order[i]=k;
                        }
                        if(shoppingCart.get(order[j]).getAvgRating()==shoppingCart.get(order[i]).getAvgRating()&&order[j]<order[i]){
                            int k=order[j];
                            order[j]=order[i];
                            order[i]=k;
                        }
                    }
                }
                for(int l:order){
                    System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\n",shoppingCart.get(l).getId(),shoppingCart.get(l).getName(),shoppingCart.get(l).getPrice(),shoppingCart.get(l).getAvgRating());
                }
                break;
            case "Price":
                int []order2=new int[shoppingCart.size()];
                for(int i=0;i<shoppingCart.size();i++){
                    order2[i]=i;
                }
                for(int i=0;i<shoppingCart.size()-1;i++){
                    for(int j=i+1;j<shoppingCart.size();j++){
                        if(shoppingCart.get(order2[j]).getPrice()<shoppingCart.get(order2[i]).getPrice()){
                            int k=order2[j];
                            order2[j]=order2[i];
                            order2[i]=k;
                        }
                        if(shoppingCart.get(order2[j]).getPrice()==shoppingCart.get(order2[i]).getPrice()&&order2[j]<order2[i]){
                            int k=order2[j];
                            order2[j]=order2[i];
                            order2[i]=k;
                        }
                    }
                }
                for(int l:order2){
                    System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\n",shoppingCart.get(l).getId(),shoppingCart.get(l).getName(),shoppingCart.get(l).getPrice(),shoppingCart.get(l).getAvgRating());
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        for(Product p1:shoppingCart){
            if(p1.getId()== product.getId()){
                shoppingCart.remove(p1);
                p1.getItsStore().transact(p1,1);
                updateWallet(p1.getPrice());
                return true;
            }
        }
        return false;
    }
}