package ee.lark.providers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ee.lark.ErrorResponse;

@Provider
public class ExceptionMapperProvider implements ExceptionMapper<Exception> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Response toResponse(final Exception exception) {
        // return all the exceptions with the http status code 500
        ResponseBuilder builder = Response
                .status(Status.INTERNAL_SERVER_ERROR)
                .entity(buildReturnBody(exception))
                .type(MediaType.APPLICATION_JSON);

        return builder.build();
    }

    /**
     * @param exception
     * @return String
     */
    private String buildReturnBody(final Exception exception) {
        //TODO! Return the message depending on the type of the exception.
        ErrorResponse errorInfo = new ErrorResponse("An error occurred. Please, try again later!");
        try {
            return objectMapper.writeValueAsString(errorInfo);
        } catch (JsonProcessingException e) {
            return "{\"message\":\"An error occurred. Please, try again later!\"}";
        }
    }
}