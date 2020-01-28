package kg.CSoft.TechnologyTable.advice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;

public class ErrorResponse {
    @JsonIgnore
    private final HttpStatus httpStatus;

    public int getStatus() {
        return this.httpStatus.value();
    }

    public String getError() {
        return this.httpStatus.getReasonPhrase();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getClassName() {
        return className;
    }

    public String getMessage() {
        return message;
    }

    public String[] getCauses() {
        return causes;
    }

    public void setCauses(String[] causes) {
        this.causes = causes;
    }

    private final String className;

    private final String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String[] causes;

    public <T extends Throwable> ErrorResponse(@NonNull HttpStatus httpStatus, @NonNull T throwable) {
        throwable.printStackTrace(System.out);
        this.httpStatus = httpStatus;
        this.className = throwable.getClass().getSimpleName();
        this.message = throwable.getMessage();
        this.causes = causes(throwable.getCause(), 0);
    }

    private static String[] causes(Throwable throwable, int i) {
        if (throwable == null) {
            return new String[i];
        }
        String[] r = causes(throwable.getCause(), i + 1);
        r[i] = throwable.getMessage();
        return r;
    }
}

