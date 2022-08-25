package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan (

        //component 를 찾는 시작 위치를 정할 수 있음 없으면 모든 자바코드를 다 뒤지게 되면서 오래걸리게 될 것임
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        //지정하지 않으면 AutoAppConfig가 위치한 패키지가 시작위치가 된다.
        //설정 정보를 최상단에 두는것 - 관례임 -> basePackages를 생략
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
