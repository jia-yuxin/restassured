package test2;

import org.junit.*;


public class test4 {

    @BeforeClass
    public static void beforecla(){
        System.out.println("this is beforeclass");
    }

    @Before
    public void before(){
        System.out.println("this is  before");
    }

    @Test
    public void fun1(){
        System.out.println("this is fun1");
    }

    @Test
    public void fun2(){
        System.out.println("this is fun2");
    }

    @After
    public void after(){
        System.out.println("this is after");
    }

    @AfterClass
    public static void afterclass(){
        System.out.println("this is afterclass");
    }
}
