public class ExpirableProduct extends Product {
    private int expirationPeriod;

    public ExpirableProduct(int id, String name, double price, int quantity,
                            int expirationPeriod) {
        super(id, name, price, quantity);
        this.expirationPeriod = expirationPeriod;
    }

    public boolean isExpired() {
        return expirationPeriod <= 0;
    }
    public void setExpirationPeriod(int expirationPeriod) {
        if (expirationPeriod >=0) {
            this.expirationPeriod = expirationPeriod;
        } else {
            this.expirationPeriod = 1;
        }
    }
}
