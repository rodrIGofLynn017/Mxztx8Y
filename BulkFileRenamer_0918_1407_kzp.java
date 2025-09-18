// 代码生成时间: 2025-09-18 14:07:23
// Spring Boot 组件，用于批量文件重命名
import org.springframework.stereotype.Component;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.ArrayList;

@Component
public class BulkFileRenamer {

    private final ResourceLoader resourceLoader;

    // 自动注入 ResourceLoader
    @Autowired
    public BulkFileRenamer(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    // 批量重命名文件
    public List<String> renameFiles(String directoryPath, List<String> oldNames, List<String> newNames) {
        if (oldNames.size() != newNames.size()) {
            throw new IllegalArgumentException("The number of old and new names must be equal.");
        }

        List<String> renamedFiles = new ArrayList<>();
        for (int i = 0; i < oldNames.size(); i++) {
            String oldName = oldNames.get(i);
            String newName = newNames.get(i);
            String oldFilePath = directoryPath + File.separator + oldName;
            String newFilePath = directoryPath + File.separator + newName;
            try {
                Resource resource = resourceLoader.getResource("file:" + oldFilePath);
                if (!resource.exists()) {
                    throw new IOException("File does not exist: " + oldFilePath);
                }
                Path oldPath = Paths.get(oldFilePath);
                Path newPath = Paths.get(newFilePath);
                Files.move(oldPath, newPath, StandardCopyOption.REPLACE_EXISTING);
                renamedFiles.add(newName);
            } catch (IOException e) {
                e.printStackTrace();
                renamedFiles.add("Error renaming file from " + oldName + " to " + newName + ": " + e.getMessage());
            }
        }
        return renamedFiles;
    }

    // 打印欢迎信息
    @PostConstruct
    public void init() {
        System.out.println("BulkFileRenamer initialized.");
    }
}
