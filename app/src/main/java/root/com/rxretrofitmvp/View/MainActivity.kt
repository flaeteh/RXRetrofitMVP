package root.com.rxretrofitmvp.View

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import root.com.rxretrofitmvp.Contract.interfaceView
import root.com.rxretrofitmvp.Model.PlaceDataClass
import root.com.rxretrofitmvp.Model.PlaceDataList
import root.com.rxretrofitmvp.Presenter.Presenter
import root.com.rxretrofitmvp.R
import java.util.ArrayList

class MainActivity : BaseView(), interfaceView {

    var recyclerView: RecyclerView? = null
    var eAdapter: PlaceAdapter? = null
    lateinit var mPresenter : Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showProgressDialog()

        mPresenter = Presenter()
        mPresenter.mPresenter(this)
        mPresenter.showPlaces()
    }

    fun Recycler(placesList: List<PlaceDataClass>) {
        recyclerView!!.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this@MainActivity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = PlaceAdapter(placesList) {
            Log.v("", it.name)
        }
    }


    override fun DataSuccess(list: PlaceDataList) {
        dismissProgressDialog()
        Recycler(list.places as ArrayList)
    }

    override fun DataFail(message: String) {
        Log.v("error", message)
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}
