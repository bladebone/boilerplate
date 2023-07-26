package hjseo.boilerplate.member.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class AccountServiceTest {

    AccountService accountService;

    @BeforeEach
    void init() {
        this.accountService = mock(AccountService.class);
    }

    @Test
    @DisplayName("test accountService.get()")
    void getTest() {

        // given
        final long accountId = 1L;
        final String name = "name";
        final String email = "email@domain.com";
        final Account account = new Account(accountId, name, email);
        given(accountService.get(accountId)).willReturn(Optional.of(account));

        // when
        final Optional<Account> result = accountService.get(accountId);

        // then
        assertThat(result.map(Account::getId).orElseThrow()).isEqualTo(accountId);
    }
}
