/*
package mon.sof.common.config.druid;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfig {



    */
/**
     * 连接池登录地址
     * @Author  zhangxiaomei
     * @Date    2019-12-18 10:26:46
     * @Param
     * @Return
     *//*

    @Value("${myConfig.druidUrl}")
    private String druidUrl;


    */
/**
     * 连接池访问白名单
     * @Author  zhangxiaomei
     * @Date    2019-12-18 10:27:00
     * @Param
     * @Return
     *//*

    @Value("${myConfig.allow}")
    private String allow;



    */
/**
     * 连接池访问白名单
     * @Author  zhangxiaomei
     * @Date    2019-12-18 10:27:09
     * @Param
     * @Return
     *//*

    @Value("${myConfig.deny}")
    private String deny;


    */
/**
     * 连接池登录账号
     * @Author  zhangxiaomei
     * @Date    2019-12-18 10:27:19
     * @Param
     * @Return
     *//*

    @Value("${myConfig.loginUsername}")
    private String loginUsername;



    */
/**
     * 连接池登录密码
     * @Author  zhangxiaomei
     * @Date    2019-12-18 10:27:32
     * @Param
     * @Return
     *//*

    @Value("${myConfig.loginPassword}")
    private String loginPassword;



    */
/**
     * 连接池是否能够重置数据
     * @Author  zhangxiaomei
     * @Date    2019-12-18 10:27:40
     * @Param
     * @Return
     *//*

    @Value("${myConfig.resetEnable}")
    private String resetEnable;

    @Bean
    public ServletRegistrationBean registrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet());        //添加初始化参数：initParams
        servletRegistrationBean.addUrlMappings(druidUrl);
        //白名单：
        servletRegistrationBean.addInitParameter("allow", allow);
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny", deny);
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername", loginUsername);
        servletRegistrationBean.addInitParameter("loginPassword", loginPassword);
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", resetEnable);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
*/
