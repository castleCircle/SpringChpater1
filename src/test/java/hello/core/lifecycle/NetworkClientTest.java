package hello.core.lifecycle;

public class NetworkClientTest{
    
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

    public void close(){
        disconnect();
    }

    public void initial(){
        connect();
        call();
    }
}
