package es.davidsans.myapprecycler.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by android on 15/03/2018.
 */

public class Animals implements Parcelable {

    @SerializedName("Image")
    int img;

    String nombre;
    String nombreBiologico;
    String ubicacion;

    public Animals(int img, String nombre, String nombreBiologico, String ubicacion) {
        this.img = img;
        this.nombre = nombre;
        this.nombreBiologico = nombreBiologico;
        this.ubicacion = ubicacion;
    }


    public int getImg() {
        return img;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreBiologico() {
        return nombreBiologico;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.img);
        dest.writeString(this.nombre);
        dest.writeString(this.nombreBiologico);
        dest.writeString(this.ubicacion);
    }

    protected Animals(Parcel in) {
        this.img = in.readInt();
        this.nombre = in.readString();
        this.nombreBiologico = in.readString();
        this.ubicacion = in.readString();
    }

    public static final Parcelable.Creator<Animals> CREATOR = new Parcelable.Creator<Animals>() {
        @Override
        public Animals createFromParcel(Parcel source) {
            return new Animals(source);
        }

        @Override
        public Animals[] newArray(int size) {
            return new Animals[size];
        }
    };
}
