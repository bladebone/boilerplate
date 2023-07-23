package hjseo.boilerplate.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(name = "응답: 공통 Boolean 응답")
public class SimpleBooleanResponse {

    @Schema(title = "결과", allowableValues = "true, false")
    private final Boolean result;

    public SimpleBooleanResponse(Boolean result) {
        this.result = result;
    }

    public static SimpleBooleanResponse of(boolean result) {
        return new SimpleBooleanResponse(result);
    }
}
