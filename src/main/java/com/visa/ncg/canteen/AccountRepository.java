package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class AccountRepository {

  private Map<Long, Account> accountIdMap = new HashMap<>();

  private final IdGenerator idGenerator;

  @Autowired
  public AccountRepository(IdGenerator idGenerator) {
    this.idGenerator = idGenerator;
  }

  public AccountRepository(List<Account> accounts, IdGenerator idGenerator) {
    this.idGenerator = idGenerator;
    for (Account account : accounts) {
      accountIdMap.put(account.getId(), account);
    }
  }

  public List<Account> findAll() {
    return new ArrayList<>(accountIdMap.values());
  }

  public Account findOne(Long id) {
    return accountIdMap.get(id);
  }

  public Account save(Account account) {
    if (account.getId() == null) {
      account.setId(idGenerator.nextId());
    }
    accountIdMap.put(account.getId(), account);

    return account;
  }
}
