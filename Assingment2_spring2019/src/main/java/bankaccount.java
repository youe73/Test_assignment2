public class bankaccount {

    public double calculateYearlyInterest(Account account)
    {
        if (account.balance>=0 && account.balance<=100 )
        {
            account.interest=3;
        }
        else if (account.balance>100 && account.balance<1000)
        {
            account.interest=5;
        }
        else if(account.balance>=1000)
        {
            account.interest=7;
        }
        else
        {
            account.interest =0;
        }
        return account.interest;
    }
}
