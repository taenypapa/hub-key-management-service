package com.taeny.kms.publish;

import com.taeny.kms.account.Account;
import com.taeny.kms.account.AccountService;
import com.taeny.kms.common.security.CustomUserDetails;
import com.taeny.kms.common.security.crypto.AES256;
import com.taeny.kms.common.utils.WebNetworkUtil;
import com.taeny.kms.item.Item;
import com.taeny.kms.item.ItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/publish", produces = "application/json;charset=utf-8")
@AllArgsConstructor
@Slf4j
public class PublishController {

    private AccountService accountService;
    private ItemService itemService;

    @PostMapping("/{item}")
    public HashMap<String, String> publish(@PathVariable(value = "item", required = true) String item,
            HttpServletRequest request) throws UnsupportedEncodingException, GeneralSecurityException {

        HashMap<String, String> result = new HashMap<>();

        /*권한 최종 점검 + 적정 item 호출*/
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUserDetails userDetails = (CustomUserDetails) principal;

        Optional<Account> optionalAccount = accountService.findByUserId(userDetails.getUsername());
        if (optionalAccount.isPresent()) {

            Optional<Item> optionalItem = itemService.findByAccountAndItemName(optionalAccount.get(), item);

            if(optionalItem.isPresent()) {
                AES256 aes256 = new AES256(optionalAccount.get().getMasterKey());
                result.put("data-key", aes256.encrypt(optionalItem.get().getDataKey()));

                log.info("message: ", result.size());
            } else {
                result.put("error", "Incorrect_authentication_information");
            }
        } else {
            result.put("error", "Incorrect_authentication_information");
        }

        return result;
    }

}
