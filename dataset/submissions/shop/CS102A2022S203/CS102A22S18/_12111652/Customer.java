import java.util.ArrayList;
import java.util.Arrays;

public class Customer {

        private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<>();
        cnt+=1;
        this.id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        int count=0;
for(int i=0;i<store.getProductList().size();i++){
    if(product.getId()==store.getProductList().get(i).getId()&&wallet>=product.getPrice()){
        wallet-=product.getPrice();
        store.setIncome(store.getIncome()+product.getPrice());
        shoppingCart.add(product);
        store.removeProduct(product);
        count++;break;
    }
}
        return count != 0;
    }

    public void viewShoppingCart(SortBy sortMethod){
if(sortMethod.equals(SortBy.PurchaseTime)){
    for (Product product : shoppingCart) {
        System.out.printf("%s\n", product.toString());
    }
}
if(sortMethod.equals(SortBy.Rating)){
        Product temp;
        Product[] shopping=new Product[shoppingCart.size()];
        for(int i=0;i<shoppingCart.size();i++){
            shopping[i]=shoppingCart.get(i);
        }
        for(int i = 0; i < shoppingCart.size(); i++)
        {
            for(int j = i+1; j < shoppingCart.size() - i; j++)
            {
                if(shoppingCart.get(j).getAvgRating() > shoppingCart.get(i).getAvgRating())
                {
                    temp = shoppingCart.get(j);
                    shoppingCart.set(j,shoppingCart.get(i));
                    shoppingCart.set(i,temp);;
                }
            }
        }
    for (Product product : shoppingCart) {
        System.out.printf("%s\n", product.toString());
    }
}
        if(sortMethod.equals(SortBy.Price)){
            Product temp;
            Product[] shopping=new Product[shoppingCart.size()];
            for(int i=0;i<shoppingCart.size();i++){
                shopping[i]=shoppingCart.get(i);
            }
            for(int i = 1; i < shoppingCart.size(); i++)
            {
                for(int j = 0; j < shoppingCart.size() - i; j++)
                {
                    if(shoppingCart.get(j).getPrice() > shoppingCart.get(j+1).getPrice()){
                        temp = shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j+1,temp);;
                    }
                }
            }
            for (Product product : shoppingCart) {
                System.out.printf("%s\n", product.toString());
            }
        }

    }
}
