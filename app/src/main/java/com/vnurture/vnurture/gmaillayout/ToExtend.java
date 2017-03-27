/*package com.vnurture.vnurture.gmaillayout;

import android.os.Parcel;
import android.os.Parcelable;



public class ToExtend implements Parcelable {

    public String title;
    public String description;
    public boolean isExpanded;

    public  ToExtend(){}

    public ToExtend(Parcel in){
        title = in.readString();
        description = in.readString();
        isExpanded = in.readInt() == 1;
    }



    public static final Creator<ToExtend> CREATOR = new Creator<ToExtend>() {
        @Override
        public ToExtend createFromParcel(Parcel in) {
            return new ToExtend(in);
        }

        @Override
        public ToExtend[] newArray(int size) {
            return new ToExtend[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeInt(isExpanded ? 1 : 0);

    }
}*/
