            import org.w3c.dom.html.HTMLParagraphElement;

            import java.util.ArrayList;
            import java.util.Comparator;
            import java.util.HashMap;

            public class Customer {
                private static int cnt = 0;
                private int id;
                private String name;
                private ArrayList<Product> shoppingCart;
                private float wallet;
                HashMap<Product, Store> hashMap = new HashMap<>();

                //constructor
                public Customer(String name, float wallet) {
                    this.name = name;
                    this.wallet = wallet;
                    cnt++;
                    id = cnt;
                    shoppingCart = new ArrayList<>();
                }
                //setters and getters

                public static int getCnt() {
                    return cnt;
                }

                public static void setCnt(int cnt) {
                    Customer.cnt = cnt;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public ArrayList<Product> getShoppingCart() {
                    return shoppingCart;
                }

                public void setShoppingCart(ArrayList<Product> shoppingCart) {
                    this.shoppingCart = shoppingCart;
                }

                public float getWallet() {
                    return wallet;
                }

                public void setWallet(float wallet) {
                    this.wallet = wallet;
                }

                //methods
                //rateproduct method
                public boolean rateProduct(Product product, int rating) {
                    return product.setRating(rating);
                }

                //updatewallet method
                public void updateWallet(float amount) {
                    this.wallet += amount;
                }

                //purchaseproduct method
                public boolean purchaseProduct(Store store, Product product) {

                    if (store.getProductList().contains(product) && this.wallet >= product.getPrice()) {
                        shoppingCart.add(product);
                        setWallet(getWallet() - product.getPrice());
                        store.setIncome(store.getIncome() + product.getPrice());
                        store.removeProduct(product);
                        hashMap.put(product, store);
                        return true;
                    } else {
                        return false;
                    }
                }
                //viewshoppingcart method
                /*public void viewShoppingCart(SortBy sortMethod){
                    Product firstintherest;
                    ArrayList<Product> shoppingCartcopy = new ArrayList<>();
                    if (sortMethod.toString().equals("PurchaseTime")){
                        for(int i = 0 ; i <= shoppingCart.size() ; i++){
                            firstintherest = shoppingCart.get(i);
                            System.out.printf("Product ID %s, %s, RMB %.2f, Rating %.1f" , firstintherest.getId() , firstintherest.getName() , firstintherest.getPrice() , firstintherest.getAvgRating());
                            System.out.println();
                        }
                    }
                    else if (sortMethod.toString().equals("Rating")){
                        shoppingCartcopy = shoppingCart.clone();
                    }
                }*/
                //refundproduct method
                /*public boolean refundProduct(Product product){

                }*/

                public void viewShoppingCart(SortBy sortMethod) {
                    if (sortMethod == SortBy.PurchaseTime) {

                    } else if (sortMethod == SortBy.Price) {
            //            shoppingCart.sort(new Comparator<Product>() {
            //                @Override
            //                public int compare(Product o1, Product o2) {
            //                    return (int) (o1.getPrice()- o2.getPrice());
            //                }
            //            });
                        for (int i = 0; i < shoppingCart.size() - 1; i++) {
                            for (int j = 0; j < shoppingCart.size() - i - 1; j++) {
                                if (shoppingCart.get(j).getPrice() - shoppingCart.get(j + 1).getPrice() > 0f) {
                                    Product tmp = shoppingCart.get(j);
                                    shoppingCart.set(j, shoppingCart.get(j + 1));
                                    shoppingCart.set(j + 1, tmp);
                                }
                            }
                        }
                    } else if (sortMethod == SortBy.Rating) {
            //            shoppingCart.sort(new Comparator<Product>() {
            //                @Override
            //                public int compare(Product o1, Product o2) {
            //                    return (int) (o1.getAvgRating()-o2.getAvgRating());
            //                }
            //            });
                        for (int i = 0; i < shoppingCart.size() - 1; i++) {
                            for (int j = 0; j < shoppingCart.size() - i - 1; j++) {
                                if (shoppingCart.get(j).getAvgRating() - shoppingCart.get(j + 1).getAvgRating() > 0f ) {
                                    Product tmp = shoppingCart.get(j);
                                    shoppingCart.set(j, shoppingCart.get(j + 1));
                                    shoppingCart.set(j + 1, tmp);
                                }
                            }
                        }
                    }

                    for (int i = 0; i < shoppingCart.size(); i++) {
                        System.out.println(shoppingCart.get(i).toString());
                    }
                }

                public boolean refundProduct(Product product) {
                    if (shoppingCart.contains(product)) {
                        shoppingCart.remove(product);
                        setWallet(getWallet() + product.getPrice());
                        hashMap.get(product).transact(product, 1);
                        return true;
                    } else {
                        return false;
                    }


                }
            }
