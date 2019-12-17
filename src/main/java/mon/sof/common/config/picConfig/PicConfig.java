package mon.sof.common.config.picConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 文件访问配置类
 */
@Configuration
public class PicConfig implements WebMvcConfigurer {

    /**
     * 访问目录
     */
    @Value("${myConfig.AccessDirectory}")
    private String AccessDirectory;

    /**
     * 映射地址
     */
    @Value("${myConfig.MappingUrl}")
    private String MappingUrl;

    /**
     * 文件访问映射配置地址
     * 2019年5月20日17:06:19
     * zhangxiaomei
     * @param registry
     */
    @Override
     public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(AccessDirectory).addResourceLocations("file:"+MappingUrl);
    }

}
