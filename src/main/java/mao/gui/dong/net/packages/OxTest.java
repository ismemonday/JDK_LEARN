package mao.gui.dong.net.packages;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 下午3:05
 */
public class OxTest {
    public static void main(String[] args) {
        System.out.println(Integer.toHexString("P".hashCode()));
        System.out.println(Integer.toHexString("`".hashCode()));
        System.out.println(Integer.toHexString("2".hashCode()));
        System.out.println(Integer.toHexString("3".hashCode()));
        System.out.println(Integer.toHexString("4".hashCode()));
        System.out.println(Integer.toHexString("5".hashCode()));
        System.out.println(Integer.toHexString("6".hashCode()));
        System.out.println(Integer.toHexString("7".hashCode()));
        System.out.println(Integer.toHexString("8".hashCode()));
        System.out.println(Integer.toHexString("9".hashCode()));//39
        System.out.println(Integer.toHexString("g".hashCode()));//67
        System.out.println(Integer.toHexString("G".hashCode()));//47
        String[] strings=new String[]{"50","00","00","ff","ff","03","00","0C","00","0A","00","01","04","00","00","64","00","00","A8","01","00","0A"};
        for (String string : strings) {
            System.out.print((char) Integer.parseInt(string, 16));
            System.out.print(",");
        }

    }
}

