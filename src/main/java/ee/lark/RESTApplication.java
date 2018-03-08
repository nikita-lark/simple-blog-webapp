package ee.lark;

import ee.lark.providers.ExceptionMapperProvider;
import ee.lark.providers.ObjectMapperProvider;
import ee.lark.resources.PostResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

/**
 * {@inheritDoc}
 */
@ApplicationPath("/api")
public class RESTApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(PostResource.class);
        resources.add(CORSFilter.class);
        resources.add(ObjectMapperProvider.class);
        resources.add(ExceptionMapperProvider.class);
        return resources;
    }
}
