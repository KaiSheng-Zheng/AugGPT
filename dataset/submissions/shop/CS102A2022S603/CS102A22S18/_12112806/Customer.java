// package Exer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Customer {
    //attribute
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    //constructor
    public Customer(String name, float wallet) {
        this.id = ++cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart=new ArrayList<>();
    }

    //method
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) == true && wallet >= product.getPrice()){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            this.shoppingCart.add(product);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case Price:{
                Product[] productTemp = new Product[shoppingCart.size()];
                for(int i = 0;i < shoppingCart.size();i++){
                    productTemp[i] = shoppingCart.get(i);
                }
                Arrays.sort(productTemp, new SortByPrice());
                for(int i = 0;i < productTemp.length;i++){
                    System.out.println(productTemp[i].toString());
                }
                break;
            }
            case Rating:{
                Product[] productTemp = new Product[shoppingCart.size()];
                for(int i = 0;i < shoppingCart.size();i++){
                    productTemp[i] = shoppingCart.get(i);
                }
                Arrays.sort(productTemp, new SortByRating());
                for(int i = 0;i < productTemp.length;i++){
                    System.out.println(productTemp[i].toString());
                }
                break;
            }
            case PurchaseTime: {
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
            }
        }
    }

    private class SortByRating implements Comparator<Product> {
        @Override
        public int compare(Product p1,Product p2){
            return p2.getAvgRating()<=p1.getAvgRating()?1:-1;
        }
    }
    private class SortByPrice implements Comparator<Product>{
        @Override
        public int compare(Product p1,Product p2){
            return p2.getPrice()<=p1.getPrice()?1:-1;
        }
    }
}
