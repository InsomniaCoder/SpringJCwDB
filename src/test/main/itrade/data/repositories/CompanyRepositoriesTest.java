package test.main.itrade.data.repositories;

import main.itrade.ApplicationConfigure;
import main.itrade.data.entities.Company;
import main.itrade.data.entities.User;
import main.itrade.data.repositories.CompanyRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by tanatlokejaroenlarb on 4/1/2016 AD.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfigure.class})
public class CompanyRepositoriesTest {

    @Autowired
    CompanyRepository companyRepository;

    @Test
    public void testParentShouldHaveChildAndChildShouldHaveParent() {

        Company foundParentCompany = companyRepository.findByCode("1001");
        Assert.assertNotNull("Not found company from parent id", foundParentCompany);

        Company foundChildren = companyRepository.findByCode("1002");
        Assert.assertNotNull("Not found  company from child id",foundChildren);

        Assert.assertEquals("company name is incorrect", "CHINA_SYSTEMS",foundParentCompany.getName());

        Assert.assertEquals("children number found is incorrect", 1 ,foundParentCompany.getChildren().size());

        Assert.assertEquals("Child company's code is incorrect", "1002",foundChildren.getCode());

        Assert.assertEquals("Child company's name is incorrect", "ITOS_CORPORATION",foundChildren.getName());

        Assert.assertEquals("Actual parent and parent of child company are not the same", foundParentCompany.getId(), foundChildren.getParent().getId());

        Assert.assertEquals("Actual child and child of parent company are not the same",foundParentCompany.getChildren().get(0).getId(),foundChildren.getId());
    }

    @Test
    public void saveChildByParentShouldPersisChild(){

        Company foundParentCompany = companyRepository.findByCode("1001");
        Assert.assertNotNull("Not found company from parent id", foundParentCompany);

        Company childCompany = new Company();
        childCompany.setCode("xxx");
        childCompany.setName("testChild");

        foundParentCompany.getChildren().add(childCompany);

        companyRepository.save(foundParentCompany);

        Company retrievedChild = companyRepository.findByCode("xxx");
        Assert.assertNotNull("Not found child after persist by parent", retrievedChild);
    }




}
