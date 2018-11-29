package com.loyalty.core.util

abstract class UseCase<R> {

    abstract fun execute(): R

}