package step_definitions;

import banking.Account;
import banking.AccountOperation;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public class MyStepdefs {

    private Account account = new Account();


    @Given("^a deposit of (\\d+) on (.*)$")
    public void a_deposit_of_on_(BigDecimal amount, String date) throws Throwable {
        account.deposit(amount, null);
    }

    @And("^a withdrawal of (\\d+) on (.*)$")
    public void a_withdrawal_of_on_(BigDecimal amount, String date) throws Throwable {
        account.withdraw(amount, null);
    }

    @When("^printing the bank statement$")
    public void printing_the_bank_statement() throws Throwable {
        List<AccountOperation> ops = account.statements();
    }

    @Then("^client should see:$")
    public void client_should_see(List<OperationSpec> statements) throws Throwable {
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

            if (!date.equals(that.getDate())) return false;
            if (!credit.equals(that.getCredit())) return false;
            if (!debit.equals(that.getDebit())) return false;
            return balance.equals(that.getBalance());

        }

        @Override
        public int hashCode() {
            int result = date.hashCode();
            result = 31 * result + credit.hashCode();
            result = 31 * result + debit.hashCode();
            result = 31 * result + balance.hashCode();
            return result;
        }
    }
}
