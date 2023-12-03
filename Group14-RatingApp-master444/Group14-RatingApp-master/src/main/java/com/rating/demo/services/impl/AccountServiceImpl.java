package com.rating.demo.services.impl;

import com.rating.demo.beans.Account;
import com.rating.demo.services.AccountService;
import com.rating.demo.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService
{
    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account)
    {

        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccount()
    {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getAccount(Long accountId)
    {
        return accountRepository.findById(accountId);
    }

    @Override
    public Account updateAccount(Long accountId, Account account)
    {
        Account update = accountRepository.findById(accountId).get();
        update.setStudentId(account.getStudentId());
        update.setEmail(account.getEmail());
        update.setFullName(account.getFullName());
        update.setUsername(account.getUsername());
        update.setPassword(account.getPassword());
        return accountRepository.save(update);
    }

    @Override
    public void deleteAccount(Long accountId)
    {
        Account delete = accountRepository.findById(accountId).get();
        accountRepository.delete(delete);
    }
}
