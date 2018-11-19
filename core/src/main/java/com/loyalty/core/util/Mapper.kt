package com.loyalty.core.util

abstract class Mapper<in F, T> {
    abstract fun map(from: F): T
}