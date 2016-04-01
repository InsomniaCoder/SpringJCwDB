package main.itrade;

import main.itrade.beans.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@Configuration
@ComponentScan(basePackages = "main.itrade.beans")
@Import({ PersistenceContext.class})
public class ApplicationConfigure {
}
