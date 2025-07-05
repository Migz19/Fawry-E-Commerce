import java.util.ArrayList;

public class Cart {
    private static final double RATE_PER_KG = 10.0;
    private ArrayList<CartItem> cartItems;
    private double totalPrice = 0;
    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public void addItem(Product product,
                        int quantity) {
        if (product != null && product.isInStock() && quantity > 0) {

            CartItem cartItem = new CartItem(product, quantity);
            cartItems.add(cartItem);
        }
    }
    public double totalPackageWeight() {
        double total = 0;
        for (CartItem item : cartItems) {
            Product p = item.getProduct();
            if (p.isShippable()) {
                total += p.getShippableWeight() * item.getQuantity();
            }
        }
        return total;
    }
    public void removeProduct(CartItem cartItem) {
        cartItems.remove(cartItem);
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.price();
        }
        return total;
    }

    public ArrayList<CartItem> getItems() {
        return new ArrayList<>(cartItems);
    }
    public double getShippingFees() {
        double fees = 0;
        for (CartItem item : cartItems) {
            Product p = item.getProduct();
            if (p.isShippable()) {
                double weight = 0;
                try {
                    weight = p.getShippableWeight();
                } catch (Exception ignored) {

                    continue;
                }
                fees += weight * item.getQuantity() * RATE_PER_KG;
            }
        }
        return fees;
    }

}
