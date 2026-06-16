package platform.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import platform.util.Result;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@RestController
@RequestMapping("/file")

public class FileController {

    // 读取配置文件中的路径，如果没有配置，默认用当前目录下的 upload
    @Value("${file.upload-path:./upload/}")
    private String uploadDir;

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            return Result.error("文件不能为空");
        }

        try {
            // 1. 获取绝对路径（动态识别当前项目在哪，就存到哪里的 upload 文件夹）
            File folder = new File(uploadDir);
            String absolutePath = folder.getAbsolutePath(); // 获取绝对路径

            if (!folder.exists()) {
                folder.mkdirs(); // 自动创建文件夹
            }

            // 2. 生成文件名
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename != null && originalFilename.contains(".")
                    ? originalFilename.substring(originalFilename.lastIndexOf(".")) : ".jpg";
            String newFilename = UUID.randomUUID().toString() + suffix;

            // 3. 物理保存
            File destFile = new File(folder, newFilename);
            Files.copy(file.getInputStream(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // 4. 动态拼接访问 URL
            String scheme = request.getScheme();
            String serverName = request.getServerName();
            int serverPort = request.getServerPort();
            String portSuffix = (serverPort == 80 || serverPort == 443) ? "" : ":" + serverPort;

            // 注意：这里返回的 /files/ 是虚拟映射路径
            String fileUrl = scheme + "://" + serverName + portSuffix + "/files/" + newFilename;

            return Result.success(fileUrl);
        } catch (IOException e) {
            return Result.error("文件保存失败：" + e.getMessage());
        }
    }
}