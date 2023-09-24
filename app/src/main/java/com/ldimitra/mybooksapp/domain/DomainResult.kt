package com.ldimitra.mybooksapp.domain

sealed class DomainResult<T : Any> {
    class Success<T : Any>(val data: T) : DomainResult<T>()
    class Error<T : Any>(val code: Int, val message: String?) : DomainResult<T>()
    class Exception<T : Any>(val e: Throwable) : DomainResult<T>()
}