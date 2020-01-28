package kg.CSoft.TechnologyTable.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

public class RestResponseAdvice {
    @RestControllerAdvice
    public static class ErrorResponseWrapAdvice implements ResponseBodyAdvice<ErrorResponse> {
        @Override
        public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
            Class<?> parameterType = returnType.getParameterType();
            return parameterType.equals(ErrorResponse.class);
        }

        @Override
        public ErrorResponse beforeBodyWrite(ErrorResponse errorResponse, MethodParameter methodParameter,
                                             MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                                             ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
            serverHttpResponse.setStatusCode(errorResponse.getHttpStatus());
            return errorResponse;
        }
    }
}

