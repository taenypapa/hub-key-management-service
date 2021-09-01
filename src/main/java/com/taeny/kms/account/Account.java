package com.taeny.kms.account;

import com.taeny.kms.item.Item;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Builder @NoArgsConstructor @AllArgsConstructor
@SequenceGenerator(
        name="T_ACCOUNT_SEQ_GENERATOR",
        sequenceName="T_ACCOUNT_SEQ",
        initialValue=1, allocationSize = 1)
@Table(name = "T_ACCOUNT")
public class Account {

	@Id
	@Column(name="ac_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_ACCOUNT_SEQ_GENERATOR")
    private Integer seq;

    @Column(name = "ac_user_id", unique = true, nullable = false)
    private String userId;/*사용 권한 확인*/

    @Column(name = "ac_password", length = 1024, nullable = false)
    private String password;/*사용 권한 확인*/

    @Column(name = "ac_name", length = 100, nullable = false)
    private String name;/*사용자 명 확인*/

    @Column(name = "ac_master_key", length = 64, nullable = false)
    private String masterKey;/*사용자 명 확인*/

    @Column(name = "ac_enrollment_date", nullable = false)
    private LocalDateTime enrollmentDate;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();
}
