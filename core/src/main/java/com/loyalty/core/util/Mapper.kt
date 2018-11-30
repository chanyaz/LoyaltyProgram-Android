package com.loyalty.core.util

abstract class Mapper<in F, out T> {

    abstract fun map(from: F): T

}