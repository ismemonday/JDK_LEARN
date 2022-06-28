package mao.gui.dong.easyRules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/4/25 下午2:26
 */
@Rule(name = "weather rule",description = "if it rain then take an umbrella")
public class WeatherRule {



    @Condition
    public boolean itSun(@Fact("rain") boolean rain){
       return rain;
    }

    @Action(order = 2)
    public void takeAnUmbrella(){
        System.out.println("is rain take an umbrella");
    }

    @Action(order = 1)
    public void doNothing(){
        System.out.println("太阳出来啦");
    }
}
