package hjseo.boilerplate.member.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Optional<Account> get(Long accountId) {
        return accountRepository.findById(accountId);
    }
}
