package com.quguai.service;

import com.quguai.bean.User;
import com.quguai.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@CacheConfig(cacheNames = "user")                        //抽取所有缓存的名称
@Service
public class UserService {

    @Resource //等同于@Autowired
    UserMapper userMapper;

    @Autowired
    CacheManager cacheManager;

    /**
     * cacheName/value: 指定缓存的名字， 是数组的形式，可以指定多个缓存名字
     * key: 缓存数据使用的key;  默认使用方法参数的值  key-value : 1-方法的返回值
     *          编写SqEl ( #id = #root.args[0] )
     * keyGenerator: key的生成器，可以指定key的生成器组件id
     *              key/keyGenerator: 二选一使用
     * cacheManager： 指定缓存管理器（Redis或者ConcurrentHashMap）和
     * cacheResolver：二选一
     * condition: 制定符合条件才进行缓存 支持spEl
     * unless: 否定缓存，unless=true，返回值不会被缓存，同condition相反
     * sync: 是否使用异步
     *
     * @param id: id
     * @return = asd
     *
     * 1、自动配置类：CacheAutoConfiguration
     * 2、缓存自动配  使用debug模式开启自动配置类那个生效验证
     *      org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
     *      org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration"
     *      org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration"
     *      org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration"
     *      org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration"
     *      org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration"
     *      org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration"
     *      org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration"
     *      org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration"
     *      org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration"
     * 3、默认生效的类
     *  SimpleCacheConfiguration
     * 4、给容器注册了CacheManager:  ConcurrentMapCacheManager
     * 5、可以获取和创建ConcurrentMapCache类型的缓存组件：它的作用是将数据保存到 ConcurrentMap<Object, Object>当中;
     *
     *  运行流程：
     *      1、先去查询Cache(缓存组件)，按照cacheNames进行获取（CacheManager先获取相应的缓存，第一次获取Cache会自动新建）
     *      2、去cache中查找缓存的内容，使用一个key，默认使用方法参数.默认使用SimpleKeyGenerator生成key
     *              SimpleKeyGenerator生成策略：
     *                  如果有没有参数：key = new SimpleKey()
     *                  如果只有一个参数： key = new 参数的值
     *                  如果有多个参数：key = SimpleKey(params) hashCode
     *      3、没有查到缓存就调用目标方法
     *      4、将目标方法返回的结果继续宁缓存
     *
     *  核心：
     *      1）使用CacheManager[ConcurrentMapCacheManager]按照名字得到Cache[ConcurrentMapCache]组件
     *
     * 使用：
     *      key: key = "#root.methodName + '[' + #root.args[0] +']'"
     *      keyGenerator = "myKeyGenerator"
     *      condition: condition = "#id>0"
     *      unless: unless = "#result==null"
     *      sync: 异步属性， 注意unless就不再支持
     */
    @Cacheable(cacheNames = "user")
    public User getUser(Integer id) {
        System.out.println("查询" + id + "号员工");
        return userMapper.getUserById(id);
    }

    /**
     *  key="#result.id"  = key="user.id"
     *  但是cacheable不能使用”#result.id“ 原因就是要求cacheable 时先查在填缓存 而put则是先执行再填充缓存
     */
    @CachePut(cacheNames = "user", key = "#result.id")
    public User updateUser(User user) {
        System.out.println("更新" + user.getId() + "员工");
        int i = userMapper.updateUser(user);
        return user;
    }

    /**
     * allEntries = true 删除所有的user缓存
     * beforeInvocation = true: 缓存的清除是否在方法执行之前（无论是否出现异常都会清楚缓存），默认的话出现异常就不会清除缓存
     * @param id
     */
    @CacheEvict(cacheNames = "user", key = "#id", allEntries = true, beforeInvocation = true)
    public void deleteUser(Integer id) {
        System.out.println("清除缓存");
    }

    @Caching(
            cacheable = {
                    @Cacheable(value = "user", key = "#username")
            },
            put = {
                    @CachePut(value = "user", key = "#result.id"),
                    @CachePut(value = "user", key = "#result.password")
            }
    )
    public User getUserByUsername(String username) {
        User userByUsername = userMapper.getUserByUsername(username);
        System.out.println(userByUsername);
        return userByUsername;
    }

    // 编码的方式指定
    public User getUser2(Integer id) {
        System.out.println("查询" + id + "号员工");
        Cache cache = cacheManager.getCache("user");
        cache.put("dept:1", userMapper.getUserById(id));
        return userMapper.getUserById(id);

    }
}
