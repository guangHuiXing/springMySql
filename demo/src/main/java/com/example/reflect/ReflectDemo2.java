package com.example.reflect;

import com.example.entity.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by XGH on 2019/4/11
 */
public class ReflectDemo2 {

    public static void main(String[] args) throws Exception{
        Class studentClass2 = Class.forName("com.example.reflect.Student");
        Student s =null;
        Object o = studentClass2.newInstance();
        if (o instanceof Student) {
            s = (Student) o;
        }
        System.out.println(s);

        Field[] declaredFields = studentClass2.getDeclaredFields();
        System.out.println(declaredFields.length);
        for (Field f:declaredFields) {
            System.out.println(f.getName());
        }
        Field name = studentClass2.getDeclaredField("name");
        System.out.println(name);

        Method[] declaredMethods = studentClass2.getDeclaredMethods();
        Method setName = studentClass2.getDeclaredMethod("setName",String.class);
        setName.invoke(s,"xgh");
        System.out.println(s.getName());


        Method say = studentClass2.getDeclaredMethod("say",String.class);
        say.setAccessible(true);
        say.invoke(s, "helloworld");
    }
}
