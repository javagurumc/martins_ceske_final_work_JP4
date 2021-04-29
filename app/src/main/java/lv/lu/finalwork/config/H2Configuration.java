package lv.lu.finalwork.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class H2Configuration {

    @Bean
    public DataSource dataSource(
            @Value("${datasource.initScript}") String initScript
    ) {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("FINAL_WORK")
                .addScript(initScript)
                .build();
    }

    @Bean
    public SessionFactory sessionFactory(
            DataSource dataSource,
            @Value("${hibernate.packagesToScan}") String packagesToScan
    ) throws IOException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan(packagesToScan);
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }

}
