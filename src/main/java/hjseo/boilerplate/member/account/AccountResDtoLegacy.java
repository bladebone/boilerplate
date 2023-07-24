package hjseo.boilerplate.member.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "회원정보")
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountResDtoLegacy {

    @Schema(description = "회원 ID")
    private Long id;

    @Schema(description = "이름")
    private String name;

    @Schema(description = "이메일")
    private String email;

    public static AccountResDtoLegacy of(Account account) {
        return new AccountResDtoLegacy(
                account.getId(),
                account.getName(),
                account.getEmail());
    }
}
