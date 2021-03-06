package org.amshove.kluent

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import kotlin.reflect.KClass

infix fun <T> T.`should equal`(expected: T?): T = this.shouldEqual(expected)

infix fun <T> T.`should not equal`(expected: T?) = this.shouldNotEqual(expected)

infix fun <T> T.`should be`(expected: T?) = this.shouldBe(expected)

infix fun Any?.`should not be`(expected: Any?) = this.shouldNotBe(expected)

infix fun Any?.`should be instance of`(className: Class<*>) = this.shouldBeInstanceOf(className)

infix fun Any?.`should be instance of`(className: KClass<*>) = this.shouldBeInstanceOf(className)

inline fun <reified T : Any> Any?.`should be instance of`() = this.shouldBeInstanceOf<T>()

infix fun Any?.`should not be instance of`(className: Class<*>) = this.shouldNotBeInstanceOf(className)

infix fun Any?.`should not be instance of`(className: KClass<*>) = this.shouldNotBeInstanceOf(className)

inline fun <reified T : Any> Any?.`should not be instance of`() = this.shouldNotBeInstanceOf<T>()

fun Any?.`should be null`() = this.shouldBeNull()

@UseExperimental(ExperimentalContracts::class)
fun <T : Any> T?.`should not be null`(): T {
    contract {
        returns() implies (this@`should not be null` != null)
    }

    return this.shouldNotBeNull()
}

@UseExperimental(ExperimentalContracts::class)
fun Boolean.`should be true`(): Boolean {
    contract {
        returns() implies this@`should be true`
    }

    return this.shouldBeTrue()
}

@UseExperimental(ExperimentalContracts::class)
fun Boolean.`should be false`(): Boolean {
    contract {
        returns() implies !this@`should be false`
    }

    return this.shouldBeFalse()
}

@UseExperimental(ExperimentalContracts::class)
fun Boolean.`should not be true`(): Boolean {
    contract {
        returns() implies !this@`should not be true`
    }

    return this.shouldBeFalse()
}

@UseExperimental(ExperimentalContracts::class)
fun Boolean.`should not be false`(): Boolean {
    contract {
        returns() implies this@`should not be false`
    }

    return this.shouldBeTrue()
}

fun Char.`should be digit`(): Char = this.shouldBeDigit()

fun Char.`should not be digit`(): Char = this.shouldNotBeDigit()
