package com.blanchard.ovobio.tracoeuf.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
    @Autowired
    CacheService cacheService;
/**
 * création de end point pour méthodes de cache
 */
//    @GetMapping("clearAllCaches")
//    public void clearAllCaches(){
//        cacheService.evictAllCaches();
//    }
//
//    @GetMapping("cache/{cacheName}")
//    public Object seeCache(String cacheName){
//        return cacheService.seeCache(cacheName);
//    }
}
