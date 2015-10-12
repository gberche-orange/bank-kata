package step_definitions;

import banking.Account;
import banking.AccountOperation;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 *
 */
public class MyStepdefs {

    private Account account = new Account();
    private List<AccountOperation> printedOperations;


    @Given("^a deposit of (\\d+) on (.*)$")
    public void a_deposit_of_on_(BigDecimal amount, String date) throws Throwable {
        account.deposit(amount, new Date());
    }

    @And("^a withdrawal of (\\d+) on (.*)$")
    public void a_withdrawal_of_on_(BigDecimal amount, String date) throws Throwable {
        account.withdraw(amount, new Date());
    }

    @When("^printing the bank statement$")
    public void printing_the_bank_statement() throws Throwable {
        printedOperations = account.statements();
    }

    @Then("^client should see:$")
    public void client_should_see(List<OperationSpec> statements) throws Throwable {
        assertThat(printedOperations).isEqualTo(statements);
    }


    public static class OperationSpec {
        String date;
        BigDecimal credit;
        BigDecimal debit;
        BigDecimal balance;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || o instanceof AccountOperation) return false;

            AccountOperation that = (AccountOperation) o;

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            if (!date.equals(dateFormat.format(that.getDate()))) return false;
            if (!credit.equals(that.getCredit())) return false;
            if (!debit.equals(that.getDebit())) return false;
            return balance.equals(that.getBalance());

        }

        @Override
        public int hashCode() {
            int result = date.hashCode();
            result = 31 * result + ((credit != null) ? credit.hashCode() : 0) ;
            result = 31 * result + ((debit != null) ? debit.hashCode(): 0);
            result = 31 * result + balance.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }
}
