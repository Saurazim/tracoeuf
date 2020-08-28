package com.blanchard.ovobio.tracoeuf.configuration;

import com.blanchard.ovobio.tracoeuf.constantes.Constantes;
import com.blanchard.ovobio.tracoeuf.util.ConstantesUtil;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * TODO pour le moment, ces méthodes ne marchent pas et renvoient un null pointer
 * exception faite de la création du cache manager
 */
@Configuration
@EnableCaching
@EnableScheduling
public class CacheService extends CachingConfigurerSupport {
    private static final String CRON = ConstantesUtil.getProperty(Constantes.CACHE_EVICT_CRON);
    private static final String cron = "0 0 * * * ?";

    /**
     * init du cache manager caffeine
     * @return ccm
     */
    @Bean
    @Primary
    public CacheManager CaffeineCacheManager() {
        CaffeineCacheManager ccm = new CaffeineCacheManager();
        return ccm;
    }

    /**
     * vide le cache d'une valeur dont la clé est fournie
     * @param cacheName nom du cache concerné
     * @param cacheKey clé à supprimer
     */
    public void evictSingleCacheValue(String cacheName, String cacheKey){
        CaffeineCacheManager().getCache(cacheName).evict(cacheKey);
    }

    /**
     * vide tout le cache
     * @param cacheName cache concerné
     */
    public void evictAllCacheValues(String cacheName){
        cacheManager().getCache(cacheName).clear();
    }

    /**
     * vide tous les caches
     */
    public void evictAllCaches(){
        CaffeineCacheManager().getCacheNames().stream()
                .forEach(cacheName -> cacheManager().getCache(cacheName).clear());
    }

//    @Scheduled(cron = cron)
//    public void evictAllCachesAtIntervals(){
//        evictAllCaches();
//    }

    /**
     * visualise le contenu d'un cache
     * @param cacheName cache concerné
     * @return json du cache
     */
    public Object seeCache(String cacheName){
        return cacheManager().getCache(cacheName).getNativeCache();
    }
}
