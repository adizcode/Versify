package com.github.adizcode.versify.model

import android.os.Parcel
import android.os.Parcelable

data class Verse(var name: String = "", var contents: String = ""): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(contents)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Verse> {
        override fun createFromParcel(parcel: Parcel): Verse {
            return Verse(parcel)
        }

        override fun newArray(size: Int): Array<Verse?> {
            return arrayOfNulls(size)
        }
    }
}

val versesList = mutableListOf(
    Verse("Sick", "I'm sick yo"),
    Verse("Lin", "I'm sick do"),
    Verse("Nick", "I'm sick xyo"),
    Verse("Shin", "I'm sifasdck yo"),
    Verse("Tim", "I'm sick dafdsfafssyo")
)
