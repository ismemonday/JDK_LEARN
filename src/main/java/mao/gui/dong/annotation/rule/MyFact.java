package mao.gui.dong.annotation.rule;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/4/26 下午3:33
 */
public class MyFact {
    private String value;

    private String express;

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MyFact(String value) {
        this.value = value;
    }

    public MyFact(String value, String express) {
        this.value = value;
        this.express = express;
    }
}
