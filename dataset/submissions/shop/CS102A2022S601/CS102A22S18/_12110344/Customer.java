import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Customer {

    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name,float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
        shoppingCart=new ArrayList<>();
    }

    public boolean rateProduct(Product product,int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store,Product product){
            if(store.hasProduct(product)&wallet>=product.getPrice()){
                    updateWallet((-1) * product.getPrice());
                    store.transact(product, 0);
                    product.setStore(store);
                    shoppingCart.add(product);
                    return true;
            }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for(int i=0;i<shoppingCart.size();i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            case Rating:
                Product[] pr=new Product[shoppingCart.size()];
                for(int i=0;i< pr.length;i++){
                    pr[i]=shoppingCart.get(i);
                }
                Arrays.sort(pr,new sr());
                for (int i=0;i<pr.length;i++){
                    System.out.println(pr[i].toString());
                }
                break;
            case Price:
                Product[] pp=new Product[shoppingCart.size()];
                for(int i=0;i< pp.length;i++){
                    pp[i]=shoppingCart.get(i);
                }
                Arrays.sort(pp,new sp());
                for (int i=0;i<pp.length;i++){
                    System.out.println(pp[i].toString());
                }
                break;

        }
    }


    public boolean refundProduct(Product product){
        for(int i=0;i<shoppingCart.size();i++){
            if(shoppingCart.get(i).getId()==product.getId()){
                updateWallet(product.getPrice());
                shoppingCart.remove(product);
                product.getStore().transact(product,1);
                product.setStore(null);
                return true;
            }
        }
        return false;
    }

    private class sr implements Comparator<Product> {
        @Override
        public int compare(Product product1, Product product2){
            return product1.getAvgRating()>=product2.getAvgRating()?1:-1;
        }
    }
    private class sp implements Comparator<Product> {
        @Override
        public int compare(Product product1, Product product2){
            return product1.getPrice()>=product2.getPrice()?1:-1;
        }
    }
}