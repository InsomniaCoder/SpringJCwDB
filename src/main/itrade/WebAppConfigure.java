package main.itrade;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by tanatlokejaroenlarb on 3/31/2016 AD.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "main.itrade.controllers")
public class WebAppConfigure {

         @Bean
         public InternalResourceViewResolver viewResolver() {
             InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
             viewResolver.setViewClass(JstlView.class);
             viewResolver.setPrefix("/WEB-INF/");
             viewResolver.setSuffix(".jsp");
             return viewResolver;
         }

    }
