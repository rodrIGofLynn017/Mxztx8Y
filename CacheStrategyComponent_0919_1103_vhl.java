// 代码生成时间: 2025-09-19 11:03:14
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Component
@RestController
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CacheStrategyComponent {

    @Autowired
    private CacheManager cacheManager;

    /**
     * 获取缓存中的数据，如果不存在则调用方法获取数据，并缓存结果
     * @param key 缓存的键
     * @return 缓存的数据
     */
    @GetMapping(