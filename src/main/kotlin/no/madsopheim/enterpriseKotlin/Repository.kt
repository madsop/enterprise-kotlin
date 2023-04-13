package no.madsopheim.enterpriseKotlin

import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class Repository {
    fun language() = "Kotlin"
}
