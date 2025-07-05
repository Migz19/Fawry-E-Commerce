public class ShippableProduct implements IShippableProduct{
    private double weight;
    private String name;

    public ShippableProduct(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }


    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }
}
