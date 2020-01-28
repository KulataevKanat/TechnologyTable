package kg.CSoft.TechnologyTable.advice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import kg.CSoft.TechnologyTable.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.NoSuchElementException;


@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(HttpStatusCodeException.class)
    public ErrorResponse httpClientErrorException(HttpStatusCodeException exception) {
        return new ErrorResponse(exception.getStatusCode(), exception);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ErrorResponse badRequest(InvalidFormatException exception) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, exception);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ErrorResponse unauthorized(AccessDeniedException exception) {
        return new ErrorResponse(HttpStatus.UNAUTHORIZED, exception);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ErrorResponse forbidden(AccessDeniedException exception) {
        return new ErrorResponse(HttpStatus.FORBIDDEN, exception);
    }

    @ExceptionHandler({NoSuchElementException.class, NotFoundException.class, EmptyResultDataAccessException.class})
    public ErrorResponse notFound(RuntimeException exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    public ErrorResponse unprocessableEntity(RuntimeException exception) {
        return new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, exception);
    }

    @ExceptionHandler(LockedException.class)
    public ErrorResponse locked(LockedException exception) {
        return new ErrorResponse(HttpStatus.LOCKED, exception);
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse internalServerError(RuntimeException exception) {
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }
}

