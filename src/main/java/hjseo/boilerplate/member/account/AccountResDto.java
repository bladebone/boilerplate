package hjseo.boilerplate.member.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.ToString;

@Schema(description = "회원정보")
public record AccountResDto(
        @Schema(description = "회원 ID") Long id,
        @Schema(description = "이름") String name,
        @Schema(description = "이메일") String email) {

    public static AccountResDto of(Account account) {
        return new AccountResDto(account.getId(), account.getName(), account.getEmail());
    }
}
