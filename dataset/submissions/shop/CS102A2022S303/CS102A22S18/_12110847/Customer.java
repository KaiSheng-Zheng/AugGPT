import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;


    public Customer(String name, float wallet){
        id=++cnt;
        this.name=name;
        this.wallet=wallet;
        shoppingCart=new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        if(rating>=1&&rating<=5)
            return product.setRating(rating);
        else
            return false;
    }

    public void updateWallet(float amount){
        wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet-product.getPrice()>=0){
            updateWallet(-product.getPrice());
            store.transact(product,0);
            shoppingCart.add(product);
            return true;
        }
        return false;


    }

    public void viewShoppingCart(SortBy sortMethod){
        List<Product> temp;
        if(sortMethod==SortBy.Rating){
            temp=shoppingCart.stream().sorted(Comparator.comparing(Product::getAvgRating)).collect(Collectors.toList());;
            for (int i=0;i<temp.size();i++)
                System.out.println(temp.get(i));
        }else if(sortMethod==SortBy.Price ){
            temp=shoppingCart.stream().sorted(Comparator.comparing(Product::getPrice)).collect(Collectors.toList());;
            for (int i=0;i<temp.size();i++)
                System.out.println(temp.get(i));
        }else if(sortMethod==SortBy.PurchaseTime ){
            temp=shoppingCart.stream().sorted(Comparator.comparing(Product::getId)).collect(Collectors.toList());;
            for (int i=0;i<temp.size();i++)
                System.out.println(shoppingCart.get(i));
        }

    }

    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            wallet+=product.getPrice();
            //store.transact(product,1);
            return true;
        }
        return false;
    }

}