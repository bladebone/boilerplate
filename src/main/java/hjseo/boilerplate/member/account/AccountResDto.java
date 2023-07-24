package hjseo.boilerplate.member.account;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "회원정보")
public record AccountResDto(
        @Schema(name = "회원 ID") Long id,
        @Schema(name = "이름") String name,
        @Schema(name = "이메일") String email) {

    public static AccountResDto of(Account account) {
        return new AccountResDto(account.getId(), account.getName(), account.getEmail());
    }
}
