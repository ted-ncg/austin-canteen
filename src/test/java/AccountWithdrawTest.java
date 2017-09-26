import com.visa.ncg.canteen.Account;
import com.visa.ncg.canteen.InsufficientBalanceException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountWithdrawTest {

    @Test
    public void withdraw3DollarsFromActHaving7DollarsResultIn4(){

        Account account = new Account();
        account.deposit(7);
        try {
            account.withdraw(3);
        } catch (InsufficientBalanceException e) {
            e.printStackTrace();
        }

        assertThat(account.balance())
                .isEqualTo(4);
    }

    @Test
    public void checkThatBalanceStaysAt0WhenWithdrawingFrom0Account(){

        Account account = new Account();

        assertThatThrownBy(() -> { account.withdraw(12); })
                .isInstanceOf(InsufficientBalanceException.class);
    }

    @Test
    public void withdrawInvalidAmt() throws InsufficientBalanceException {

        Account account = new Account();
        account.deposit(10);
        assertThatThrownBy(() -> { account.withdraw(-12); })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void withdraw4DollarsResultInException() throws InsufficientBalanceException {

        Account account = new Account();

        account.deposit(3);

        assertThatThrownBy(() -> { account.withdraw(4); })
                .isInstanceOf(InsufficientBalanceException.class);
    }

}
