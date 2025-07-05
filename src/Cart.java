import java.util.ArrayList;

public class Cart {

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

    public void removeProduct(CartItem cartItem) {
        cartItems.remove(cartItem);
    }

    public double getTotalPrice() {

        for (CartItem cartItem : cartItems) {
            this.totalPrice += cartItem.price();
        }
        return this.totalPrice;
    }

    public ArrayList<CartItem> getItems() {
        return new ArrayList<>(cartItems);
    }

}
