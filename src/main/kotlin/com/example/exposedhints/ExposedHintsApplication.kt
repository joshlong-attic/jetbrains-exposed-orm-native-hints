package com.example.exposedhints

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.nativex.hint.AccessBits
import org.springframework.nativex.hint.TypeHint
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@TypeHint(
    access = AccessBits.ALL,
    types = [
        java.util.Collections::class,
        Column::class,
        Database::class,
        DdlAware::class,
        Expression::class,
        ExpressionWithColumnType::class,
        ForeignKeyConstraint::class,
        IColumnType::class,
        QueryBuilder::class,
        Table::class,
        Transaction::class,
        TransactionManager::class,
        Column::class,
        Database::class,

        ///
        kotlin.jvm.functions.Function0::class,
        kotlin.jvm.functions.Function1::class,
        kotlin.jvm.functions.Function2::class,
        kotlin.jvm.functions.Function3::class,
        kotlin.jvm.functions.Function4::class,
        kotlin.jvm.functions.Function5::class,
        kotlin.jvm.functions.Function6::class,
        kotlin.jvm.functions.Function7::class,
        kotlin.jvm.functions.Function8::class,
        kotlin.jvm.functions.Function9::class,
        kotlin.jvm.functions.Function10::class,
        kotlin.jvm.functions.Function11::class,
        kotlin.jvm.functions.Function12::class,
        kotlin.jvm.functions.Function13::class,
        kotlin.jvm.functions.Function14::class,
        kotlin.jvm.functions.Function15::class,
        kotlin.jvm.functions.Function16::class,
        kotlin.jvm.functions.Function17::class,
        kotlin.jvm.functions.Function18::class,
        kotlin.jvm.functions.Function19::class,
        kotlin.jvm.functions.Function20::class,
        kotlin.jvm.functions.Function21::class,
        kotlin.jvm.functions.Function22::class,
        kotlin.jvm.functions.FunctionN::class

    ]
)
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