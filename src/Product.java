public class Product {
    private String name;
    private double price;
    private int quantity;
    private  int id;

    public Product(int id,String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
