public class CartItem {
    private Product product;

    private int quantity;

    public CartItem(Product product,  int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
    public double price() {
        return product.getPrice() * quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    @Override
    public String toString() {
        return quantity + "x " + product.getName() + " = " + price();
    }

}
