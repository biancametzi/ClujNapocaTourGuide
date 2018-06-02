package com.example.bianc.cluj_napocatourguide;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {

    /**
     * Represent the location name, description, address, open hours, contact and
     * image resource ID
     */
    private String mLocationName;
    private String mLocationDescription;
    private String mLocationAddress;
    private String mLocationSchedule;
    private String mLocationPhoneNumber;
    private int mImageResourceId;

    /**
     * Create a new Location object.
     *
     * @param locationName        is the string resource ID for the location's name
     * @param locationDescription is the string resource ID for description of the location
     * @param locationAddress     is the resource ID for the address of the location
     * @param locationSchedule    is the resource ID for the operating hours of the location
     * @param locationPhoneNumber is the resource ID for the phone number of the location
     * @param imageResourceId     is the resource ID of the image associated with the location
     */

    public Location(String locationName, String locationDescription, String locationAddress,
                    String locationSchedule, String locationPhoneNumber, int imageResourceId) {
        mLocationName = locationName;
        mLocationDescription = locationDescription;
        mLocationAddress = locationAddress;
        mLocationSchedule = locationSchedule;
        mLocationPhoneNumber = locationPhoneNumber;
        mImageResourceId = imageResourceId;
    }

    /**
     * Create a new Location object.
     *
     * @param locationName        is the string resource ID for the location's name
     * @param locationDescription is the string resource ID for description of the location
     * @param locationAddress     is the resource ID for the address of the location
     * @param locationSchedule    is the resource ID for the operating hours of the location
     * @param imageResourceId     is the resource ID of the image associated with the location
     */

    public Location(String locationName, String locationDescription, String locationAddress,
                    String locationSchedule, int imageResourceId) {
        mLocationName = locationName;
        mLocationDescription = locationDescription;
        mLocationAddress = locationAddress;
        mLocationSchedule = locationSchedule;
        mImageResourceId = imageResourceId;
    }

    public Location(Parcel in) {
        mLocationName = in.readString();
        mLocationDescription = in.readString();
        mLocationAddress = in.readString();
        mLocationSchedule = in.readString();
        mLocationPhoneNumber = in.readString();
        mImageResourceId = in.readInt();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    /**
     * Get the string resource ID for the name of the location.
     */
    public String getLocationName() {
        return mLocationName;
    }

    /**
     * Get the string resource ID for the description of the location.
     */
    public String getLocationDescription() {
        return mLocationDescription;
    }

    /**
     * Get the string resource ID for the address of the location.
     */
    public String getLocationAddress() {
        return mLocationAddress;
    }

    /**
     * Get the string resource ID for the operating hours of the location.
     */
    public String getlocationSchedule() {
        return mLocationSchedule;
    }

    /**
     * Get the string resource ID for the phone number of the location.
     */
    public String getlocationPhoneNumber() {
        return mLocationPhoneNumber;
    }

    /**
     * Get the image resource ID of the location.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mLocationName);
        dest.writeString(mLocationDescription);
        dest.writeString(mLocationAddress);
        dest.writeString(mLocationSchedule);
        dest.writeString(mLocationPhoneNumber);
        dest.writeInt(mImageResourceId);
    }
}