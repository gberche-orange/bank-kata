package step_definitions;

import cucumber.api.PendingException;
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


    @And("^a deposit of (\\d+) on (\\d+)-(\\d+)-(\\d+)$")
    public void a_deposit_of_on_(int arg1, int arg2, int arg3, int arg4) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^a withdrawal of (\\d+) on (\\d+)-(\\d+)-(\\d+)$")
    public void a_withdrawal_of_on_(int arg1, int arg2, int arg3, int arg4) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }



    @When("^printing the bank statement$")
    public void printing_the_bank_statement() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^client should see:$")
    public void client_should_see(List<AccountStatement> statements) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }


    public static class AccountStatement {
        String date;
        BigDecimal credit;
        BigDecimal debit;
        BigDecimal balance;
    }
}
