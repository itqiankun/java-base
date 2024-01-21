package com.itqiankun;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author: ma_qiankun
 * @date: 2023/4/3
 **/
@Slf4j
public class GuavaTest {

    @Test
    public void it_qk() throws Exception {

        Optional<Long> optional = repeatLogCache.getIfPresent("hello");
        System.out.println(optional);

        Optional<Long> optionalTwo = repeatLogCache.get("hello");
        System.out.println(optionalTwo.isPresent());
        System.out.println(optionalTwo.get());

        Optional<Long> optionalThree = repeatLogCache.getIfPresent("hello");
        System.out.println(optionalThree.get());
    }

    public final LoadingCache<String, Optional<Long>> repeatLogCache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(1, TimeUnit.HOURS)
            .build(new CacheLoader<String, Optional<Long>>() {
                @Override
                public Optional<Long> load(String key) {
                    return Optional.of(System.currentTimeMillis());
                }
            });
}
