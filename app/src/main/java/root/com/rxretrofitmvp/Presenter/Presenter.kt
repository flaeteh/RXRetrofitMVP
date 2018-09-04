package root.com.rxretrofitmvp.Presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import root.com.rxretrofitmvp.Contract.PlaceInterface
import root.com.rxretrofitmvp.Contract.interfacePresenter
import root.com.rxretrofitmvp.Contract.interfaceView

class Presenter : interfacePresenter{
    private  lateinit var mView: interfaceView
    var disposable: Disposable? = null


    fun mPresenter(view: interfaceView) {
        mView = view
    }

    val places by lazy {
        PlaceInterface.create()
    }

    fun showPlaces() {
        disposable = places.myJSON()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            result ->  mView.DataSuccess(result)
                        },
                        {
                            error -> mView.DataFail(error.message.toString())
                        }
                )

    }
}