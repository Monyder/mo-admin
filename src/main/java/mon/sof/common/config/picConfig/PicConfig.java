package mon.sof.common.config.picConfig;

import mon.sof.common.tool.ConPath;
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
     * 文件访问映射配置地址
     * 2019年5月20日17:06:19
     * zhangxiaomei
     * @param registry
     */
    @Override
     public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(ConPath.PIC_UPLOAD).addResourceLocations("file:"+ConPath.PIC_PATH);
    }

}
