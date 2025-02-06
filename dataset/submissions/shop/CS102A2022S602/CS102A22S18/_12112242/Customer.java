import java.util.ArrayList;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product>shoppingCart=new ArrayList<>();
    private float wallet;
    public Store store;
    public Customer(String name,float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }
        else {
            return false;
        }
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>= product.getPrice()){
            shoppingCart.add(product);
            store.transact(product,0);
            wallet-=product.getPrice();
            this.store=store;
            return true;
        }
        else {
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
                for (int i=0;i<shoppingCart.size()-1;i++){
                    for (int j=i+1;j<shoppingCart.size();j++){
                        Product t=null;
                        if (shoppingCart.get(i).getAvgRating()>shoppingCart.get(j).getAvgRating()){
                            t=shoppingCart.get(j);
                            shoppingCart.set(j,shoppingCart.get(i));
                            shoppingCart.set(i,t);
                        }
                        if (shoppingCart.get(i).getAvgRating()==shoppingCart.get(j).getAvgRating()){
                            if (shoppingCart.get(i).getId()>shoppingCart.get(j).getId()){
                                t=shoppingCart.get(j);
                                shoppingCart.set(j,shoppingCart.get(i));
                                shoppingCart.set(i,t);
                            }
                        }
                    }
                }
                for (int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            case Price:
                for (int i=0;i<shoppingCart.size()-1;i++){
                    for (int j=i+1;j<shoppingCart.size();j++){
                        Product t=null;
                        if (shoppingCart.get(i).getPrice()>shoppingCart.get(j).getPrice()){
                            t=shoppingCart.get(j);
                            shoppingCart.set(j,shoppingCart.get(i));
                            shoppingCart.set(i,t);
                        }
                        if (shoppingCart.get(i).getPrice()==shoppingCart.get(j).getPrice()){
                            if (shoppingCart.get(i).getId()>shoppingCart.get(j).getId()){
                                t=shoppingCart.get(j);
                                shoppingCart.set(j,shoppingCart.get(i));
                                shoppingCart.set(i,t);
                            }
                        }
                    }
                }
                for (int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
        }

    }

    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet+= product.getPrice();
            store.setIncome(store.getIncome()- product.getPrice());
            store.addProduct(product);
            return true;
        }
        else {
            return false;
        }
    }
}
