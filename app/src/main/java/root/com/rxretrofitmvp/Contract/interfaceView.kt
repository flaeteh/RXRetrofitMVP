package root.com.rxretrofitmvp.Contract

import root.com.rxretrofitmvp.Model.PlaceDataList

interface interfaceView {

    fun DataSuccess(list: PlaceDataList)

    fun DataFail(message: String)

}