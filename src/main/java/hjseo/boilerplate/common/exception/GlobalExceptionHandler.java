package hjseo.boilerplate.common.exception;

import hjseo.boilerplate.common.ErrorsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.Locale;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(ClientAbortException.class)
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void handleClientAbortException(ClientAbortException e) {
        log.info("ClientAbortException is occurred. {}", e.toString());
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsResponse handleIOException(IOException e, Locale locale) {
        log.error(e.toString(), e);
        return ErrorsResponse.create(messageSource.getMessage("internalServerError", null, locale), null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsResponse handleUnhandledException(Exception e, Locale locale) {
        log.error(e.toString(), e);
        return ErrorsResponse.create(messageSource.getMessage("internalServerError", null, locale), null);
    }
}
