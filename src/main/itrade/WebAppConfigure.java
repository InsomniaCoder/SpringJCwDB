package main.itrade;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "main.itrade.controllers")
public class WebAppConfigure {
}
