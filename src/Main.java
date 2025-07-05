public class Main {
    public static void main(String[] args) {

        ExpirableShippableProduct cheese = new ExpirableShippableProduct(
                1324, "Cheese", 100, 30,
                 40,3
        );
        ExpirableShippableProduct biscuits = new ExpirableShippableProduct(
                111, "Biscuits", 30, 20,
                40, 0.35 // 350g per unit
        );
        ShippableProduct tv = new ShippableProduct(
               2222, "TV", 5000, 2,
                15.0 // 15kg
        );
        Product scratchCard = new Product(
              9999, "Scratch Card", 50, 5
        );

        // Initialize customer with balance = 1000
        Customer alice = new Customer(
                 "Alice", 1000.0
        );

        Cart cart = alice.getCart();

        // Add items to cart
        cart.addItem(cheese, 2);      // OK
        cart.addItem(biscuits, 1);    // OK
        cart.addItem(scratchCard, 1); // OK (non-shippable)
        // cart.addItem(biscuits, 100); // would throw: Insufficient stock
        // cart.addItem(biscuits, 0);   // would throw: Quantity must be positive

        // Checkout and print details
        try {
            alice.checkout();
        } catch (IllegalStateException ex) {
            System.err.println("Checkout failed: " + ex.getMessage());
        }
    }
}