package wad.configuration;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class RestConfiguration extends RepositoryRestMvcConfiguration {

    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        super.configureRepositoryRestConfiguration(config);
        try {
            config.setBaseUri(new URI("/api/kokeet"));
        } catch (URISyntaxException e) {
            throw new RuntimeException("Unable to bind REST API to address /api/kokeet");
        }
    }
}
