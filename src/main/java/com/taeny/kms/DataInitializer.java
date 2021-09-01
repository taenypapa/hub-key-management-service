package com.taeny.kms;

import com.taeny.kms.account.Account;
import com.taeny.kms.account.AccountService;
import com.taeny.kms.item.Item;
import com.taeny.kms.item.ItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
@Slf4j
public class DataInitializer implements ApplicationRunner {

	private AccountService accountService;
	private ItemService itemService;

	@Override
	public void run(ApplicationArguments args) {

		/** data-key binding */


		Account accountOnboarding = accountService.save(Account.builder()
				.userId("myTaeny")
				.password("myTaeny_1@3$5")
				.name("kms")
				.masterKey("6263613430386538303866323465343662333537303936666436623639643536")
				.enrollmentDate(LocalDateTime.now())
				.build());

		itemService.save(Item.builder()
				.account(accountOnboarding)
				.name("AES256_BASIC")
				.dataKey("3436363763643539323730303465613438386134326637336337303265323031")
				.dataKeyVersion("20210721")
				.enrollmentDate(LocalDateTime.now())
				.build());

	}
}
