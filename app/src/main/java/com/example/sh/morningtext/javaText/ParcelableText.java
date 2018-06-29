package com.example.sh.morningtext.javaText;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * java 序列化
 */
public class ParcelableText {

}


class ParcelablePerson implements Parcelable{

    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected ParcelablePerson(Parcel in) {
    }

    public static final Creator<ParcelablePerson> CREATOR = new Creator<ParcelablePerson>() {
        @Override
        public ParcelablePerson createFromParcel(Parcel in) {
            return new ParcelablePerson(in);
        }

        @Override
        public ParcelablePerson[] newArray(int size) {
            return new ParcelablePerson[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    /**
     * 自定义序列化字段 写在parcel中
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeString(name);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}