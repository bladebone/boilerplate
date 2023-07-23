package hjseo.boilerplate.common.dropbox;

public interface DropboxEnumModel {

    String name();

    default String getLabel() {
        return this.name();
    }

    default String getValue() {
        return this.name();
    }

    default String getMessageCode() {
        return null;
    }

    default boolean isDeprecated() {
        return false;
    }
}
