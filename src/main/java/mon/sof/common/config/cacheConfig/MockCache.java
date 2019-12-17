package mon.sof.common.config.cacheConfig;

import mon.sof.common.cache.MockRedisCacheImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockCache {
    @Bean(value = "mockRedisCache")
    public MockRedisCacheImpl mockRedisCache(){
        MockRedisCacheImpl mockRedisCache = new MockRedisCacheImpl();
        return mockRedisCache;
    }
}
