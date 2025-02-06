import java.util.ArrayList;

    public enum SortBy {
        PurchaseTime, Rating, Price;

        public void geCases(Customer a){
            if(this==PurchaseTime){
                for(int i=0;i<a.getShoppingCart().size();i++){
                    System.out.println(a.getShoppingCart().get(i));
                }

            }

            if(this==Rating){
                ArrayList<Product> store=new ArrayList<>(a.getShoppingCart());    //without new is the same direction;
                                                                             // without new can go through 32
                for (int i = 0; i < store.size()-1; i++) {
                    for (int j = 0; j < store.size() - 1 - i; j++) {
                        if (store.get(j).getAvgRating() > store.get(j + 1).getAvgRating()) {
                            Product temp = store.get(j);
                            store.set(j, store.get(j + 1));
                            store.set(j + 1, temp);
                        }
                        /*if(store.get(j).getAvgRating()==store.get(j+1).getAvgRating()){

                        }*/                  //we don't need to care about the time order,it automatically does it
                    }
                }
                for(int i=0;i<store.size();i++){
                    System.out.println(store.get(i));
                }
            }

            if(this==Price){
                ArrayList<Product> store=new ArrayList<>(a.getShoppingCart());
                for (int i = 0; i < store.size()-1; i++) {
                    for (int j = 0; j < store.size() - 1 - i; j++) {
                        if (store.get(j).getPrice() > store.get(j + 1).getPrice()) {
                            Product temp = store.get(j);
                            store.set(j, store.get(j + 1));
                            store.set(j + 1, temp);
                        }
                        /*if(store.get(j).getAvgRating()==store.get(j+1).getAvgRating()){

                        }*/                  //we don't need to care about the time order,it automatically does it
                    }
                }
                for(int i=0;i<store.size();i++){
                    System.out.println(store.get(i));
                }
            }
        }
    }