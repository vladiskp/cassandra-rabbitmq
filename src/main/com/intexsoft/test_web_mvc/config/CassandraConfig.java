package main.com.intexsoft.test_web_mvc.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@ComponentScan(basePackages = "main.com.intexsoft.test_web_mvc.service")
@EnableCassandraRepositories(basePackages = "main.com.intexsoft.test_web_mvc.repository")
@PropertySource(value = "classpath:cassandra.properties")
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${cassandra.key_space}")
    private String keySpace;

    @Value("${cassandra.host}")
    private String host;

    @Value("${cassandra.port}")
    private int port;

    @Override
    protected String getKeyspaceName() {
        return keySpace;
    }

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(host);
        cluster.setPort(port);
        return cluster;
    }
}