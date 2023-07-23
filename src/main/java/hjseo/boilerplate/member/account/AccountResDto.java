package hjseo.boilerplate.member.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Schema(title = "회원정보")
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountResDto {

    @Schema(name = "회원 ID")
    private Long id;

    @Schema(name = "이름")
    private String name;

    @Schema(name = "이메일")
    private String email;

    public static AccountResDto of(Account account) {
        return new AccountResDto(
                account.getId(),
                account.getName(),
                account.getEmail());
    }
}
