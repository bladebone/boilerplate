package hjseo.boilerplate.common.dropbox;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class DropboxItem {

    @Schema(title = "표기명")
    private final String label;

    @Schema(title = "값")
    private final String value;

    public DropboxItem(DropboxEnumModel dropboxEnumModel) {
        label = dropboxEnumModel.getLabel();
        value = dropboxEnumModel.getValue();
    }

    public DropboxItem(DropboxEnumModel dropboxEnumModel, Locale locale, MessageSource messageSource) {
        if (null != dropboxEnumModel.getMessageCode()) {
            this.label = messageSource.getMessage(
                    dropboxEnumModel.getMessageCode(),
                    null,
                    dropboxEnumModel.getLabel(),
                    locale);
        } else {
            label = dropboxEnumModel.getLabel();
        }
        this.value = dropboxEnumModel.getValue();
    }

    public DropboxItem(String label, String value, String messageCode, MessageSource messageSource, Locale locale) {
        this.label = messageSource.getMessage(messageCode, null, label, locale);
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }
}