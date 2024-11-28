package org.example.demoscope.prototype;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrototypeScopeExample {

    @Autowired
    private PrototypeBean prototypeBean;

    @Autowired
    private PrototypeBean prototypeBean2;

    public void demonstrateScope(){
        System.out.println("prototypeBean hashcode " + prototypeBean.hashCode());
        System.out.println("prototypeBean2 hashcode " + prototypeBean2.hashCode());
    }


}
