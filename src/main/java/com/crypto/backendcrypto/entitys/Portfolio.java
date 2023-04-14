package com.crypto.backendcrypto.entitys;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Portfolio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @ManyToOne
    // @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Account account;
    @OneToMany(mappedBy = "portfolio",fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Collection <Transaction> transactions;
}
