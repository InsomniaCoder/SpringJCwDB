package main.itrade.controllers.parent;

import com.google.gson.Gson;
import main.itrade.controllers.HttpHelper;
import main.itrade.data.entities.Company;
import main.itrade.data.entities.User;
import main.itrade.data.repositories.CompanyRepository;
import main.itrade.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@RestController(value = "/")
public class ParentController {

    private static Gson gson = new Gson();

    @Autowired
    CompanyRepository companyRepository;


    @RequestMapping(value = "/childCompany", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> createChildCompany(@RequestBody String companyInfo, HttpServletRequest request) {



        if( ! HttpHelper.sessionIsExist(request) ){
              return (new ResponseEntity<>("session not found", HttpHelper.buildHeader(), HttpStatus.OK));
        }

        HttpSession session = request.getSession();

        User currentUser = (User) session.getAttribute("currentUser");
        Company parentCompany = currentUser.getCompany();
        //TODO  check authorization
        Company creatingChild = gson.fromJson(companyInfo, Company.class);
        parentCompany.getChildren().add(creatingChild);
        companyRepository.save(parentCompany);
        Company createdChild = companyRepository.findByCode(creatingChild.getCode());
        return (new ResponseEntity<>(gson.toJson(createdChild), HttpHelper.buildHeader(), HttpStatus.OK));
    }






}
