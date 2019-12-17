package mon.sof;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@ComponentScan(basePackages = {"mon.sof.*"}) //扫描bean
@MapperScan(value = {"mon.sof.common.dao","mon.sof.project.**.dao"})
@ServletComponentScan
@EnableTransactionManagement(proxyTargetClass = true)// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication //Spring boot 程序启动注解
public class ProjectApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProjectApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

}
