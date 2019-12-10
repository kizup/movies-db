package com.example.core.main

import androidx.fragment.app.Fragment
import com.example.core.main.fragment.presentation.view.AccountFragment
import com.example.core.main.fragment.presentation.view.SearchFragment
import com.example.core.main.fragment.presentation.view.TrailersFragment
import com.example.feature.home.screen.presentation.view.HomeFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object Home : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return HomeFragment()
        }
    }

    object Search : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return SearchFragment()
        }
    }

    object Trailers : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return TrailersFragment()
        }
    }

    object Account : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return AccountFragment()
        }
    }
}

//object OpenBrowser : SupportAppScreen() {
//    override fun getActivityIntent(context: Context?): Intent {
//        return super.getActivityIntent(context)
//    }
//}