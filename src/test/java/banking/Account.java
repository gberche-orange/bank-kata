package banking;

import java.math.BigDecimal;

/**
 *
 */
public class Account {
    private BigDecimal balance;

    public Account(BigDecimal initialDeposit) {
        this.balance = initialDeposit;
    }

    public BigDecimal balance() {
        return balance;
    }

    public void mutate(BigDecimal delta) {
        balance = balance.add(delta);

    }
}
