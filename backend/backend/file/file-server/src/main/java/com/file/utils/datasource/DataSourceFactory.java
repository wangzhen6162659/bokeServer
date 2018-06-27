package com.file.utils.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

/**
 * Mysql工厂工具类
 *
 * @author brook
 */
public final class DataSourceFactory {

    private DataSourceFactory() {
    }

    /**
     * 创建 DruidDataSource 实例
     *
     * @return
     */
    public static DruidDataSource createDataSource(DataSourceProperties properties) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setInitialSize(2);
        dataSource.setMinIdle(2);
        dataSource.setMaxActive(properties.getMaxActive());
        dataSource.setMaxWait(60000);

        dataSource.setTimeBetweenEvictionRunsMillis(3600000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("select current_timestamp()");// #SQL查询,用来验证从连接池取出的连接
        dataSource.setTestWhileIdle(true);//  #指明连接是否被空闲连接回收器(如果有)进行检验，如果检测失败，则连接将被从池中去除
        dataSource.setTimeBetweenEvictionRunsMillis(300000);//#在空闲连接回收器线程运行期间休眠的时间值,以毫秒为单位，一般比minEvictableIdleTimeMillis小
        dataSource.setNumTestsPerEvictionRun(properties.getMaxActive()); //在每次空闲连接回收器线程(如果有)运行时检查的连接数量，最好和maxActive一致
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMinEvictableIdleTimeMillis(1000*60*60);//#连接池中连接，在时间段内一直空闲，被逐出连接池的时间(1000*60*60)，以毫秒为单位
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        try {
            dataSource.setFilters("config");
        } catch (Exception e) {
            e.printStackTrace();
        }
        dataSource.setConnectionProperties("config.decrypt=true");
        return dataSource;
    }


    /**
     * 根据指定的DataSource创建SqlSessionFactoryBean
     *
     * @param rdsDataSource
     * @param resourceLocationPatterns
     * @return
     */
    public static SqlSessionFactoryBean createSqlSessionFactoryBean(DataSource rdsDataSource,
                                                                    String[] resourceLocationPatterns) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(rdsDataSource);

        Properties properties = new Properties();
        properties.put("helperDialect", "mysql");
        properties.put("reasonable", "true");

        PageInterceptor pi = new PageInterceptor();
        pi.setProperties(properties);
        sessionFactory.setPlugins(new Interceptor[]{pi});

        if (!Objects.isNull(resourceLocationPatterns) && resourceLocationPatterns.length > 0) {
            Resource[] all = new Resource[]{};
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            for (String locationPattern : resourceLocationPatterns) {
                all = ArrayUtils.addAll(all, resolver.getResources(locationPattern));
            }
            sessionFactory.setMapperLocations(all);
        }

        return sessionFactory;
    }

}
