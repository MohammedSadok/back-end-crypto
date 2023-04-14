package com.crypto.backendcrypto.entitys;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Coin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String nom;
    String symbole;
    String icon;
    @OneToMany (mappedBy = "coin")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Collection <Transaction> transactions;
}
