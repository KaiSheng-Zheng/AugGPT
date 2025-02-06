import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private static int purchaseTime;

    public Customer(String name, float wallet) {
        shoppingCart = new ArrayList<>();
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            wallet -= product.getPrice();
            shoppingCart.add(product);
            product.setSoldTime(++purchaseTime);
            store.transact(product,0);
            return true;
        }return false;
    }

    /**
     * The following BubbleSort method is writing by myself but under the teaching from GaoQi, @BeijingShangXueTang.
     */
    public void viewShoppingCart(SortBy sortMethod){
        Product temp;
        boolean flag = true;
        switch (sortMethod){
            case PurchaseTime:
//                for (int i = 0 ; i < shoppingCart.size() ; i++){
//                    for (int j = 0 ; j < shoppingCart.size()-1-i ; j++){
//                        if (shoppingCart.get(j).getSoldTime() > shoppingCart.get(j+1).getSoldTime()){
//                            temp = shoppingCart.get(j);
//                            shoppingCart.set(j, shoppingCart.get(j+1));
//                            shoppingCart.set(j+1, temp);
//                            flag = false;
//                        }
//                    }
//                    if (flag){
//                        break;
//                    }else{
//                        flag = true;
//                    }
//                }
                for (Product temp1 : shoppingCart) System.out.println(temp1); // Finally, print out.
                break;

            case Price:
                for (int i = 0 ; i < shoppingCart.size() ; i++){
                    for (int j = 0 ; j < shoppingCart.size()-1-i ; j++){
                        if (shoppingCart.get(j).getPrice() > shoppingCart.get(j+1).getPrice()){
                            temp = shoppingCart.get(j);
                            shoppingCart.set(j, shoppingCart.get(j+1));
                            shoppingCart.set(j+1, temp);
                            flag = false;
                        }else if (shoppingCart.get(j).getPrice() == shoppingCart.get(j+1).getPrice()){
                            if (shoppingCart.get(j).getSoldTime() > shoppingCart.get(j+1).getSoldTime()){
                                temp = shoppingCart.get(j);
                                shoppingCart.set(j, shoppingCart.get(j+1));
                                shoppingCart.set(j+1, temp);
                                flag = false;
                            }
                        }
                    }
                    if (flag){
                        break;
                    }else{
                        flag = true;
                    }
                }
                for (Product temp1 : shoppingCart) System.out.println(temp1); // Finally, print out.
                break;

            case Rating:
                for (int i = 0 ; i < shoppingCart.size() ; i++){
                    for (int j = 0 ; j < shoppingCart.size()-1-i ; j++){
                        if (shoppingCart.get(j).getAvgRating() > shoppingCart.get(j+1).getAvgRating()){
                            temp = shoppingCart.get(j);
                            shoppingCart.set(j, shoppingCart.get(j+1));
                            shoppingCart.set(j+1, temp);
                            flag = false;
                        }else if (shoppingCart.get(j).getAvgRating() == shoppingCart.get(j+1).getAvgRating()){
                            if (shoppingCart.get(j).getSoldTime() > shoppingCart.get(j+1).getSoldTime()){
                                temp = shoppingCart.get(j);
                                shoppingCart.set(j, shoppingCart.get(j+1));
                                shoppingCart.set(j+1, temp);
                                flag = false;
                            }
                        }
                    }
                    if (flag){
                        break;
                    }else{
                        flag = true;
                    }
                }
                for (Product temp1 : shoppingCart) System.out.println(temp1); // Finally, print out.
                break;

        }

    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet += product.getPrice();
            product.getStore().transact(product, 1);
            return true;
        }
        return false;
    }
}
