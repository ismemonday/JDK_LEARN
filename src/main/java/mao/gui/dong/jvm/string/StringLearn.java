package mao.gui.dong.jvm.string;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class StringLearn {
    public static void main(String[] args) {
        //finalTest();
        //stringBuildTest();
        //internTest();
        testAdd();
    }

    private static void testAdd() {
        String a="good ";
        String b="study";
        String s1="good "+"study";
        String s2=a+b;
        System.out.println(s1 == s2);//false
    }

    private static void internTest() {
        /**
         * test1
         */
        String str1 = new StringBuilder("计算机").append( "软件" ).toString();
        System.out.println(str1.intern()==str1);//true
        /**
         * test2
         */
        String str2=new StringBuilder("ja").append( "va" ).toString();
        System.out.println(str2.intern()==str2);//false
        /**
         * test3
         */
        String s = new String("爱");
        s.intern();
        String s2 = "爱";
        System.out.println(s == s2);//false


        String s5 = new String("中国") + new String("牛逼");
        String s6 = "中国牛逼";
        System.out.println(s5 == s6);//false

        String s3 = new String("中国") + new String("加油");
        s3.intern();
        String s4 = "中国加油";
        System.out.println(s3 == s4);//true

        String s7=new String("ja")+new String("va");
        String s8="java";
        System.out.println(s7 == s8);

    }

    /**
     * String　build测试
     */
    private static void stringBuildTest() {
        String s1=new StringBuilder("hello").append("world").toString();
        String s2="hello"+"world";
        String s3="helloworld";
        System.out.println(s1 == s2);//false
        System.out.println(s2 == s3);//true
    }


    /**
     * 常量测试
     */
    private static void finalTest() {
        String a="hello";
        final String b="world";
        String c="hello world";
        System.out.println(a + " world" == c);//false
        System.out.println("hello " + b == c);//true
    }
}
