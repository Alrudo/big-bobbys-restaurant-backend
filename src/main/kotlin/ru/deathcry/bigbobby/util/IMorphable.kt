package ru.deathcry.bigbobby.util

interface IMorphable<T> {
    public fun morph(): T
}

fun <T> List<IMorphable<T>>.morph(): List<T> {
    return this.map { it.morph() }
}