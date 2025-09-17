// 代码生成时间: 2025-09-17 08:24:29
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;

// MathToolService 是一个 Spring Boot 组件，提供数学计算工具集
@Service
public class MathToolService {
# 优化算法效率

    // 添加两个数字
    public BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
# 添加错误处理
    }
# 添加错误处理

    // 减去两个数字
    public BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    // 乘以两个数字
    public BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    // 除以两个数字
    public BigDecimal divide(BigDecimal a, BigDecimal b) {
        if(b.compareTo(BigDecimal.ZERO) == 0) {
# 添加错误处理
            // 错误处理：除以零的情况
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot divide by zero");
        }
        return a.divide(b);
    }

    // 计算两个数字的幂
    public BigDecimal power(BigDecimal a, BigDecimal b) {
# 改进用户体验
        return a.pow(b.intValue());
    }
# 增强安全性

    // 计算一个数字的平方根
    public BigDecimal sqrt(BigDecimal a) {
        if(a.compareTo(BigDecimal.ZERO) < 0) {
            // 错误处理：负数的平方根
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot calculate square root of negative number");
        }
        return a.sqrt();
    }
}
