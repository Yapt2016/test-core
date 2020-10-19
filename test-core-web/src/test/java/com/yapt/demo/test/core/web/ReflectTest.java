package com.yapt.demo.test.core.web;

import com.yapt.demo.test.core.service.api.model.req.Student;
import org.junit.Test;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author hurui
 * @version Id: ReflectTest.java, v 0.1 2020/7/7 16:01 YaphetS Exp $$
 */
public class ReflectTest extends BaseTest{

    /**
     * 获得Class的三种方法
     * 在运行期间，一个类，只有一个Class对象产生，所以打印结果都是true
     */
    @Test
    public void getClassName(){
        try{
            Student student = new Student();
            Class clazz1 = student.getClass();
            System.out.println("第一种通过对象的getClass方法获取");
            System.out.println(clazz1);

            Class clazz2 = Student.class;
            System.out.println("第二种直接获取");
            System.out.println(clazz1 == clazz2);

            Class clazz3 = Class.forName("com.yapt.demo.test.core.service.api.model.req.Student");
            System.out.println("第三种通过类名全路径反射获取");
            System.out.println(clazz1 == clazz3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 反射创建对象两种方式
     */
    @Test
    @SuppressWarnings("all")
    public void newInstance(){
        try{
            Class clazz = Class.forName("com.yapt.demo.test.core.service.api.model.req.Student");
            Student student1 = (Student)clazz.newInstance();
            System.out.println("第一种直接通过类名创建");
            System.out.println(student1);

            Constructor constructor = clazz.getConstructor(String.class,int.class,char.class);
            Student student2 = (Student)constructor.newInstance("菜虚鲲",20,'男');
            System.out.println("第二种直接通过获取想要的构造器来创建");
            System.out.println(student2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 通过反射获取构造方法
     * public Constructor[] getConstructors()：所有"公有的"构造方法
     * public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)
     * public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
     * public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
     */
    @Test
    @SuppressWarnings("all")
    public void getConstructor(){
        try{
            Class clazz = Class.forName("com.yapt.demo.test.core.service.api.model.req.Student");
            Constructor[] constructors1 = clazz.getConstructors();
            System.out.println("获取所有【public】的构造器");
            for(Constructor c : constructors1){
                System.out.println(c);
            }
            System.out.println("********************************************************************");
            Constructor[] constructors2 = clazz.getDeclaredConstructors();
            System.out.println("获取所有类型的构造器");
            for(Constructor c : constructors2){
                System.out.println(c);
            }

            System.out.println("********************************************************************");
            Constructor c1 = clazz.getConstructor(null);
            Student student1 = (Student) c1.newInstance();
            student1.setName("反射测试");
            System.out.println("获取一个【public】的构造器并调用");
            System.out.println(student1);

            System.out.println("********************************************************************");

            Constructor c2 = clazz.getDeclaredConstructor(String.class,int.class,char.class,String.class);
            //私有构造器必须强吻
            c2.setAccessible(true);
            Student student2 = (Student) c2.newInstance("反射测试",18,'A',"shabi");
            System.out.println("获取一个任意类型构造器并调用");
            System.out.println(student2);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *  1.Field[] getFields():获取所有的"公有字段"
     *  2.Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
     *  3.public Field getField(String fieldName):获取某个"公有的"字段；
     *  4.public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
     */
    @Test
    @SuppressWarnings("all")
    public void getField(){
        try {
            Class clazz = Class.forName("com.yapt.demo.test.core.service.api.model.req.Student");
            Field[] fields1 = clazz.getFields();
            System.out.println("获取所有【public】属性");
            for(Field f : fields1){
                System.out.println(f);
            }

            System.out.println("********************************************************************");
            Field[] fields2 = clazz.getDeclaredFields();
            System.out.println("获取所有类型的属性");
            for(Field f : fields2){
                System.out.println(f);
            }

            System.out.println("********************************************************************");
            Object obj = clazz.getConstructor().newInstance();
            Field field1 = clazz.getField("name");
            System.out.println("获取一个【public】属性");
            field1.set(obj,"胡歌");
            Student student1 = (Student)obj;
            System.out.println(student1);

            System.out.println("********************************************************************");
            Field field2 = clazz.getDeclaredField("phone");
            System.out.println("获取一个任意类型的属性");
            //私有属性必须强吻
            field2.setAccessible(true);
            field2.set(obj,"15377130973");
            Student student2 = (Student)obj;
            System.out.println(student2);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 1.public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
     * 2.public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
     * 3.public Method getMethod(String name,Class<?>... parameterTypes):
     * 4.public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
     */
    @Test
    @SuppressWarnings("all")
    public void getMethod(){
        try{
            Class clazz = Class.forName("com.yapt.demo.test.core.service.api.model.req.Student");
            Method[] methods1 = clazz.getMethods();
            System.out.println("获取所有【public】类型的方法,包含了父类的方法也包含Object类");
            for(Method method1 : methods1){
                System.out.println(method1);
            }

            System.out.println("********************************************************************");

            Method[] methods2 = clazz.getDeclaredMethods();
            System.out.println("获取所有类型的方法,不包括继承的");
            for(Method method2 : methods2){
                System.out.println(method2);
            }

            System.out.println("********************************************************************");
            Object obj = clazz.getConstructor().newInstance();
            Method method1 = clazz.getMethod("sleep",String.class);
            method1.invoke(obj,"反射");

            System.out.println("********************************************************************");
            Method method2 = clazz.getDeclaredMethod("work",String.class);
            method2.setAccessible(true);
            method2.invoke(obj,"我TM");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 反射调用main方法
     */
    @Test
    @SuppressWarnings("all")
    public void reflectMain(){
        try{
            Class clazz = Class.forName("com.yapt.demo.test.core.service.api.model.req.Student");
            Method method = clazz.getMethod("main",String[].class);
            method.invoke(null,(Object) new String[]{});
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 通过配置文件读取类名和方法名再进行反射调用
     */
    @Test
    @SuppressWarnings("all")
    public void reflectProperties(){
        try{
            Class clazz = Class.forName(getValueByName("className"));
            Method method = clazz.getDeclaredMethod(getValueByName("methodName"),null);
            method.setAccessible(true);
            method.invoke(clazz.getConstructor().newInstance(),null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String getValueByName(String className) {
        try{
            Properties properties = new Properties();
            FileReader fileReader = new FileReader("D:\\software\\code\\test-core\\test-core-web\\src\\main\\resources\\application.txt");
            properties.load(fileReader);
            fileReader.close();
            return properties.getProperty(className);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过反射越过泛型检查
     * 泛型用在编译期，编译过后泛型擦除（消失掉）。所以是可以通过反射越过泛型检查的
     */
    @Test
    @SuppressWarnings("all")
    public void test(){
        try{
            List<Student> list = new ArrayList<>();
            Student student = new Student("hurui",18,'男');
            list.add(student);
            Class clazz = list.getClass();
            Method method = clazz.getMethod("add",Object.class);
            method.invoke(list,100);
            for(Object obj : list){
                System.out.println(obj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}