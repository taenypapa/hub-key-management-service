package com.taeny.kms.item;

import com.taeny.kms.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Integer> {

    public Optional<Item> findByAccountAndName(Account account, String name);
}
