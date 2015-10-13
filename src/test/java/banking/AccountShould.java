package banking;

import org.junit.Test;

import java.math.BigDecimal;

import static org.fest.assertions.Assertions.assertThat;


/**
 *
 */
public class AccountShould {

    Account account;

    @Test
    public void provide_current_balance() {
        account = new Account(BigDecimal.valueOf(1000));

        assertThat(account.balance()).isEqualTo(BigDecimal.valueOf(1000));
    }

    @Test
    public void mutate_balance() {
        account = new Account(BigDecimal.valueOf(1000));


        account.mutate(BigDecimal.valueOf(-100));

        assertThat(account.balance()).isEqualTo(BigDecimal.valueOf(900));
    }

}