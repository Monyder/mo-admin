package mon.sof.project.sysLog.advice;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Mapping
public @interface Log {
    String func() default "";
    String remarks() default "";
}
