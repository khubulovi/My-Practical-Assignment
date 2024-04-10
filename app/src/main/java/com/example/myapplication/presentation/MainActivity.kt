package com.example.myapplication.presentation
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.PopularLabraries.Navigation.navigationHolder
import com.example.myapplication.PopularLabraries.Navigation.router
import com.example.myapplication.data.network.NetworkState
import com.example.myapplication.data.network.NetworkStateObservable
import com.example.myapplication.presentation.conventer.ConverterScreen
import com.github.terrakok.cicerone.androidx.AppNavigator
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpAppCompatActivity
import java.util.concurrent.TimeUnit
class MainActivity : MvpAppCompatActivity() {
    private val navigator = AppNavigator(this, android.R.id.content)
    private val disposable = CompositeDisposable()

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.newRootScreen(ConverterScreen)

        val connect =
            NetworkStateObservable(this)
                .doOnNext { onNext(this, 0, it) }
                .publish()
        connect.connect()

        disposable.add(
            connect.delay(32L, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe { onNext(this, 1, it) })
        disposable.add(connect.delay(16L, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
            .subscribe { onNext(this, 2, it) })
        disposable.add(connect.delay(8L, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
            .subscribe { onNext(this, 3, it) })
    }

    private fun onNext(context: Context, no: Int, state: NetworkState) {
        Toast.makeText(context, "$no: NetworkState: $state", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}