package com.example.android2_lesson1_hw1_perizat53.utils

import android.content.Context


class Preferences(context: Context) {

    private val sharedPreference =  context.getSharedPreferences("preferences", Context.MODE_PRIVATE)

    fun setBoardingShowed(isShow:Boolean){
        sharedPreference.edit().putBoolean("board",isShow).apply()
    }

    fun isBoardingShowed():Boolean {
        return sharedPreference.getBoolean("board",false)
    }

    var imgUri:String
    set(value) = sharedPreference.edit().putString("imgUri",value).apply()
    get() = sharedPreference.getString("imgUri",
        "https://us.123rf.com/450wm/yehorlisnyi/yehorlisnyi2104/yehorlisnyi210400016/167492439-no-photo-or-blank-image-icon-loading-images-or-missing-image-mark-image-not-available-or-image.jpg?ver=6").toString()

    var saveToEditText:String
    set(value) = sharedPreference.edit().putString("name",value).apply()
    get() = sharedPreference.getString("name","name").toString()
}



