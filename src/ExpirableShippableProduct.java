public class ExpirableShippableProduct extends ExpirableProduct implements IShippableProduct{
    double weight;
    public ExpirableShippableProduct(int id,String name, double price, int quantity, int expirationPeriod,double weight) {
        super(id, name, price, quantity, expirationPeriod);


        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
