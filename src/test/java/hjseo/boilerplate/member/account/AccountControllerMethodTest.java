package hjseo.boilerplate.member.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AccountControllerMethodTest {

    AccountController accountController;

    @BeforeEach
    void init() {
        accountController = mock(AccountController.class);
    }

    @Test
    @DisplayName("test accountController.getAccount()")
    void getAccountMethodTest() {

        // given
        final long accountId = 1L;
        final String name = "name";
        final String email = "email@domain.com";
        given(accountController.getAccount(accountId)).willReturn(ResponseEntity.ok(new AccountResDto(accountId, name, email)));

        // when
        final ResponseEntity<AccountResDto> result = accountController.getAccount(accountId);

        // then
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
