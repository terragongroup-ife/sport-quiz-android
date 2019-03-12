package com.example.sportyquiz.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RandomQuestionsResponse implements Serializable, Parcelable
{

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    public final static Parcelable.Creator<RandomQuestionsResponse> CREATOR = new Creator<RandomQuestionsResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RandomQuestionsResponse createFromParcel(Parcel in) {
            return new RandomQuestionsResponse(in);
        }

        public RandomQuestionsResponse[] newArray(int size) {
            return (new RandomQuestionsResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 2233685757109259668L;

    protected RandomQuestionsResponse(Parcel in) {
        this.error = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.code = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.data, (com.example.sportyquiz.model.Datum.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public RandomQuestionsResponse() {
    }

    /**
     *
     * @param message
     * @param error
     * @param data
     * @param code
     */
    public RandomQuestionsResponse(Boolean error, Integer code, String message, List<Datum> data) {
        super();
        this.error = error;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(error);
        dest.writeValue(code);
        dest.writeValue(message);
        dest.writeList(data);
    }

    public int describeContents() {
        return  0;
    }

}