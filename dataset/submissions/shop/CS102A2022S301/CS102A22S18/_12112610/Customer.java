

import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        this.id = cnt + 1;
        cnt++;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating ==1||rating ==2||rating ==3||rating ==4||rating ==5){
            product.setRating(rating);
            return true;
        }else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        wallet =wallet+ amount ;
    }

    public boolean purchaseProduct(Store store, Product product) {
        for (int i = 0;i<store.getProductList().size();i++){
            if (product.getId() == store.getProductList().get(i).getId()& wallet >= product.getPrice()){
                shoppingCart.add(product);
                store.transact(product,0);
                wallet = wallet - product.getPrice();
                return true;
            }
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> tempList=new ArrayList<>();
        Product temp=new Product();
        for (int i=0;i<shoppingCart.size();i++){
            tempList.add(shoppingCart.get(i));
        }
        if (sortMethod.equals(SortBy.Price)){
           for (int i=0;i<tempList.size();i++){
               for (int j=0;j<tempList.size()-1;j++){
                   if (tempList.get(j).getPrice()>tempList.get(j+1).getPrice()){
temp=tempList.get(j+1);
tempList.set(j+1,tempList.get(j));
                       tempList.set(j,temp);
                   }
               }
           }
        }
       /* if (sortMethod.equals(SortBy.PurchaseTime)){

        }*/
        if (sortMethod.equals(SortBy.Rating)){
            for (int i=0;i<tempList.size();i++){
                for (int j=0;j<tempList.size()-1;j++){
                    if (tempList.get(j).getAvgRating()>tempList.get(j+1).getAvgRating()){
                        temp=tempList.get(j+1);
                        tempList.set(j+1,tempList.get(j));
                        tempList.set(j,temp);
                    }
                }
            }
        }
        for (int i=0;i<tempList.size();i++){
            System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\n",tempList.get(i).pid,tempList.get(i).getName(),tempList.get(i).getPrice(),tempList.get(i).getAvgRating());
        }
    }

    public boolean refundProduct(Product product) {
for (int i=0;i<shoppingCart.size();i++){
    if (shoppingCart.get(i).getId()==product.getId()){
        wallet+=shoppingCart.get(i).getPrice();
       // shoppingCart.get(i).store.addProduct(product);
       //shoppingCart.get(i).store.setIncome(shoppingCart.get(i).store.getIncome()-shoppingCart.get(i).getPrice());
        shoppingCart.remove(i);
        shoppingCart.get(i).store.transact(product,1);
        return true;
    }
}
        return false;
    }


}
