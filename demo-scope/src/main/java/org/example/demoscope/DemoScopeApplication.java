package org.example.demoscope;


import org.example.demoscope.prototype.PrototypeScopeExample;
import org.example.demoscope.singleton.SingletonScopeExample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoScopeApplication {

    public static void main(String[] args) {

       ApplicationContext context =  SpringApplication.run(DemoScopeApplication.class, args);
       SingletonScopeExample singletonScopeExample = context.getBean(SingletonScopeExample.class);
       singletonScopeExample.demonstrateScope();
        PrototypeScopeExample prototypeScopeExample = context.getBean(PrototypeScopeExample.class);
        prototypeScopeExample.demonstrateScope();
    }

}
