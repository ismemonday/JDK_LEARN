#应用层的java原生网络
1.继承关系

  java.net: 
                                                            
    URLConnection <--{HTTPURLConnection,JarURLConnection}
  
  
  
  
  sun.net.www:
  
    java.net.URLConnection<---URLConnection <---{FileURLConnection,FtpURLConnection,JavaRuntimeURLConnection}
    java.net.HTTPURLConnection<---HttpURLConnection
    java.net.JarURLConnection <---JarURLConnection
 
2.应用层原生常用的的协议有:
    
  本地：
  
      jar:      jar:file:/home/maoguidong/.gradle/wrapper/dists/gradle-6.3-bin/8tpu6egwsccjzp10c1jckl0rx/gradle-6.3/lib/gradle-core-6.3.jar!/org/gradle/initialization/converted-types.txt"
      file:     file:/home/maoguidong/.gradle/wrapper/dists/gradle-6.3-bin/8tpu6egwsccjzp10c1jckl0rx/gradle-6.3/lib/gradle-core-6.3.jar
      jrt:      jrt:/java.base/java/lang/System.class
  远程： 
  
    http:       
    https:
    ftp:
    jmod:
    mailto:
    websocket: