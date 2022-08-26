package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
//대상에 따라 mode를 다르게 해주면 된다.
// 가짜 프록시 클래스를 만들어서 주입시켜준다. provider 주입 시키듯 가짜를 주입
//프록시든 provider든 진짜 객체 조회를
public class MyLogger {

    private String uuid;
    private String requestUrl;

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void log(String message){
        System.out.println("[" + uuid + "]" + "["+requestUrl+"] "+message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request bean scope create: "+this );
    }

    @PreDestroy
    public void close(){
        System.out.println("[" + uuid + "] request bean scope close: "+this );
    }
}
