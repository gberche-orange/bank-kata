package banking;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.verify;


/**
 *
 */
public class AccountServiceAT {

    Outputter mockedOutputter = Mockito.mock(Outputter.class);
    AccountService accountService = new AccountService(mockedOutputter);

    @Test
    public void test() {

        //given
        accountService.deposit(BigDecimal.valueOf(1000));
        accountService.withdraw(BigDecimal.valueOf(-100));
        accountService.withdraw(BigDecimal.valueOf(500));
        //when
        accountService.printStatement();

        //then
        String expectedOutput =
                        "      | date       | amount | balance |\n" +
                        "      | 10/04/2014 | 500    | 1400    |\n" +
                        "      | 02/04/2014 | -100   | 900     |\n" +
                        "      | 01/04/2014 | 1000   | 1000    |\n";
        verify(mockedOutputter).println(expectedOutput);

    }

}