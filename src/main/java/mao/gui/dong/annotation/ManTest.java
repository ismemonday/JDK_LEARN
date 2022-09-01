package mao.gui.dong.annotation;

import mao.gui.dong.annotation.rule.MyFact;
import mao.gui.dong.annotation.rule.RainRule;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/1/12 下午5:41
 */
@Person(role = "good")
public class ManTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
      //new ManTest().testRule();
    }

    private void testRule() throws InvocationTargetException, IllegalAccessException {
        //定义规则
        RainRule rainRule = new RainRule();
        //创建事实
        MyFact rain = new MyFact("{'rain':true}","${rain}");
        //导入事实触发规则
        fireRule(rain,rainRule);
    }

    /*这就是规则引擎真正做的内容*/
    private void fireRule(MyFact rain, RainRule rainRule) throws InvocationTargetException, IllegalAccessException {
        //校验规则(必须要有一个@Rule注解,一个返回boolean的方法,和多个actions)
        Class<? extends RainRule> clazz = rainRule.getClass();
        Method conditionMethod=null;
        List<Method> actionMethods=new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            MyCondition annotation = method.getAnnotation(MyCondition.class);
            MyAction action = method.getAnnotation(MyAction.class);
            if(annotation!=null){
                conditionMethod=method;
                break;
            }
            if(action!=null){
                actionMethods.add(method);
                continue;
            }
        }
        conditionMethod.setAccessible(true);
        if((boolean)conditionMethod.invoke(rainRule, rain)){
            for (Method actionMethod : actionMethods) {
                actionMethod.setAccessible(true);
                actionMethod.invoke(rainRule, 1);
            }
        }


    }

    private void doSome() {
        Person annotation = this.getClass().getAnnotation(Person.class);
        String role = annotation.role();
        System.out.println(role);
    }
}
