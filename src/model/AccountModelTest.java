package model;

import junit.framework.TestCase;

public class AccountModelTest extends TestCase {

    private AccountModel test_account = new AccountModel("930421", "test name", 10.00, 2);
    public void testValidate() throws Exception {
        boolean value = test_account.validate(1, 1, true);
        assertTrue(value);
    }

    public void testTransact() throws Exception {
        double deposit_amount = 10.0;
        double balance_amount = test_account.getBalance() + deposit_amount;
        test_account.transact(deposit_amount, 1);
        assertEquals(balance_amount, test_account.getBalance(), 0);
    }

}