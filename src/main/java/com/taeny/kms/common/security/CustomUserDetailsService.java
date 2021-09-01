package com.taeny.kms.common.security;

import com.taeny.kms.account.Account;
import com.taeny.kms.account.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Account> account = accountRepository.findAccountByUserId(username);

        // 저장된 ID가 없을때 throw 시켜 줍니다.
        if(account == null) {
            throw new UsernameNotFoundException("user_not_found");
        }
        return makeLoginUser(account.get());
    }

    // UserInformation 값 주입해 줍니다.
    public CustomUserDetails makeLoginUser(Account account) {

        CustomUserDetails loginUser  = new CustomUserDetails();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ALL"));

        loginUser.setUsername(account.getUserId());
        loginUser.setPassword(account.getPassword());
        loginUser.setName(account.getName());
        loginUser.setAuthorities(authorities);

        return loginUser;
    }

}