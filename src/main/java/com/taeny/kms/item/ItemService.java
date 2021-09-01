package com.taeny.kms.item;

import com.taeny.kms.account.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;

    public Optional<Item> findBySeq(Integer seq) {
        return itemRepository.findById(seq);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public void deleteAll(){ itemRepository.deleteAll();}

    public Optional<Item> findByAccountAndItemName(Account account, String name){
        return itemRepository.findByAccountAndName(account, name);
    }
}
