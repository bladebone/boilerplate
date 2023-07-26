package hjseo.boilerplate.member.account;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class AccountRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    AccountRepository accountRepository;

    Long accountId;

    @BeforeEach
    void init() {
        Account account = Account.builder()
                .name("name")
                .email("email@domain.com")
                .createdBy(1L)
                .updatedBy(1L)
                .build();

        entityManager.persist(account);
        entityManager.flush();

        account = (Account) entityManager.createQuery("select a from account a")
                .getSingleResult();
        System.out.println("account = " + account);

        this.accountId = account.getId();
    }

    @Test
    void findByIdTest() {

        // given

        // when
        final Optional<Account> result = accountRepository.findById(accountId);

        // then
        result.map(a -> assertThat(a.getId()).isEqualTo(accountId))
                .orElseThrow();
    }
}