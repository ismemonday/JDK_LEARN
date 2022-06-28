package mao.gui.dong.serializeable.alibabaJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;
import mao.gui.dong.serializeable.EntityMan;

/**
*@author mgd [maoguidong@standard-robots.com]
*@data 2022/6/27 下午3:41
*/
public class ManTest {
    public static void main(String[] args) {
        EntityMan liming = new EntityMan(18, "liming");
        SerializeConfig config = SerializeConfig.globalInstance;
        config.setPropertyNamingStrategy(PropertyNamingStrategy.CamelCase);
        System.out.println(JSON.toJSONString(liming));

    }
}
