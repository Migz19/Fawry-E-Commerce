import java.util.List;

public class Customer {
    private final String name;
    private double balance;
    private final Cart cart = new Cart();

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }

    public void addToCart(Product product, int qty) {
        try {
            cart.addItem(product, qty);
        } catch (RuntimeException ex) {
            System.out.println("Cannot add to cart: " + ex.getMessage());
        }
    }

    public void checkout() {
        if (cart.getItems().isEmpty()) {
            throw new IllegalStateException("Cart is empty. Add products before checkout.");
        }

        for (CartItem ci : cart.getItems()) {
            Product p = ci.getProduct();
            if (!p.isInStock() || p.getQuantity() < ci.getQuantity()) {
                throw new IllegalStateException(p.getName() + " is out of stock at checkout.");
            }
            if (p.isExpired()) {
                throw new IllegalStateException(p.getName() + " has expired.");
            }
        }

        double subtotal = cart.getTotalPrice();
        double shipping = cart.getShippingFees();
        double total = subtotal + shipping;

        if (balance < total) {
            throw new IllegalStateException(
                    "Insufficient balance. Required: " + total + ", Available: " + balance
            );
        }

        balance -= total;

        cart.getItems().forEach(ci -> {
            Product p = ci.getProduct();
            p.setQuantity(p.getQuantity() - ci.getQuantity());
        });

        System.out.println("** Shipment notice **");
        cart.getItems().stream()
                .filter(ci -> ci.getProduct().isShippable())
                .forEach(ci -> {
                    try {
                        double weightKg = ci.getProduct().getShippableWeight();
                        int weightGrams = (int)(weightKg * 1000 * ci.getQuantity());
                        System.out.printf("%dx %s  %dg%n",
                                ci.getQuantity(), ci.getProduct().getName(), weightGrams);
                    } catch (Exception ignored) {}
                });
        System.out.println("----------------------");
        System.out.printf("Total package weight: %.2fkg%n", cart.totalPackageWeight());

        // Print checkout receipt
        System.out.println("\n** Checkout receipt **");
        cart.getItems().forEach(ci -> {
            System.out.printf("%dx %s  %.0f%n",
                    ci.getQuantity(),
                    ci.getProduct().getName(),
                    ci.price());
        });
        System.out.println("----------------------");
        System.out.printf("Subtotal: %.0f%n", subtotal);
        System.out.printf("Shipping: %.0f%n", shipping);
        System.out.printf("Amount: %.0f%n", total);
        System.out.printf("Remaining balance: %.1f%n", balance);


    }
}
