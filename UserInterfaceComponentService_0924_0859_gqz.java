// 代码生成时间: 2025-09-24 08:59:44
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class UserInterfaceComponentService {

    private final UserInterfaceComponentRepository repository;

    /**
     * 构造函数注入组件库的存储仓库
     * @param repository 组件库的存储仓库
     */
    @Autowired
    public UserInterfaceComponentService(UserInterfaceComponentRepository repository) {
        this.repository = repository;
    }

    /**
     * 获取所有用户界面组件
     * @return 组件列表
     */
    public List<UserInterfaceComponent> getAllComponents() {
        return repository.findAll();
    }

    /**
     * 通过ID获取用户界面组件
     * @param id 组件ID
     * @return 组件的Optional对象
     */
    public Optional<UserInterfaceComponent> getComponentById(Long id) {
        return repository.findById(id);
    }

    /**
     * 添加用户界面组件
     * @param component 要添加的组件
     * @return 添加的组件
     */
    public UserInterfaceComponent addComponent(UserInterfaceComponent component) {
        return repository.save(component);
    }

    /**
     * 更新用户界面组件
     * @param id 组件ID
     * @param component 更新后的组件
     * @return 更新的组件
     */
    public UserInterfaceComponent updateComponent(Long id, UserInterfaceComponent component) {
        return repository.findById(id).map(comp -> {
            comp.setName(component.getName());
            comp.setDescription(component.getDescription());
            comp.setProperties(component.getProperties());
            return repository.save(comp);
        }).orElseThrow(() -> new ComponentNotFoundException("Component not found with id " + id));
    }

    /**
     * 删除用户界面组件
     * @param id 组件ID
     */
    public void deleteComponent(Long id) {
        repository.deleteById(id);
    }

    // 组件未找到的异常类
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.RestControllerAdvice
    public static class ComponentNotFoundException extends RuntimeException {
        public ComponentNotFoundException(String message) {
            super(message);
        }
    }

    // 组件库的存储仓库接口
    public interface UserInterfaceComponentRepository {
        List<UserInterfaceComponent> findAll();
        Optional<UserInterfaceComponent> findById(Long id);
        UserInterfaceComponent save(UserInterfaceComponent component);
        void deleteById(Long id);
    }
}

/**
 * 用户界面组件实体类
 */
public class UserInterfaceComponent {
    private Long id;
    private String name;
    private String description;
    private String properties;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getProperties() { return properties; }
    public void setProperties(String properties) { this.properties = properties; }
}
