package com.rating.demo.controllers;

import com.rating.demo.beans.Account;
import com.rating.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController
{
    @Autowired
    AccountService accountService;
    public AccountController(AccountService accountService)
    {
        this.accountService = accountService;
    }

    @PostMapping("/add")
    public Account createAccount(@RequestBody Account account)
    {
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
    public Optional<Account> getAccount(@PathVariable(value = "id") Long accountId)
    {
        return accountService.getAccount(accountId);
    }

    @GetMapping()
    public List<Account> getAllAccounts() {
        return accountService.getAllAccount();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAccount(@PathVariable(value = "id") Long accountId)
    {
        accountService.deleteAccount(accountId);
        return "Account with id: " + accountId + " deleted...";
    }
}
