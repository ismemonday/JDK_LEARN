package mao.gui.dong.web.hserver4;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class MyHserver {
    public static void main(String[] args) {
        //字符串常量池
        String s1="hello";
        String s2=new String("hello");
        String s3="he"+"llo";
        String s4="he";
        String s5="llo";
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s2.intern());//true
        System.out.println(s1 == s3);//true
        System.out.println(s1 == s4 + s5);//false
        //自动装箱和拆箱
        Byte b1=25;
        Byte b2=25;
        Character c1=25;
        Character c2=25;
        Character c3=250;
        Character c4=250;
        Short sh1=25;
        Short sh2=25;
        Short sh3=250;
        Short sh4=250;
        Integer a1=26;
        Integer a2=26;
        Integer a3=260;
        Integer a4=260;
        Integer a5=new Integer(26);
        Double d1=20.0;
        Double d2=20.0;
        Float f1=20.0f;
        Float f2=20.0f;
        System.out.println(b1 == b2);//true
        System.out.println(c1 == c2);//true
        System.out.println(c3 == c4);//false
        System.out.println(sh1 == sh2);//true
        System.out.println(sh3 == sh4);//false
        System.out.println(a1 == a2);//true
        System.out.println(a3 == a4);//false
        System.out.println(a1 == a5);//false
        System.out.println(d1 == d2);//false
        System.out.println(f1 == f2);//false
        //Integer运算
        Integer a6=0;
        System.out.println(a4 == a3 + a6);//true
        System.out.println(a4 == new Integer(260));//false
        //
        int[] arr=new int[]{1,2,3};
        System.out.println(arr[-2]);
    }
}
