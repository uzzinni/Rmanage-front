package com.example.community

import android.os.Parcel
import android.os.Parcelable

data class DocumentData(
    val id: Int,
    val documentType: String,
    val documentPeriod: String,
    val documentimageUrl: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(documentType)
        parcel.writeString(documentPeriod)
        parcel.writeString(documentimageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DocumentData> {
        override fun createFromParcel(parcel: Parcel): DocumentData {
            return DocumentData(parcel)
        }

        override fun newArray(size: Int): Array<DocumentData?> {
            return arrayOfNulls(size)
        }
    }
}
