public interface IExpirable {
    int getExpirationPeriod();


    boolean isExpired();
}
