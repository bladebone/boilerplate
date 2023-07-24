package hjseo.boilerplate.common.dropbox;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.context.MessageSource;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DropboxConverter {

    public static List<DropboxItem> convert(Class<? extends DropboxEnumModel> e) {
        return Arrays.stream(e.getEnumConstants())
                .filter(dropboxEnumModel -> !dropboxEnumModel.isDeprecated())
                .map(DropboxItem::new)
                .collect(Collectors.toList());
    }

    public static List<DropboxItem> convert(Class<? extends DropboxEnumModel> e, Locale locale, MessageSource messageSource) {
        return Arrays.stream(e.getEnumConstants())
                .filter(dropboxEnumModel -> !dropboxEnumModel.isDeprecated())
                .map(dropboxEnumModel -> new DropboxItem(dropboxEnumModel, locale, messageSource))
                .collect(Collectors.toList());
    }
}
