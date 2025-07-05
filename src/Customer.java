public class Customer {

    private String name;
    private double balance;
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }
    public void addToCart(Product product,
                          int quantity) {
        if (product != null && product.isInStock()) {
            cart.addItem(product,quantity);
        }else {
            System.out.println("Product is not available or out of stock.");
        }
    }
    public void checkout(){
        if (cart.getTotalPrice() <= balance) {
            balance -= cart.getTotalPrice();
            System.out.println("Checkout successful! Remaining balance: " + balance);

        } else {
            System.out.println("Insufficient balance for checkout. Please add funds.");
        }
        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty. Please add products before checking out.");
        } else {
            System.out.println("Products in your cart: " + cart.getItems().toString());
        }
    }
}
