package com.dhruv.employee_management.scope;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ScopeExperiment implements CommandLineRunner {

    private final FirstBean firstBean;
    private final SecondBean secondBean;

    public ScopeExperiment(FirstBean firstBean, SecondBean secondBean) {
        this.firstBean = firstBean;
        this.secondBean = secondBean;
    }

    @Override
    public void run(String... args) {
        System.out.println("\n========== OBSERVING SPRING BEAN SCOPES ==========");
        System.out.println("Executing ScopeExperiment Runner...");
        
        System.out.println("\n[Singleton Demo]");
        System.out.println("FirstBean's SingletonDemo hash:  " + firstBean.getSingletonDemo().hashCode());
        System.out.println("SecondBean's SingletonDemo hash: " + secondBean.getSingletonDemo().hashCode());
        System.out.println("Result: " + (firstBean.getSingletonDemo() == secondBean.getSingletonDemo() ? "Singleton -> SAME instance" : "DIFFERENT instances"));

        System.out.println("\n[Prototype Demo]");
        System.out.println("FirstBean's ScopeDemo hash:      " + firstBean.getScopeDemo().hashCode());
        System.out.println("SecondBean's ScopeDemo hash:     " + secondBean.getScopeDemo().hashCode());
        System.out.println("Result: " + (firstBean.getScopeDemo() == secondBean.getScopeDemo() ? "SAME instance" : "Prototype -> DIFFERENT instances"));
        
        System.out.println("\n==================================================\n");
    }
}

@Component
@Scope("prototype")
class ScopeDemo {
    public ScopeDemo() {
        System.out.println("ScopeDemo (Prototype) instantiated!");
    }
}

@Component
class SingletonDemo {
    public SingletonDemo() {
        System.out.println("SingletonDemo (Singleton) instantiated!");
    }
}

@Component
class FirstBean {
    private final ScopeDemo scopeDemo;
    private final SingletonDemo singletonDemo;

    public FirstBean(ScopeDemo scopeDemo, SingletonDemo singletonDemo) {
        this.scopeDemo = scopeDemo;
        this.singletonDemo = singletonDemo;
    }

    public ScopeDemo getScopeDemo() { return scopeDemo; }
    public SingletonDemo getSingletonDemo() { return singletonDemo; }
}

@Component
class SecondBean {
    private final ScopeDemo scopeDemo;
    private final SingletonDemo singletonDemo;

    public SecondBean(ScopeDemo scopeDemo, SingletonDemo singletonDemo) {
        this.scopeDemo = scopeDemo;
        this.singletonDemo = singletonDemo;
    }

    public ScopeDemo getScopeDemo() { return scopeDemo; }
    public SingletonDemo getSingletonDemo() { return singletonDemo; }
}
