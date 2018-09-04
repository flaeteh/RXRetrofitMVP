package root.com.rxretrofitmvp.View

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_place.view.*
import org.jetbrains.anko.image
import root.com.rxretrofitmvp.Model.PlaceDataClass
import root.com.rxretrofitmvp.R

class PlaceAdapter(
        private val placeList: List<PlaceDataClass>,
        private val listener: (PlaceDataClass) -> Int) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    override fun getItemCount() = placeList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(place: PlaceDataClass) = with(itemView) {
            hotelname.text = place.name
            //hotelimg.image = place.photo
            hotellong.text = place.long.toString()
            hotellong.text = place.long.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.list_place, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(placeList[position])

}