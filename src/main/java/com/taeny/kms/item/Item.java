package com.taeny.kms.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taeny.kms.account.Account;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name="T_ITEM_SEQ_GENERATOR",
        sequenceName="T_ITEM_SEQ",
        initialValue=1, allocationSize = 1)
@Table(name = "T_ITEM")
public class Item {

    @Id
    @Column(name="it_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_ITEM_SEQ_GENERATOR")
    private Integer seq;

    @Column(name = "it_name", nullable = false, length = 1024)
    private String name;

    @Column(name = "it_data_key", length = 64, nullable = false)
    private String dataKey;/*사용자 명 확인*/

    @Column(name = "it_data_key_version", length = 8, nullable = false)
    private String dataKeyVersion;/*사용자 명 확인*/

    @Column(name = "it_enrollment_date", nullable = false)
    private LocalDateTime enrollmentDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ac_seq", referencedColumnName = "ac_seq")
    @JsonIgnore
    private Account account;
}
