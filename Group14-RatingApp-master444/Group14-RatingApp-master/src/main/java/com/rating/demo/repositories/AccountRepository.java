package com.rating.demo.repositories;

import com.rating.demo.beans.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>
{

}
