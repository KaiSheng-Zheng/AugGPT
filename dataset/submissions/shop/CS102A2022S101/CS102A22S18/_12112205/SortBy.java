

enum SortBy {
    PurchaseTime {
        public void getList(int id) {
            Product product;
            for (int j = 0; j < Customer.customers.get(id - 1).getShoppingCartSize(); j++) {
                product = Customer.customers.get(id - 1).getShoppingCart(j);
                System.out.println(product.toString());
            }

        }
    },
    Rating {
        public void getList(int id) {
            float upperBound = 6;
            float lowerBound = -1;

            for (int i = 0; i < Customer.customers.get(id - 1).getShoppingCartSize(); i++) {
                Product product;
                for (int j = 0; j < Customer.customers.get(id - 1).getShoppingCartSize(); j++) {
                    product = Customer.customers.get(id - 1).getShoppingCart(j);
                    if (product.getAvgRating() > lowerBound && product.getAvgRating() <= upperBound) {
                        upperBound = product.getAvgRating();
                    }
                }
                lowerBound = upperBound;

                for (int j = 0; j < Customer.customers.get(id - 1).getShoppingCartSize(); j++) {
                    product = Customer.customers.get(id - 1).getShoppingCart(j);
                    if (product.getAvgRating() == upperBound) {
                        System.out.println(product.toString());
                    }
                }
                upperBound = 6;
            }
        }
    },
    Price {
        public void getList(int id) {
            float upperBound = 10000000;
            float lowerBound = 0;

            for (int i = 0; i < Customer.customers.get(id - 1).getShoppingCartSize(); i++) {
                Product product;
                for (int j = 0; j < Customer.customers.get(id - 1).getShoppingCartSize(); j++) {
                    product = Customer.customers.get(id - 1).getShoppingCart(j);
                    if (product.getPrice() > lowerBound && product.getPrice() <= upperBound) {
                        upperBound = product.getPrice();
                    }
                }
                lowerBound = upperBound;

                for (int j = 0; j < Customer.customers.get(id - 1).getShoppingCartSize(); j++) {
                    product = Customer.customers.get(id - 1).getShoppingCart(j);
                    if (product.getPrice() == upperBound) {
                        System.out.println(product.toString());
                    }
                }
                upperBound = 10000000;
            }
        }
    };

    public abstract void getList(int id);

}
