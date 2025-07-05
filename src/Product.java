public class Product {
    private String name;
    private double price;
    private int quantity;


    private IShippableProduct shippable;
    private IExpirable expirable;
    public Product( String name, double price, int quantity,
                   IShippableProduct shippable, IExpirable expirable) {

        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.shippable = shippable;
        this.expirable = expirable;
    }


    public boolean isExpired() {
        if (expirable == null) return false;
        return expirable.isExpired();
    }


    public double getShippableWeight() {
        if (shippable == null)
            throw new UnsupportedOperationException("This product is not shippable.");
        return shippable.getWeight();
    }
    public boolean isShippable() {
        return shippable != null;
    }

    public boolean isExpirable() {
        return expirable != null;
    }

    public String getName() {
        return name;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price> 0) {
            this.price = price;
        } else {
            this.price= 0;
        }

    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity>=0){
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }

    }
    public boolean isInStock() {
        return quantity > 0;
    }
}
