package com.latihan.AspectOrientedProgramming.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class LoggingAspect {

//    @Before("execution(public String com.latihan.AspectOrientedProgramming.model.Circle.getName())")
//    public void loggingAdvice(){
//        System.out.println("Advice Run. get Method Called");
//    }

    // Specify wildcard
//    @Before("allGetters() && allCircleMethods()")
//    public void loggingAdvice(){
//        System.out.println("Advice Run. get Method Called");
//    }

//    @Before("allGetters()")
//    public void loggingAdvice(JoinPoint joinPoint){
////        System.out.println(joinPoint.toString());
//        System.out.println(joinPoint.getTarget());
//    }

//    @Before("args(String)")
//    public void stringArgumentMethods(){
//        System.out.println("A method that takes String arguments has been called ");
//    }

//    @Before("args(name)")
//    public void stringArgumentMethods(String name){
//        System.out.println("A method that takes String arguments has been called. The value is : " + name);
//    }

    // After Annotation ==> after the method (another annotation : @AfterReturning , @AfterThrowing)
    @After("args(name)")
    public void stringArgumentMethods(String name){
        System.out.println("A method that takes String arguments has been called. The value is : " + name);
    }

    @AfterReturning(pointcut = "args(name)", returning = "returnString")
    public void stringArgumentMethods(String name, String returnString){
        System.out.println("A method that takes String arguments has been called. The value is : " + name + " the output value is " + returnString);
    }

    @AfterThrowing(pointcut = "args(name)", throwing = "ex")
    public  void exceptionAdvice(String name, Exception ex){
        System.out.println("An exception has been thrown " + ex);
    }

    // Around Annotation
//    @Around("allGetters()")
//    public Object myAroundAdvice (ProceedingJoinPoint proceedingJoinPoint){
//        Object returnValue = null;
//        try {
//            System.out.println("Before advice");
//            returnValue = proceedingJoinPoint.proceed();
//            System.out.println("After Advice");
//        }catch (Throwable e){
//            System.out.println("After throwing");
//        }
//        System.out.println("After Finally");
//
//        return returnValue;
//    }

    @Around("@annotation(com.latihan.AspectOrientedProgramming.aspect.Loggable)")
    public Object myAroundAdvice (ProceedingJoinPoint proceedingJoinPoint){
        Object returnValue = null;
        try {
            System.out.println("Before advice");
            returnValue = proceedingJoinPoint.proceed();
            System.out.println("After Advice");
        }catch (Throwable e){
            System.out.println("After throwing");
        }
        System.out.println("After Finally");

        return returnValue;
    }

//    @Before("allGetters()")
//    public void secondAdvice(){
//        System.out.println("Second advice executed");
//    }

    //PointCut Expression
    @Pointcut("execution(* get*())")
    public void allGetters() {}

    // Another pointCut expression (within)
    @Pointcut("within(com.latihan.AspectOrientedProgramming.model.Circle)")
    public void allCircleMethods() {}




}
