package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClientTest implements InitializingBean, DisposableBean {
    
    private String url;

    public NetworkClientTest() {
        System.out.println("클라이언트 생성 : " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public void disconnect(){
        System.out.println("close : " +url);
    }
    
    public void connect(){
        System.out.println("connect : " + url);
    }
    
    public void call(){
        System.out.println("url : " + url + "connect : " + "호출");
    }
    

    @Override
    public void destroy() throws Exception {
        disconnect();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call();
    }
}
