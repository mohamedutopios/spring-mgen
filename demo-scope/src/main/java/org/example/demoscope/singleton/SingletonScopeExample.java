package org.example.demoscope.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingletonScopeExample {

    @Autowired
    private SingletonBean singletonBean;

    @Autowired
    private SingletonBean singletonBean2;

    public void demonstrateScope(){
        System.out.println("singletonBean hashcode " + singletonBean.hashCode());
        System.out.println("singletonBean2 hashcode " + singletonBean2.hashCode());
    }

}
