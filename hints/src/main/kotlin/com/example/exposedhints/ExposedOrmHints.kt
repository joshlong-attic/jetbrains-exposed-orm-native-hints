package com.example.exposedhints

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.springframework.nativex.hint.AccessBits
import org.springframework.nativex.hint.TypeHint
import org.springframework.nativex.type.NativeConfiguration

/**
 *
 * Configures reflective access for all the types specified below, with which I was able to get
 * a trivial Exposed ORM application working.
 *
 * @author Josh Long
 */
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
class ExposedOrmHints : NativeConfiguration
