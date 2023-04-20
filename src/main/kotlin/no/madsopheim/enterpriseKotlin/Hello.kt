package no.madsopheim.enterpriseKotlin

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Hello(
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private var id: Int,
    private var text: String,
)
