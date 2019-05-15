package com.example.reflect;

import com.example.entity.Student;

/**
 * Created by XGH on 2019/4/11
 */
public class ReflectDemo {
    public static void main(String[] args) throws Exception{

        //方式1
        Class<Student> studentClass1 = Student.class;

        //方式2
        Class studentClass2 = Class.forName("com.example.reflect.Student");
        //方式3
        Student student = new Student();
        Class<? extends Student> studentClass3 = student.getClass();
        System.out.println(studentClass1);
        System.out.println(studentClass2);
        System.out.println(studentClass3);
        //方式4 适用于基本类型的包装类型

        Integer i = 3;
        System.out.println(i.TYPE);
    }
}
