package mao.gui.dong.expressEngin.aviator;

import com.alibaba.fastjson.JSON;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/4/26 下午4:58
 */
public class AviatorTest {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(1, 1);
        hash.put(1, 2);
        hash.put(1, 3);
        hash.put(1, 4);
        hash.put(1, 5);
        hash.put(1, 6);
        hash.put(1, 7);
        hash.put(1, 8);
        hash.put(1, 9);
        hash.put(1, 10);
        hash.put(1, 11);
        hash.put(1, 12);
        hash.put(1, 13);
    }

    private static void functionTest() {
        String express="doSome";
        AviatorEvaluator.addFunction(new MyFunction());
        Expression compile = AviatorEvaluator.compile(express,true);
        System.out.println(compile.execute());
    }

    private static void aviatorDemo1() {
        String triggerCondition="'express':'',data:''";
        JSON.parseObject(triggerCondition);

        String express="if(hasMaterial&&hasMaterial){true}else{false}";
        HashMap<String, Object> envs = new HashMap<>();
        envs.put("hasMaterial", true);
        envs.put("hasMaterial", false);
        if((boolean)AviatorEvaluator.execute(express,envs)){
            System.out.println("条件达到");
            return;
        }
        System.out.println("条件不满足");
    }
}

class MyFunction extends AbstractFunction{
    @Override
    public AviatorObject call() throws Exception {
        System.out.println("doSome");
        return super.call();
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
        System.out.println("doSome1");
       return null;
    }

    @Override
    public AviatorObject call(Map<String, Object> env) {
        System.out.println("doSome");
        return super.call(env);
    }

    /**
     * Get the function name
     *
     * @return
     */
    @Override
    public String getName() {
        return "doSome";
    }
}

class MyFunction2 extends AbstractFunction{
    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
        System.out.println("dosome2");
        return super.call(env, arg1);
    }

    /**
     * Get the function name
     *
     * @return
     */
    @Override
    public String getName() {
        return "doSome";
    }
}
