/*Create an Abstract class Account with concrete subclasses SavingAccount and
FDAccount.
An account has data members acc no, name, aadharID, balance and functionality
to withdraw(double d), deposit(double d) and transfer_money(Account a,
double d) to other Accounts.
A customer can withdraw money from Saving Account but not from FDAccount, and
money can be transferred between Saving Accounts, Saving Account to FDAccount,
but not from FDAccount to any other accounts.
Design user defined exceptions InsufficientFundsException which will be thrown
by withdraw() and transfer_money(). And
MandatoryFieldsMissingOrInvalidException which can be thrown by the
constructor or data setters.
OperationNotSupportedException thrown by withdraw, transfer.
Demonstrate proper working of code in main with 2 Saving Accounts and 2 Fixed
Accounts.*/


import java.util.Scanner;

abstract class Account {

    long addharno, accno, balance;
    String name;
    boolean sv = true;

    Account(long ad, long acc, String n) {
        addharno = ad;
        accno = acc;
        name = n;
    }

    void DisplayInfo() {
     
        System.out.println("Account holder's name is  -  " + name + "\n account number  - " + accno + "\n addhar number is  -  " + addharno);
        System.out.println(name + "  current balance is  " + balance);
        System.out.print("----------------------------------------------------------\n");
    }

    public abstract void Witdrawl(long wd) throws InsufficientFund, OperationNotAlowed;

    public abstract void Deposit(long dp) throws MandatoryFieldMissingorInvalidException;

    long getBalance() {
        return balance;
    }

    public abstract void TransferMoney(Account a, long money) throws MandatoryFieldMissingorInvalidException, InsufficientFund, OperationNotAlowed;
}

class SavingAccount extends Account {

    public SavingAccount(String n, long addar, long acc, long bal) {
        super(addar, acc, n);
        balance = bal;
        sv = true;
    }

    @Override
    public void Witdrawl(long wd) throws InsufficientFund, OperationNotAlowed {
        try {
            if (wd > balance) {
                throw new InsufficientFund();
            } else {
                balance = balance - wd;
                System.out.println("you have SUCCESSFULLY  witdrawl AMOUNT OF " + wd + "\n now current BALANCE of account number " + accno + " is " + balance);
            }
        } catch (InsufficientFund e) {
            System.out.println("Insufficient Fund in your account");
        } finally {
            System.out.print("----------------------------------------------------------\n");
        }
    }

    @Override
    public void TransferMoney(Account fd, long money) throws InsufficientFund, OperationNotAlowed, MandatoryFieldMissingorInvalidException {
        Witdrawl(money);
        if (money < balance) {
            fd.Deposit(money);
        }
        System.out.println("you have SUCCESSFULLY  transfer the AMOUNT OF " + money + " from of account number " + accno + " to account number " + fd.accno);
        System.out.print("---------------------------------------------------------------------\n");

    }

    @Override
    void DisplayInfo() {
        super.DisplayInfo();

    }

    @Override
    public void Deposit(long dp) {

        balance = balance + dp;
        System.out.println("you have SUCCESSFULLY  deposit AMOUNT OF " + dp + "\n now current BALANCE of account number " + accno + " is " + balance);
        System.out.print("-------------------------------------------------------------------------------------------\n");
    }

}

class FDAccount extends Account {

    public FDAccount(String n, long addar, long acc, long bal) {
        super(addar, acc, n);
        balance = bal;
        sv = false;   
    }

    @Override
    void DisplayInfo() {
        super.DisplayInfo();
      
    }

    @Override
    public void Witdrawl(long wd) throws OperationNotAlowed {
        try {
            if (sv) {
                throw new OperationNotAlowed();
            }
            balance = balance - wd;
            System.out.println("you have SUCCESSFULLY  witdrawl AMOUNT OF " + wd + "\n now current BALANCE of account number " + accno + " is " + balance);
        } catch (OperationNotAlowed e) {
            System.out.println("Insufficient Fund in your account");
        } finally {
            System.out.print("-------------------------------------------------------\n");
        }
    }

    @Override
    public void Deposit(long dp) throws MandatoryFieldMissingorInvalidException {
        balance = balance + dp;
        System.out.println("you have SUCCESSFULLY  deposit AMOUNT OF " + dp + "\n now current BALANCE of account number " + accno + " is " + balance);
        System.out.print("--------------------------------------------------------\n");

    }

    @Override
    public void TransferMoney(Account a, long money) throws MandatoryFieldMissingorInvalidException, InsufficientFund, OperationNotAlowed {
        try {
            throw new OperationNotAlowed();
        } finally {
            System.out.print("--------------------------------------------------\n");
        }
    }

}

public class Main {

    public static void main(String[] args) throws MandatoryFieldMissingorInvalidException, InsufficientFund, OperationNotAlowed, practical5.InsufficientFund, practical5.OperationNotAlowed, practical5.MandatoryFieldMissingorInvalidException {
        SavingAccount s1 = new SavingAccount("Amit", (long) 323232323, (long) 55555, (long) 10000);
        SavingAccount s2 = new SavingAccount("Ajay", (long) 1124524455, (long) 77777, (long) 20000);

        FDAccount fd1 = new FDAccount("Rahul", (long) 78889900, (long) 88888, (long) 30000);
        FDAccount fd2 = new FDAccount("Akash", (long) 745289789, (long) 99999, (long) 40000);
        s1.DisplayInfo();
        s2.DisplayInfo();
        fd1.DisplayInfo();
         fd2.DisplayInfo();
           s1.Witdrawl(5000);
            s2.Witdrawl(5000);
           fd1.Witdrawl(5000);
    fd2.Witdrawl(5000);
      s1.TransferMoney(s2, 5000);
       s1.TransferMoney(fd1, 5000);
        //fd1.TransferMoney(s2, 5000);
        s1.Deposit(5000);
         fd1.Deposit(5000);
        
    } 
        
        

      

}

class MandatoryFieldMissingorInvalidException extends Exception {

    MandatoryFieldMissingorInvalidException() {
        System.out.println("INVALID FIELD INSERTED");
    }
}

class InsufficientFund extends Exception {

    InsufficientFund() {
        System.out.println("Not Enough Money .");
    }
}

class OperationNotAlowed extends Exception {

    OperationNotAlowed() {
        System.out.println("Operation Not Alowed.");
    }
}
