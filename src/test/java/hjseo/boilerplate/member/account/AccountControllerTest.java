package hjseo.boilerplate.member.account;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AccountController.class)
@ActiveProfiles("test")
class AccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    AccountService accountService;

    @Test
    @DisplayName("GET /account/{accountId}")
    void getAccountEndpointTest() throws Exception {

        // given
        final long accountId = 1L;
        final String name = "name";
        final String email = "email@domain.com";
        final Account account = Account.builder()
                .id(accountId)
                .name(name)
                .email(email)
                .build();
        account.recordCreatedBy(1L);
        account.recordUpdatedBy(1L);
        given(accountService.get(accountId)).willReturn(Optional.of(account));

        // when
        // then
        mvc.perform(get("/account/" + accountId))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(accountId))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.email").value(email))
                .andDo(result -> System.out.println("result = " + result.getResponse().getContentAsString()));

        mvc.perform(get("/account/0"))
                .andExpect(status().isNoContent())
                .andDo(result -> System.out.println("result = " + result.getResponse().getContentAsString()));

        mvc.perform(get("/account/null"))
                .andExpect(status().is5xxServerError());
    }
}
