package root.com.rxretrofitmvp.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PlaceDataList {

    @SerializedName("places")
    @Expose
    var places: ArrayList<PlaceDataClass>? = null
}