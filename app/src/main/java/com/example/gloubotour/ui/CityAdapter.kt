package com.example.gloubotour

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.sriyank.globotour.city.City

class CityAdapter (val context :Context,var cityList:ArrayList<City>): RecyclerView.Adapter<CityAdapter.CityViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityAdapter.CityViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item_city,parent,false)
        return  CityViewHolder(itemView = itemView)

    }

    override fun onBindViewHolder(holder: CityAdapter.CityViewHolder, position: Int) {
        val city = cityList[position]
        holder.setData(city,position)



    }

    override fun getItemCount(): Int = cityList.size




 inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

     private var currentPosition :Int = -1
     private var currentCity :City? = null



     private  val textCityName  = itemView.findViewById<TextView>(R.id.txv_city_name)
     private  val imageCity = itemView.findViewById<ImageView>(R.id.imv_city)
     private  val imageDelete= itemView.findViewById<ImageView>(R.id.imv_delete)
     private  val imageFavorite = itemView.findViewById<ImageView>(R.id.imv_favorite)

     private val isFavoirateFilledImageView = ResourcesCompat.getDrawable(context.resources,R.drawable.ic_favorite_filled,null)
     private val isFavoirateBoaredImageView = ResourcesCompat.getDrawable(context.resources,R.drawable.ic_favorite_bordered,null)


     fun setData(city: City, position: Int) {

         textCityName.text = city.name
         imageCity.setImageResource(city.imageId)




         if (city.isFavorite)
             imageFavorite.setImageDrawable(isFavoirateBoaredImageView)
         else
             imageFavorite.setImageDrawable(isFavoirateFilledImageView)



         this.currentCity = city
         this.currentPosition = position

     }


 }


}