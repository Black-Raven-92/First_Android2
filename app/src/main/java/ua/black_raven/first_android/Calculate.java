package ua.black_raven.first_android;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Calculate implements Parcelable {
    float firstValue, secondValue;
    boolean plus, minus, div, multiply, dot;
    String text;

    public Calculate() {
        firstValue = 0f;
        secondValue = 0f;
        plus = false;
        minus = false;
        div = false;
        multiply = false;
        text = "";
    }

    public void Clear(TextView textView) {
        text = "";
        firstValue = 0f;
        secondValue = 0f;
        textView.setText(this.text);
    }

    public void Plus(TextView textView) {
        firstValue = Float.parseFloat(textView.getText() + "");
        plus = true;
        textView.setText(null);

    }

    public void Minus(TextView textView) {
        firstValue = Float.parseFloat(textView.getText() + "");
        minus = true;
        textView.setText(null);
    }


    public void Multiply(TextView textView) {
        firstValue = Float.parseFloat(textView.getText() + "");
        multiply = true;
        textView.setText(null);
    }

    public void Dev(TextView textView) {
        firstValue = Float.parseFloat(textView.getText() + "");
        div = true;
        textView.setText(null);
    }

    public void Equals(TextView textView) {
        if (textView.getText().length() != 0 & (minus || plus || div || multiply)) {
            secondValue = Float.parseFloat(textView.getText() + "");
            if (plus) {
                text = (firstValue + secondValue) + "";
                textView.setText(text);
                plus = false;
            }
            if (minus) {
                text = (firstValue - secondValue) + "";
                textView.setText(text);
                minus = false;
            }
            if (multiply) {
                text = (firstValue * secondValue) + "";
                textView.setText(text);
                multiply = false;
            }
            if (div) {
                text = (firstValue / secondValue) + "";
                textView.setText(text);
                div = false;
            }

        }
    }

    public String getText() {
        return text;
    }

    public void setText(TextView textView, Button button) {
        this.text = textView.getText() + (String) button.getText();
        textView.setText(this.text);
    }

    protected Calculate(Parcel in) {
        if (in.readByte() == 0) {
            firstValue = Float.parseFloat(null);
        } else {
            firstValue = (float) in.readDouble();
        }
        if (in.readByte() == 0) {
            secondValue = Float.parseFloat(null);
        } else {
            secondValue = (float) in.readDouble();
        }
        plus = in.readByte() != 0;
        minus = in.readByte() != 0;
        div = in.readByte() != 0;
        multiply = in.readByte() != 0;
        text = in.readString();
    }
    public void setDot(TextView textView){
        for (int i = 0; i < textView.length(); i++) {
            if(textView.getText().charAt(i)=='.'){
                dot=true;
                break;

            }else dot=false;


        }
        if(!dot) {
            this.text=(textView.getText()+".");
            textView.setText(this.text);
        }

    }

    public static final Creator<Calculate> CREATOR = new Creator<Calculate>() {
        @Override
        public Calculate createFromParcel(Parcel in) {
            return new Calculate(in);
        }

        @Override
        public Calculate[] newArray(int size) {
            return new Calculate[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) 1);
        dest.writeDouble(firstValue);
        dest.writeByte((byte) 1);
        dest.writeDouble(secondValue);
        dest.writeByte((byte) (plus ? 1 : 0));
        dest.writeByte((byte) (minus ? 1 : 0));
        dest.writeByte((byte) (div ? 1 : 0));
        dest.writeByte((byte) (multiply ? 1 : 0));
        dest.writeString(text);
    }
}
