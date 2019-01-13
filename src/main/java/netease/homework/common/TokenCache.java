package netease.homework.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Author SMJ
 * 用于保存token
 */
public class TokenCache {
    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);
    //构造token缓存
    private static LoadingCache<String,String> localCache =
            CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).
                    expireAfterAccess(12, TimeUnit.HOURS).build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    return "null";
                }
            });

    /**
     * 存入用户和对应的token
     * @param key 键
     * @param value 值
     */
    public static void setKey(String key,String value){
        localCache.put(key,value);
    }

    /**
     * 获得某个token
     * @param key
     * @return
     */
    public static String getValue(String key){
        String value = null;
        try {
            value = localCache.get(key);
            if ("null".equals(value)){
                return null;
            }
            return value;
        } catch (ExecutionException e) {
            logger.error("localCache get error");
        }
        return null;
    }

}
