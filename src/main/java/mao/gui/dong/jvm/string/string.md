## 字符串常量池
### intern() 方法解析
```java
  private static boolean result2() {
        String a="good";
        String b="study";
        String s1=a+b;
        String s2="goodstudy";
        return s1.intern()==s1;
    }

    private static boolean result1() {
        String a="good";
        String b="study";
        String s1=a+b;
        return s1.intern()==s1;
    }
```

![](../imgs/string_intern.png)

### String常见面试题
[字符串常见问题(StringBuild和final和+)](./StringLearn.java)