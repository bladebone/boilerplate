package hjseo.boilerplate.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "응답: 공통 단순 결과 응답")
public class SimpleResponse {

    @Schema(title = "결과")
    private String result;

    public static SimpleResponse of(String result) {
        return new SimpleResponse(result);
    }
}
