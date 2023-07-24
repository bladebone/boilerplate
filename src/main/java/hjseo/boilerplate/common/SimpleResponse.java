package hjseo.boilerplate.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Schema(description = "응답: 공통 단순 결과 응답")
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleResponse {

    @Schema(description = "결과")
    private final String result;

    public static SimpleResponse of(String result) {
        return new SimpleResponse(result);
    }
}
