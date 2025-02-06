import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private float wallet;
    private ArrayList<Product> shoppingCart = new ArrayList<>();


    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }


    public boolean rateProduct(Product product, int rating){
        if(rating>=1&&rating<=5){
            product.getRatings().add(rating);
            return true;
        }
        else
            return false;
    }

    public void updateWallet(float amount){
        wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        int flag = 0;
        for(int i=0;i<store.getProductList().size();i++){
            if(store.getProductList().get(i).getId()==product.getId())
                flag++;
        }
        if(product.getPrice()<=wallet&&flag>0){
            wallet-=product.getPrice();
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }
        else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        Product[] list = new Product[shoppingCart.size()];
        for(int i=0;i<shoppingCart.size();i++){
            list[i] = shoppingCart.get(i);
        }
        switch (sortMethod){
            case Price:
                for(int i=0;i<shoppingCart.size()-1;i++){
                    for(int j=0;j<shoppingCart.size()-1;j++){
                        Product temp;
                        if(list[j].getPrice()>list[j+1].getPrice()){
                            temp = list[j];
                            list[j] = list[j+1];
                            list[j+1] = temp;
                        }
                    }
                }
                for(int i=0;i<list.length;i++){
                    System.out.println(list[i].toString());
                }
                break;
            case Rating:
                for(int i=0;i<shoppingCart.size()-1;i++){
                    for(int j=0;j<shoppingCart.size()-1-i;j++){
                        Product temp;
                        if(list[j].getAvgRating()>list[j+1].getAvgRating()){
                            temp = list[j];
                            list[j] = list[j+1];
                            list[j+1] = temp;
                        }
                    }
                }
                for(int i=0;i<list.length;i++){
                    System.out.println(list[i].toString());
                }
                break;
            case PurchaseTime:
                for(int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        return true;
    }
}
