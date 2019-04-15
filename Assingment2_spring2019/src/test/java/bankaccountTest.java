import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class bankaccountTest {

Account account;
bankaccount bank;

@BeforeEach
void init()
{
    double bal=0.0;
    account = new Account(bal);
    bank = new bankaccount();
    bank.calculateYearlyInterest(account);

    }

    /*Testing the method - on the critical points for the balance amount and evaluate with the expected
    interest rate given the intervals defined in bankaccount class*/

    @Test
    public void testcalculateYearlyInterest()
    {
        account = new Account(100);
        assertEquals(3,bank.calculateYearlyInterest(account));
        account = new Account(101);
        assertEquals(5,bank.calculateYearlyInterest(account));
        account = new Account(999);
        assertEquals(5,bank.calculateYearlyInterest(account));
    }

    /*8 different assertions*/
    /*all 8 assertions will be renamed with the DisplayName name annotations*/
    /*running the tests have verified that the names have been changed as the output is displayed with new names */
    /*Using assumeTrue on the boolean will skip the test if not matching*/
    /*assettimeout has been used for timeout and sleep with threadsleep, it fails as expected because of timeout*/
    /*Lambda expression have been used with ()-> statement*/
    /*Assertall() is used with the Lambda expression for the 8 assertions*/
    /*@Disabled has been used and verified that the test has been skipped*/


    @Test
    @Disabled
    @DisplayName("testing not null")
    public void notNull()
    {
        boolean booleanvalue = true;
        assumeTrue(booleanvalue);
        assertNotNull(bank.calculateYearlyInterest(account),"testing value not null");
        assertNotNull(bank.calculateYearlyInterest(account),()-> "testing value not null");
        //assertNotNull(bank.calculateYearlyInterest(account),()-> { System.out.println("testing value not null"); });
        assertTimeout(Duration.ofMillis(5), () -> {
                    Thread.sleep(8000);
                });

    }

    @Test
    @Disabled
    @DisplayName("amount zero")
    public void withZero()
    {
        boolean booleanvalue = false;
        assumeTrue(booleanvalue);
        assertEquals(3,bank.calculateYearlyInterest(account),"testing interestvalue with zero amount");
        assertEquals(3,bank.calculateYearlyInterest(account),()->"testing interestvalue with zero amount");
        assertTimeout(Duration.ofMillis(5), () -> {
            Thread.sleep(8000);
        });
    }

    @Test
    @Disabled
    @DisplayName("testing is equal")
    public void isequal()
    {
        boolean booleanvalue = true;
        assumeTrue(booleanvalue);
        double newinterestrate = 3.0;
        assertEquals(newinterestrate,bank.calculateYearlyInterest(account),"testing new value amount");
        assertEquals(newinterestrate,bank.calculateYearlyInterest(account),()->"testing new value amount " +
                newinterestrate);
        assertTimeout(Duration.ofMillis(5), () -> {
            Thread.sleep(8000);
        });
    }


    @Test
    @Disabled
    @DisplayName("testing if still equal")
    public void isstillequal()
    {
        boolean booleanvalue = true;
        assumeTrue(booleanvalue);
        account = new Account(1000);
        double newinterestrate = 7.0;
        assertEquals(newinterestrate,bank.calculateYearlyInterest(account),"testing value is still equal");
        assertEquals(newinterestrate,bank.calculateYearlyInterest(account),()->"testing value is still equal to" + newinterestrate);
        assertTimeout(Duration.ofMillis(5), () -> {
            Thread.sleep(8000);
        });
    }

    @Test
    @Disabled
    @DisplayName("testing not equal")
    public void notequal()
    {
        boolean booleanvalue = true;
        assumeTrue(booleanvalue);
        account = new Account(999);
        double newinterestrate = 7.0;
        assertNotEquals(newinterestrate,bank.calculateYearlyInterest(account),"testing value is not equal");
        assertNotEquals(newinterestrate,bank.calculateYearlyInterest(account),()->"testing value is not equal");
        assertTimeout(Duration.ofMillis(5), () -> {
            Thread.sleep(8000);
        });
    }

    @Test
    @Disabled
    @DisplayName("testing that the object is not the same")
    public void isnotsame()
    {
        boolean booleanvalue = false;
        assumeTrue(booleanvalue);
        account = new Account(999);
        Account newaccount = new Account(999);
        assertNotSame (account,newaccount,"testing object is not the same");
        assertNotSame (account,newaccount,()->"testing object is not the same");
        assertTimeout(Duration.ofMillis(5), () -> {
            Thread.sleep(8000);
        });
    }


    @Test
    @Disabled
    @DisplayName("testing if true")
    public void istrue()
    {
        boolean booleanvalue = true;
        assumeTrue(booleanvalue);
        account = new Account(999);
        assertTrue(bank.calculateYearlyInterest(account)==5.0,"testing object is not the same");
        assertTrue(bank.calculateYearlyInterest(account)==5.0,()->"testing object is not the same");
        assertTimeout(Duration.ofMillis(5), () -> {
            Thread.sleep(8000);
        });
    }

    @Test
    @Disabled
    @DisplayName("testing if false")
    public void isfalse()
    {
        boolean booleanvalue = true;
        assumeTrue(booleanvalue);
        account = new Account(1000);
        assertFalse(bank.calculateYearlyInterest(account)==5.0,"testing object is not the same");
        assertFalse(bank.calculateYearlyInterest(account)==5.0,()->"testing object is not the same");
        assertTimeout(Duration.ofMillis(5), () -> {
            Thread.sleep(8000);
        });
    }

    @Test
    @DisplayName("Assertall")
    public void allassert()
    {
        account = new Account(1000);

        assertAll(

        ()-> assertNotNull(bank.calculateYearlyInterest(account)),
        ()->assertEquals(7.0,bank.calculateYearlyInterest(account)),
        ()->assertEquals(7.0,bank.calculateYearlyInterest(account),"testing new value amount "),
        ()-> assertEquals(7.0,bank.calculateYearlyInterest(account),"testing value is still equal to" + 7.0),
        ()-> assertNotEquals(5.0,bank.calculateYearlyInterest(account),"testing value is not equal"),
        ()->assertNotSame (account,999,"testing object is not the same"),
        ()-> assertTrue(bank.calculateYearlyInterest(account)==7.0,"testing object is not the same"),
        ()-> assertFalse(bank.calculateYearlyInterest(account)==5.0,"testing object is not the same")

        );
    }


}
