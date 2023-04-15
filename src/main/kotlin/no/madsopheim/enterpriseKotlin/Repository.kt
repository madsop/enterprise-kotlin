package no.madsopheim.enterpriseKotlin

import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext

@ApplicationScoped
class Repository(@PersistenceContext(name = "jpa-unit") private var em: EntityManager) {

    fun language() = "Kotlin"

    fun create(hello: Hello) = em.persist(hello)

    fun read(id: Int) = em.find(Hello::class.java, id)

    fun update(hello: Hello) = em.merge(hello)

    fun delete(id: Int) = em.remove(id)
}
