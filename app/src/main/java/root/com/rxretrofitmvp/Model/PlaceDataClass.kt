package root.com.rxretrofitmvp.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PlaceDataClass {

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("photo")
    @Expose
    var photo: String? = null

    @SerializedName("long")
    @Expose
    var long: Double? = null

    @SerializedName("lat")
    @Expose
    var lat: Double? = null

    @SerializedName("phone")
    @Expose
    var phone: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null
}