// 代码生成时间: 2025-09-17 21:24:02
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

/**
 * API响应格式化工具
 * 使用Spring Boot响应实体，对API响应进行统一格式化管理。
 */
public class ApiResponseUtil {

    /**
     * 成功响应
     * @param data 响应数据
     * @param <T> 数据类型
     * @return 格式化后的响应实体
     */
    public static <T> ResponseEntity<T> success(T data) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        return ResponseEntity.ok(response);
    }

    /**
     * 错误响应
     * @param message 错误信息
     * @return 格式化后的错误响应实体
     */
    public static ResponseEntity<Map<String, Object>> error(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * 带状态码的错误响应
     * @param message 错误信息
     * @param status 状态码
     * @return 格式化后的错误响应实体
     */
    public static ResponseEntity<Map<String, Object>> error(String message, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        return ResponseEntity.status(status).body(response);
    }
}
