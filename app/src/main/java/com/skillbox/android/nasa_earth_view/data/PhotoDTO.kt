package com.skillbox.android.nasa_earth_view.data

import com.skillbox.android.nasa_earth_view.network.NasaService

data class PhotoDTO(val identifier:String, val caption: String
    , val image: String, val date: String  ) {

    fun ImageUrl() : String? {
        //https://api.nasa.gov/EPIC/archive/enhanced/2016/12/04/png/epic_RBG_20161204003633.png?api_key=DEMO_KEY
        val sb = StringBuilder()
        sb.append("https://api.nasa.gov/EPIC/archive/natural/")
        val dateComponents = date.split(" ").toTypedArray()[0]
            .split("-").toTypedArray()
        sb
            .append(dateComponents[0]).append('/')
            .append(dateComponents[1]).append('/')
            .append(dateComponents[2]).append("/png/")
            .append(image).append(".png?api_key=").append(NasaService.KEY)
        return sb.toString()
    }

}
