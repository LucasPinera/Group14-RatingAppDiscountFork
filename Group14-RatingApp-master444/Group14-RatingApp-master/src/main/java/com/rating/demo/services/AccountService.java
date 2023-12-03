package com.rating.demo.services;

import com.rating.demo.beans.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService
{
    public Account createAccount(Account author);
    public List<Account> getAllAccount();
    public Optional<Account> getAccount(Long accountId);
    public Account updateAccount(Long accountId, Account account);
    public void deleteAccount(Long accountId);
}
