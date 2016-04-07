package test.main.itrade.data.entities;

import main.itrade.data.entities.Bank;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Tanat on 4/7/2016.
 */
public class BankBuilderTest {

    Bank bank;

    @Before
    public void init(){
        System.out.println("init bank");
        bank = new Bank();
    }

    @Test
    public void buildWithOnlyAbbvrShouldEqual(){

        bank.setAbbreviation("TMB");
        Bank bankByBuilder = new Bank.BankBuilder().abbreviation("TMB").build();
        Assert.assertEquals("2 Banks are not equal",bank,bankByBuilder);
    }

    @Test
    public void buildWithOnlyAbbvrAndFullNameShouldEqual(){


        bank.setAbbreviation("TMB");
        bank.setFullName("TMB Bank");

        Bank bankByBuilder = new Bank.BankBuilder()
                .abbreviation("TMB").
                        fullName("TMB Bank").
                        build();

        Assert.assertEquals("2 Banks are not equal",bank,bankByBuilder);
    }

    @Test
    public void buildAllWithBuilderShouldCorrect(){
        bank.setAbbreviation("TMB");
        bank.setFullName("TMB Bank");
        bank.setCountry("TH");

        Bank bankByBuilder = new Bank.BankBuilder()
                .abbreviation("TMB").
                        country("TH").
                        fullName("TMB Bank").
                        build();

        Assert.assertEquals("2 Banks are not equal",bank,bankByBuilder);
    }

    @Test
    public void compareFullBankWithBuilderWithOnlyAbbvrShouldNotEqual(){
        bank.setAbbreviation("TMB");
        bank.setFullName("TMB Bank");
        bank.setCountry("TH");

        Bank bankByBuilder = new Bank.BankBuilder()
                .abbreviation("TMB").
                        build();

        Assert.assertNotEquals("2 Banks are incorrectly equal",bank,bankByBuilder);
    }

}
