package hjseo.boilerplate.common;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.Locale;

@Getter
public class SimpleErrorResponse {

    private final String message;
    private final String field;
    private final String redirectionUrl;

    public SimpleErrorResponse() {
        this(StringUtils.EMPTY);
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
        if (StringUtils.isBlank(error.getCode()))
            return new SimpleErrorResponse();

        String messageRow = generateRowNum(error, messageSource, locale);

        return new SimpleErrorResponse(
                messageRow.concat(messageSource.getMessage(error.getCode(), null, error.getDefaultMessage(), locale)),
                error instanceof FieldError ? ((FieldError) error).getField() : null);
    }

    private static String generateRowNum(ObjectError error, MessageSource messageSource, Locale locale) {
        if (error.getArguments() != null && error.getArguments().length == 1) {
            try {
                int rowNum = Integer.parseInt(error.getArguments()[0].toString());
                return messageSource.getMessage("excel.row", new Object[]{rowNum}, locale); // synced
            } catch (Exception ignored) {
            }
        }
        return "";
    }
}
