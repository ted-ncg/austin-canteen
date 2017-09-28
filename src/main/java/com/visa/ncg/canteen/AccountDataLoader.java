package com.visa.ncg.canteen;

        import org.springframework.boot.ApplicationArguments;
        import org.springframework.boot.ApplicationRunner;
        import org.springframework.stereotype.Component;

@Component
public class AccountDataLoader implements ApplicationRunner {
    private AccountRepository accountRepository;

    public AccountDataLoader(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setName("Luxuries");
        accountRepository.save(account);
        account = new Account(10);
        account.setName("Necessities");
        accountRepository.save(account);
        account = new Account(0);
        account.setName("An account has no name");
        accountRepository.save(account);
    }
}