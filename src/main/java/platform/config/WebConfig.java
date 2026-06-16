package platform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.io.File;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${file.upload-path:./upload/}")
    private String uploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 获取 uploadDir 的绝对路径并转换成 Spring 需要的 file: 协议格式
        String path = new File(uploadDir).getAbsolutePath() + File.separator;

        // 确保路径格式正确（Windows系统下需要替换反斜杠）
        if (!path.startsWith("file:")) {
            path = "file:" + path.replace("\\", "/");
        }

        // 将网络访问路径 /files/** 映射到刚才配置的物理目录
        registry.addResourceHandler("/files/**")
                .addResourceLocations(path);
    }

}