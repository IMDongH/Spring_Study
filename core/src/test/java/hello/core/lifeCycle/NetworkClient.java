package hello.core.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient{

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = "+ url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작할 때 호출
    public void connect(){
        System.out.println("connect : "+ url);
    }
    public void call(String message){
        System.out.println("call : " + url + " message : " + message);
    }

    //서비스 종료 시 호출
    public void disconnect(){
        System.out.println("close : "+ url);
    }

//    //의존관계 주입이 끝난 후 실행하겠다
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//    //bean 이 종료될 때 실행된다.
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }

    //의존관계 주입이 끝난 후 실행하겠다
    @PostConstruct //코드를 고칠 수 없는 외부 라이브러리에는 사용 X
    public void init() throws Exception {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
}

    //bean 이 종료될 때 실행된다.
    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
