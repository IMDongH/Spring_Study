package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent  {//이게 붙은 놈은 ComponentScan에 추가할것이다 라고 생각하면 된다.
}
