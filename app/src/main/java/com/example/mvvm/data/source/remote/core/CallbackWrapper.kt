package com.example.mvvm.data.source.remote.core

import com.example.mvvm.ui.BaseActivity
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import io.reactivex.observers.DisposableObserver
import okhttp3.ResponseBody
import org.json.JSONObject
import java.io.IOException
import java.lang.ref.WeakReference
import java.net.SocketTimeoutException


/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 12/1/17.
 */
abstract class CallbackWrapper<T>(baseActivity: BaseActivity) : DisposableObserver<T>() {
    enum class NetworkError {
        REQUEST_TIMEOUT_ERROR,
        NETWORK_ERROR,
        UN_KNOW_ERROR,
        OTHER_ERROR
    }

    private val weakReference: WeakReference<BaseActivity> = WeakReference(baseActivity)

    protected abstract fun onSuccess(t: T)

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        val view = weakReference.get()
        when (e) {
            is HttpException -> {
                val responseBody = e.response().errorBody()
                view?.onHandleApiError(NetworkError.UN_KNOW_ERROR, getErrorMessage(responseBody!!))
            }
            is SocketTimeoutException -> view?.onHandleApiError(NetworkError.REQUEST_TIMEOUT_ERROR, "")
            is IOException -> view?.onHandleApiError(NetworkError.NETWORK_ERROR, "")
            else -> view?.onHandleApiError(NetworkError.OTHER_ERROR, e.message.toString())
        }
    }

    override fun onComplete() {}

    private fun getErrorMessage(responseBody: ResponseBody): String {
        return try {
            val jsonObject = JSONObject(responseBody.string())
            jsonObject.getString("message")
        } catch (e: Exception) {
            e.message.toString()
        }
    }
}
