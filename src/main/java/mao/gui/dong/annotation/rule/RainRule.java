package mao.gui.dong.annotation.rule;

import mao.gui.dong.annotation.MyAction;
import mao.gui.dong.annotation.MyCondition;
import mao.gui.dong.annotation.Rule;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/4/26 下午3:24
 */
@Rule(name = "下雨的规则",description = "下雨时提示撑伞")
public class RainRule {

    @MyCondition()
    private boolean condition(MyFact fact){
        SpelExpression spelExpression = new SpelExpressionParser().parseRaw(fact.getExpress());
        return spelExpression.compileExpression();
    }

    @MyAction(order=1)
    private void actions1(){
        System.out.println("执行动作1");
    }

    @MyAction(order=2)
    private void actions2(){
        System.out.println("执行动作2");
    }

    private void actions3(){
        System.out.println("执行动作3");
    }
}
