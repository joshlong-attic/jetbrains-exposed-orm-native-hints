package com.example.exposedhints

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.selectAll
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@SpringBootApplication
class ExposedHintsApplication

fun main(args: Array<String>) {

    runApplication<ExposedHintsApplication>(*args)
}

@Component
class Runner(private val ecs: CustomerService) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        ecs.all().forEach { println(it) }
    }

}

interface CustomerService {
    fun all(): Collection<Customer>
}

@Service
@Transactional
class ExposedCustomerService : CustomerService {

    override fun all() = Customers.selectAll()
        .map { Customer(it[Customers.id], it[Customers.name]) }
}

object Customers : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 255)
    override val primaryKey = PrimaryKey(id)
}

data class Customer(val id: Int, val name: String)