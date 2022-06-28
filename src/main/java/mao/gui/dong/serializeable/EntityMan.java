package mao.gui.dong.serializeable;/**
*@author mgd [maoguidong@standard-robots.com]
*@data 2022/6/27 下午3:41
*/
public class EntityMan {
    private int stAge;
    private String stName;

    public EntityMan(int stAge, String stName) {
        this.stAge = stAge;
        this.stName = stName;
    }

    public int getStAge() {
        return stAge;
    }

    public void setStAge(int stAge) {
        this.stAge = stAge;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }
}
