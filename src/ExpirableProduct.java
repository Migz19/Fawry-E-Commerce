public class ExpirableProduct implements IExpirable {
    private int expirationPeriod;

    public ExpirableProduct(int expirationPeriod) {

         setExpirationPeriod(expirationPeriod);
    }

    @Override
    public int getExpirationPeriod() {
        return expirationPeriod;
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
