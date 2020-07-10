package config;
import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;

@Configuration//给类加这个注解，表明这个类是配置类
/**
 * 扫描service方便自动注入service的实例对象
 */
@ComponentScan("service")
/**
 * 加载配置文件
 */
@PropertySource(value = {"classpath:db.properties"}, ignoreResourceNotFound = true)
/**
 * 自动扫描dao包下的Mapper，然后自动生成代理对象
 */
@MapperScan(basePackages = {"dao"}, sqlSessionFactoryRef = "sqlSessionFactory")
/**
 * 用注解配置一个配置类
 * @author 韦延伦
 * @date 2020/6/24 17:09
 **/
public class ConfigClass {
    @Value("${driver}")
    private String driverClass;

    @Value("${url}")
    private String jdbcUrl;

    @Value("${user}")
    private String user;

    @Value("${password}")
    private String password;

    @Bean
    public DataSource dataSource()  {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClass);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(user);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new org.mybatis.spring.SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactoryBean.setTypeAliasesPackage("dao");
        //指定Mapper.xml文件的路径
        sessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:Mapper/*Mapper.xml"));
        return sessionFactoryBean;
    }
}
