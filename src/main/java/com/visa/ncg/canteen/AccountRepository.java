package com.visa.ncg.canteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class AccountRepository {
    private HashMap<Long, Account> repo;

    public AccountRepository(){ repo = new HashMap<Long, Account>();    }

    public AccountRepository(List<Account> accounts) {
        repo = new HashMap<Long, Account>();
        for ( Account i : accounts) { save(i); }
    }

    public Account findOne(Long id) {
        // Returns the Account that is identified by the given id.
        // If there's no Account with that id, return null.
        return repo.get(id);
    }

    public List<Account> findAll() {
        List<Account> list = new ArrayList<Account>(repo.values());
        return list;
    }

    public Account save(Account account1) {
        // Stores the given account in the repository so it can be found later.
        // If the incoming account object's id is already set, DON'T modify it
        // If the account came in with NO id, replace it with one generated from AtomicLong.
        // return the Account object that must now have its id set

        if (account1.getId() == 0L){
            AtomicLong newId = new AtomicLong(repo.size() + 1);
            account1.setId(newId.get());
        }

        repo.put(account1.getId(), account1);
        return  account1;
    }
}
