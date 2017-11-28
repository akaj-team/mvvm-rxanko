package com.example.mvvm.data.source.remote.core

import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.lang.reflect.Type

class CustomCallAdapterFactory : CallAdapter.Factory() {
    private var original: RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    companion object {
        fun create(): CallAdapter.Factory {
            return CustomCallAdapterFactory()
        }
    }

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        return RxCallAdapterWrapper(retrofit, original.get(returnType, annotations, retrofit))
    }

    private class RxCallAdapterWrapper<R>(private val retrofit: Retrofit, private val wrapped: CallAdapter<R, *>?) : CallAdapter<R, Any> {
        override fun adapt(call: Call<R>): Any {
            if (wrapped?.adapt(call) is Single<*>) {
                return (wrapped.adapt(call) as Single<*>).map(this::handleCustomError)
            }
            return (wrapped!!.adapt(call) as Observable<*>).map(this::handleCustomError)
        }

        private fun handleCustomError(response: Any?): Observable<R> {
            val body = ResponseBody.create(MediaType.parse("text"), "Bodyyyy")
            val response = Response.error<R>(456, body)
            throw ApiException("xxx")
        }

        override fun responseType(): Type {
            return wrapped!!.responseType()
        }
    }

}