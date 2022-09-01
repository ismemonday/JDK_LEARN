# juc并发编程
## 并发的发展历程
- ### 硬件层-可见性问题
    ```java

    ```
- ### 操作系统层面-原子性问题
    ```java

    ```
- ### 编译层-有序性问题
    ```java

    ```
  
## [synchronized锁升级过程](https://wiki.openjdk.org/display/HotSpot/Synchronization)
- ## 对象头
- ## 锁类别
- ## 常见问题
    ```text
      - a1 锁可以降级吗?
      - a2 synchronized作用于类上时是什么情况?
      - a3 偏向锁可以重偏向吗?如果可以什么时候会重偏向?(批量重偏向)
      - a4 偏向锁相关的jvm参数有哪些?分别是什么意思(打印所有参数-XX:+PrintFlagsFinal)
      - a5 锁膨胀的条件是什么?
    ```


## java线程池
![](imgs/thread_poll_source.png)

## java锁

