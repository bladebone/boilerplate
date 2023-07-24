package hjseo.boilerplate.member.account;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "01. 회원")
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @Operation(summary = "개별 회원 정보 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "정상 조회", content = @Content(schema = @Schema(implementation = AccountResDtoLegacy.class))),
            @ApiResponse(responseCode = "204", description = "회원 정보 없음"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    @GetMapping("/account/{accountId}")
    public ResponseEntity<AccountResDto> getAccount(
            @Parameter(name = "회원 ID") @PathVariable("accountId") Long accountId) {

        return accountService.get(accountId)
                .map(value -> ResponseEntity.ok(AccountResDto.of(value)))
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
