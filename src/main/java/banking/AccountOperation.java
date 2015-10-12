package banking;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 */
public class AccountOperation {
    private Date date;
    private BigDecimal credit;
    private BigDecimal debit;
    private BigDecimal balance;

    public AccountOperation(Date date, BigDecimal credit, BigDecimal debit, BigDecimal balance) {
        this.date = date;
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
