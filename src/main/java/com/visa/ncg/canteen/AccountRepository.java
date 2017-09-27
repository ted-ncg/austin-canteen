package com.visa.ncg.canteen;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class AccountRepository {

    private HashMap<Long, Account> accountMap;
    private final AtomicLong count = new AtomicLong(1L);

    public AccountRepository() {

        accountMap = new HashMap<>();

    }

    public AccountRepository(List<Account> accounts) {

        this();
        for (Account account : accounts) {
            accountMap.put(account.getId(), account);
        }

    }

    public Account findOne(Long id) {
        // Returns the Account that is identified by the given id.
        // If there's no Account with that id, return null.

        return accountMap.get(id);

    }

    public Account save(Account entity) {
        // Stores the given account in the repository so it can be found later.
        // If the incoming account object's id is already set, DON'T modify it
        // If the account came in with NO id, replace it with one generated from AtomicLong.
        // return the Account object that must now have its id set

        if (entity.getId() == null) {
            entity.setId(count.getAndIncrement());
        }

        accountMap.put(entity.getId(), entity);

        return entity;

    }

    public List<Account> findAll() {
        // Return all accounts as a List
        // If there are no accounts, return empty List

        return new ArrayList<>(accountMap.values());

    }

}
