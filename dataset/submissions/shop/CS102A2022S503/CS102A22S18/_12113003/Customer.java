import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.UnaryOperator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private int counter=0;

    public Customer(String name, float wallet) {
        this.wallet = wallet;
        this.name = name;
        id = ++cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (wallet >= product.getPrice() && store.hasProduct(product)) {
            wallet -= product.getPrice();
            product.setPurchaseTime(++counter);
            shoppingCart.add(product);
            store.transact(product, 0);
            return true;
        } else {
            return false;
        }
    }


    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod){
            case PurchaseTime:
                quickSort3(shoppingCart,0,shoppingCart.size());
                for(Product product : shoppingCart)
                    System.out.println(product);
                break;
            case Rating:
                quickSort1(shoppingCart,0,shoppingCart.size());
                for(Product product : shoppingCart)
                    System.out.println(product);
                break;
            case Price:
                quickSort2(shoppingCart,0,shoppingCart.size());
                for(Product product : shoppingCart)
                    System.out.println(product);
                break;
        }

    }

    public boolean hasShoppingCart(Product product) {
        boolean flag = false;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (product.equals(shoppingCart.get(i)) ) {
                flag=true;
                break;
            }
        }
        return flag;
    }

    public boolean refundProduct(Product product) {
        if (!hasShoppingCart(product)) {
            return false;
        } else {
            wallet+= product.getPrice();
            shoppingCart.remove(product);
            Store store=product.getBelongStore();
            store.transact(product,1);
            return true;
        }
    }

    public void quickSort1(ArrayList<Product> shoppingCart,int begin,int end){
        float key=shoppingCart.get(begin).getAvgRating();
        int i=begin;
        int j=end;
        while(i<j) {
            while (i < j && shoppingCart.get(j).getAvgRating() > key) {
                j--;
            }
            if (i < j) {
                Collections.swap(shoppingCart, i, j);
                i++;
            }
            while (i < j && shoppingCart.get(i).getAvgRating() < key) {
                i++;
            }
            if (i < j) {
                Collections.swap(shoppingCart, j, i);
                j--;
            }
        }
        Collections.swap(shoppingCart,i,begin);
        quickSort1(shoppingCart,begin,i-1);
        quickSort1(shoppingCart,i+1,end);
    }
    public void quickSort2(ArrayList<Product> shoppingCart,int begin,int end){
        float key=shoppingCart.get(begin).getPrice();
        int i=begin;
        int j=end;
        while(i<j) {
            while (i < j && shoppingCart.get(j).getPrice() > key) {
                j--;
            }
            if (i < j) {
                Collections.swap(shoppingCart, i, j);
                i++;
            }
            while (i < j && shoppingCart.get(i).getPrice() < key) {
                i++;
            }
            if (i < j) {
                Collections.swap(shoppingCart, j, i);
                j--;
            }
        }
        Collections.swap(shoppingCart,i,begin);
        quickSort2(shoppingCart,begin,i-1);
        quickSort2(shoppingCart,i+1,end);
    }
    public void quickSort3(ArrayList<Product> shoppingCart,int begin,int end){
        float key=shoppingCart.get(begin).getPurchaseTime();
        int i=begin;
        int j=end;
        while(i<j) {
            while (i < j && shoppingCart.get(j).getPurchaseTime() > key) {
                j--;
            }
            if (i < j) {
                Collections.swap(shoppingCart, i, j);
                i++;
            }
            while (i < j && shoppingCart.get(i).getPurchaseTime() < key) {
                i++;
            }
            if (i < j) {
                Collections.swap(shoppingCart, j, i);
                j--;
            }
        }
        Collections.swap(shoppingCart,i,begin);
        quickSort2(shoppingCart,begin,i-1);
        quickSort2(shoppingCart,i+1,end);
    }

}
