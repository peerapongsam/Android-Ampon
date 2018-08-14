package com.peerapongsam.labs.ampon;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    int id;
    String name;
    Double price;
    int image;
    int qty = 0;

    public Product(int id, String name, Double price, int image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", image=" + image +
                ", qty=" + qty +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeValue(this.price);
        dest.writeInt(this.image);
        dest.writeInt(this.qty);
    }

    protected Product(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.price = (Double) in.readValue(Double.class.getClassLoader());
        this.image = in.readInt();
        this.qty = in.readInt();
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
