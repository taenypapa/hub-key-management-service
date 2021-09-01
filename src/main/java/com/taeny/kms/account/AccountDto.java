package com.taeny.kms.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class AccountDto {

    private String username;
    private String password;
    private String name;
    private LocalDateTime enrollmentDate;

}
