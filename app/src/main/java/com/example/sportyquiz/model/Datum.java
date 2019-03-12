package com.example.sportyquiz.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum implements Serializable, Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("answer")
    @Expose
    private String answer;
    @SerializedName("options")
    @Expose
    private List<String> options = null;
    public final static Parcelable.Creator<Datum> CREATOR = new Creator<Datum>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        public Datum[] newArray(int size) {
            return (new Datum[size]);
        }

    }
            ;
    private final static long serialVersionUID = 3850083388826386213L;

    protected Datum(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.question = ((String) in.readValue((String.class.getClassLoader())));
        this.answer = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.options, (java.lang.String.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Datum() {
    }

    /**
     *
     * @param id
     * @param answer
     * @param question
     * @param options
     */
    public Datum(String id, String question, String answer, List<String> options) {
        super();
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.options = options;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(question);
        dest.writeValue(answer);
        dest.writeList(options);
    }

    public int describeContents() {
        return  0;
    }

}