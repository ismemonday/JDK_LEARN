package mao.gui.dong.easyRules;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/4/25 下午2:26
 */
public class MyRule {
    public static void main(String[] args) {
        //define facts
        Facts facts = new Facts();
        facts.put("rain", true);

        //define rule
        Rules rules = new Rules();
        rules.register(new WeatherRule());
        //rules.register(new WeatherRule2());

        //fire rule
        DefaultRulesEngine defaultRulesEngine = new DefaultRulesEngine();
        defaultRulesEngine.fire(rules, facts);
    }
}
