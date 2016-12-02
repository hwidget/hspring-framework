package com.ryan.spring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;

import java.lang.reflect.Field;

/**
 *
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/6/30 17:29.
 */
public aspect SimpleAspect {

    public pointcut staticInit(): staticinitialization(com.spring.mvc.aspects.classes.Simple);

    before() : staticInit() {

        System.out.println("[before] ======================  toLongString :" + thisJoinPointStaticPart.toLongString());
        System.out.println("[before] ======================  toShortString :" + thisJoinPointStaticPart.toShortString());

        Signature signature = thisJoinPointStaticPart.getSignature();
        System.out.println("[before] ======================  getModifiers :" + signature.getModifiers());
        System.out.println("[before] ======================  getName :" + signature.getName());
        System.out.println("[before] ======================  getDeclaringType :" + signature.getDeclaringType());
        System.out.println("[before] ======================  getDeclaringTypeName :" + signature.getDeclaringTypeName());


        SourceLocation sourceLocation = thisJoinPointStaticPart.getSourceLocation();
        System.out.println("[before] ======================  getFileName : " + sourceLocation.getFileName());
        System.out.println("[before] ======================  getLine : " + sourceLocation.getLine());
        System.out.println("[before] ======================  getWithinType : " + sourceLocation.getWithinType());

        System.out.println("=================================================================================================");

    }

    after() returning(): staticInit() {
        System.out.println("[before] ======================  toLongString :" + thisJoinPointStaticPart.toLongString());
        System.out.println("[before] ======================  toShortString :" + thisJoinPointStaticPart.toShortString());

        Signature signature = thisJoinPointStaticPart.getSignature();
        System.out.println("[before] ======================  getModifiers :" + signature.getModifiers());
        System.out.println("[before] ======================  getName :" + signature.getName());
        System.out.println("[before] ======================  getDeclaringType :" + signature.getDeclaringType());
        System.out.println("[before] ======================  getDeclaringTypeName :" + signature.getDeclaringTypeName());


        SourceLocation sourceLocation = thisJoinPointStaticPart.getSourceLocation();
        System.out.println("[before] ======================  getFileName : " + sourceLocation.getFileName());
        System.out.println("[before] ======================  getLine : " + sourceLocation.getLine());
        System.out.println("[before] ======================  getWithinType : " + sourceLocation.getWithinType());

        Object o = null;
        try {
             o = signature.getDeclaringType().newInstance();

            Class declaringType = thisJoinPointStaticPart.getSignature().getDeclaringType();
            Field[] fields = declaringType.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(o);

                System.out.println("我拿到Value 了.................." + value);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }




        System.out.println("=================================================================================================");
    }

    before(): call(public com.spring.mvc.aspects.classes..*..new()) {

        System.out.println("[before] ======================  toLongString :" + thisJoinPoint.toLongString());
        System.out.println("[before] ======================  toShortString :" + thisJoinPoint.toShortString());

        Signature signature = thisJoinPoint.getSignature();
        System.out.println("[before] ======================  getModifiers :" + signature.getModifiers());
        System.out.println("[before] ======================  getName :" + signature.getName());
        System.out.println("[before] ======================  getDeclaringType :" + signature.getDeclaringType());
        System.out.println("[before] ======================  getDeclaringTypeName :" + signature.getDeclaringTypeName());


        SourceLocation sourceLocation = thisJoinPoint.getSourceLocation();
        System.out.println("[before] ======================  getFileName : " + sourceLocation.getFileName());
        System.out.println("[before] ======================  getLine : " + sourceLocation.getLine());
        System.out.println("[before] ======================  getWithinType : " + sourceLocation.getWithinType());



        System.out.println("[before]" + thisJoinPoint.getSignature().getName());

//        Object aThis = thisJoinPoint.getThis();
//        System.out.println("[before] ======================  getFileName : " + aThis.toString());

        JoinPoint.StaticPart staticPart = thisJoinPoint.getStaticPart();
        System.out.println("[before] ======================  getFileName : " + staticPart.getSignature().getDeclaringTypeName());


        Object[] args = thisJoinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("拿到了所有输入的参数:" + arg);
        }

        System.out.println("=================================================================================================");
    }

    after(): call(public com.spring.mvc.aspects.classes.*.new()) {
        System.out.println("[after]" + thisJoinPoint.getSignature().getName());
    }

    public pointcut welcomeMethod(String name): call(public String com.spring.mvc.aspects.classes..*.welcome(String)) && args(name);

    before(String name): welcomeMethod(name){
        System.out.println("[before]" + thisJoinPoint.getTarget().getClass().getCanonicalName() + "."
                + thisJoinPoint.getSignature().getName() + " args_name=" + name);
    }

    after(String name) returning(String retval): welcomeMethod(name) {
        System.out.println("[after returning]"
                + thisJoinPoint.getTarget().getClass().getCanonicalName() + "."
                + thisJoinPoint.getSignature().getName() + " args_name=" + name
                + " return_value =" + retval);


        Object[] args = thisJoinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("拿到了所有输入的参数:" + arg);
        }

    }

    after(String name): welcomeMethod(name){
        System.out.println("[after]" + thisJoinPoint.getTarget().getClass().getCanonicalName() + "."
                + thisJoinPoint.getSignature().getName()
                + " args_name=" + name);
    }

    after(String name) throwing(Exception e): welcomeMethod(name){
        System.out.println("[after throwing]" + thisJoinPoint.getTarget().getClass().getCanonicalName() + "."
                + thisJoinPoint.getSignature().getName() + " throwing=" + e.getMessage());
    }

}
