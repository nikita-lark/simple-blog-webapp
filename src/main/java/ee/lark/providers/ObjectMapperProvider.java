package ee.lark.providers;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;

@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ObjectMapperProvider() {
        objectMapper.setPropertyNamingStrategy(
                PropertyNamingStrategy.SNAKE_CASE
        );
    }

    @Override
    public ObjectMapper getContext(Class<?> type) { return objectMapper; }
}
