package tasks.a0;

import gradingTools.shared.testcases.greeting.GreetingClassRegistry;


public class Main implements GreetingClassRegistry {
    @Override
    public Class<?> getGreetingMain() {
        return  Hello.class;
    }
    public static void main(String args[]){
    }
}
