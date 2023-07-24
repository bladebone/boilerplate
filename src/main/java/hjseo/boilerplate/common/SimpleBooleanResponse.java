package hjseo.boilerplate.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Schema(description = "응답: 공통 Boolean 응답")
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleBooleanResponse {

    @Schema(description = "결과", allowableValues = "true, false")
    private final Boolean result;

    public static SimpleBooleanResponse of(boolean result) {
        return new SimpleBooleanResponse(result);
    }
}
