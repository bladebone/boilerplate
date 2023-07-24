package hjseo.boilerplate.common;

import lombok.Getter;
import org.springframework.context.MessageSource;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.Locale;
import java.util.Optional;

@Getter
public class SimpleErrorResponse {

    private final String message;
    private final String field;
    private final String redirectionUrl;

    public SimpleErrorResponse() {
        this(null);
    }

    public SimpleErrorResponse(String message) {
        this(message, null);
    }

    public SimpleErrorResponse(String message, String field) {
        this(message, field, null);
    }

    public SimpleErrorResponse(String message, String field, String redirectionUrl) {
        this.message = message;
        this.field = field;
        this.redirectionUrl = redirectionUrl;
    }

    public static SimpleErrorResponse createByError(ObjectError error, MessageSource messageSource, Locale locale) {

        if (!StringUtils.hasLength(error.getCode())) {
            return new SimpleErrorResponse(error.getDefaultMessage());
        }

        final String parsed = Optional.ofNullable(messageSource.getMessage(error.getCode(), null, error.getDefaultMessage(), locale))
                .map(m -> SimpleErrorResponse.generateRowNum(error, messageSource, locale).concat(m))
                .orElse(null);

        return new SimpleErrorResponse(
                parsed,
                error instanceof FieldError ? ((FieldError) error).getField() : null);
    }

    private static String generateRowNum(ObjectError error, MessageSource messageSource, Locale locale) {

        if (null != error.getArguments() && 1 == error.getArguments().length) {
            try {
                int rowNum = Integer.parseInt(error.getArguments()[0].toString());
                return messageSource.getMessage("excel.row", new Object[]{rowNum}, locale); // synced
            } catch (Exception ignored) {
            }
        }
        return "";
    }
}
