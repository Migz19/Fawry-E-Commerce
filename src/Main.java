public class Main {
    public static void main(String[] args) {

        Product milk = new Product(
                "Milk",
                10.5,
                3,
                new ShippableProduct("Milk", 1.5),
                new ExpirableProduct(40)
        );
        Product biscuits = new Product(
                "Biscuits", 30, 20,
                new ShippableProduct("Milk", 0.35),
                new ExpirableProduct(40)


        );
        Product tv = new Product(
                "TV", 5000, 2,
                new ShippableProduct("TV", 15.0), null
        );
        Product scratchCard = new Product(
                "Scratch Card", 50, 5, null, null
        );


        Customer alice = new Customer(
                "Ahmed", 1000.0
        );

        Cart cart = alice.getCart();


        cart.addItem(milk, 2);
        cart.addItem(biscuits, 1);
        cart.addItem(scratchCard, 1);
        cart.addItem(tv, 1);

        try {
            alice.checkout();
        } catch (IllegalStateException ex) {
            System.err.println("Checkout failed: " + ex.getMessage());
        }
    }
}