public class ShippableProduct extends  Product implements IShippableProduct{
    private double weight;


    public ShippableProduct(int id, String name, double price, int quantity, double weight) {
        super(id, name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
