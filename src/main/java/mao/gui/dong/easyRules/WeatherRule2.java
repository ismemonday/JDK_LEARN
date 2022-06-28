package mao.gui.dong.easyRules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/4/25 下午2:26
 */
@Rule(name = "weather rule2",description = "if it rain then take an umbrella")
public class WeatherRule2 {



    @Condition
    public boolean itSun(@Fact("rain") boolean rain){
       return rain;
    }

    @Action
    public void takeAnUmbrella(){
        System.out.println("is rain take an umbrella2");
    }

    @Action
    public void doNothing(){
        System.out.println("太阳出来啦2");
    }
}
