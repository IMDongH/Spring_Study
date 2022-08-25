package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {//이게 붙은 놈은 ComponentScan에서 제외할것이다 라고 생각하면 된다.
}
