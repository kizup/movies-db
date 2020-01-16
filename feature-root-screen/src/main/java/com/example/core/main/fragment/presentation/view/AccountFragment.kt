package com.example.core.main.fragment.presentation.view

import android.os.Bundle
import android.view.View
import com.example.core.main.fragment.R
import com.example.moviesdb.presentation.mvp.base.BasePresenter
import com.example.moviesdb.presentation.view.base.BaseFragment

class AccountFragment : BaseFragment<BasePresenter<*>>() {

    override fun performInject() {
    }

    override val layoutId: Int
        get() = R.layout.fragment_account

    override fun initView(view: View, savedInstanceState: Bundle?) {
    }
}