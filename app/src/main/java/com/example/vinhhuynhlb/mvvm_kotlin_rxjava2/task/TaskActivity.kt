package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.task

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.example.vinhhuynhlb.basemvvmkotlin.repository.api.core.ApiClient
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.repository.TaskRepository
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.util.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.*

class TaskActivity : AppCompatActivity() {
    private val mSubscription: CompositeDisposable = CompositeDisposable()
    private lateinit var mTaskViewModel: TaskViewModel
    lateinit var tvName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TaskActivityUI().setContentView(this)
        mTaskViewModel = TaskViewModel(SchedulerProvider.getInstance(), TaskRepository(ApiClient.getApiService()))
    }

    override fun onStart() {
        super.onStart()
        bindViewModel()
    }

    override fun onPause() {
        super.onPause()
        unBindViewModel()
    }

    private fun bindViewModel() {
        mSubscription.add(mTaskViewModel.getUser()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                }
                .doOnComplete {
                }
                .subscribe({
                    tvName.text = it.name
                }, {
                    Log.d("VVVV", it.message)
                }))
    }

    private fun unBindViewModel() {
        mSubscription.clear()
    }
}

class TaskActivityUI : AnkoComponent<TaskActivity> {
    override fun createView(ui: AnkoContext<TaskActivity>) = with(ui) {
        relativeLayout {
            owner.tvName = textView("Hello Word!!!") {
            }.lparams(wrapContent, wrapContent) {
                centerInParent()
            }
        }
    }
}
