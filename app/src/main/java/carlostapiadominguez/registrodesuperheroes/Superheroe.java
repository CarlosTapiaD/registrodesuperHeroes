package carlostapiadominguez.registrodesuperheroes;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Carlos Tapia D on 27/06/17.
 */

public class Superheroe implements Parcelable {
    public String cName;
    public String cLastName;
    public String cNameHero;
    public String cAge;
    public String cAddress;
    public String cCity;

    public Superheroe(){

    }
    public Superheroe(String name,String lastName,String nameHero,String age,String address,String city){
        this.cName = name;
        this.cLastName=lastName;
        this.cNameHero=nameHero;
        this.cAge=age;
        this.cAddress=address;
        this.cCity=city;


    }

    protected Superheroe(Parcel in) {
        cName = in.readString();
        cLastName = in.readString();
        cNameHero = in.readString();
        cAge = in.readString();
        cAddress = in.readString();
        cCity = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cName);
        dest.writeString(cLastName);
        dest.writeString(cNameHero);
        dest.writeString(cAge);
        dest.writeString(cAddress);
        dest.writeString(cCity);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Superheroe> CREATOR = new Parcelable.Creator<Superheroe>() {
        @Override
        public Superheroe createFromParcel(Parcel in) {
            return new Superheroe(in);
        }

        @Override
        public Superheroe[] newArray(int size) {
            return new Superheroe[size];
        }
    };
}







/*package carlostapiadominguez.registrodesuperheroes;

/**
 * Created by Carlos Tapia D on 27/06/17.
 */
/*
public class Superheroe {
    public String cName;
    public String cLastName;
    public String cNameHero;
    public String cAge;
    public String cAddress;
    public String cCity;

    public Superheroe(){

    }
    public Superheroe(String name,String lastName,String nameHero,String age,String address,String city){
        this.cName = name;
        this.cLastName=lastName;
        this.cNameHero=nameHero;
        this.cAge=age;
        this.cAddress=address;
        this.cCity=city;


    }
}*/