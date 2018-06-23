package insystem.hryharenka.weather.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Forecast implements Parcelable {

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Double message;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<insystem.hryharenka.weather.models.Forecast.List> list = new ArrayList<>();
    @SerializedName("city")
    @Expose
    private City city;

    public static class List implements Parcelable {

        @SerializedName("dt")
        @Expose
        private Integer dt;
        @SerializedName("main")
        @Expose
        private CurrentWeather.Main main;
        @SerializedName("weather")
        @Expose
        private java.util.List<CurrentWeather.Weather> weather = new ArrayList<>();
        @SerializedName("clouds")
        @Expose
        private CurrentWeather.Clouds clouds;
        @SerializedName("wind")
        @Expose
        private CurrentWeather.Wind wind;
        @SerializedName("snow")
        @Expose
        private Snow snow;
        @SerializedName("sys")
        @Expose
        private CurrentWeather.Sys sys;
        @SerializedName("dt_txt")
        @Expose
        private String dtTxt;

        public static class Snow implements Parcelable {

            @SerializedName("3h")
            @Expose
            private Double _3h;
            public final static Parcelable.Creator<Snow> CREATOR = new Creator<Snow>() {


                @SuppressWarnings({
                        "unchecked"
                })
                public Snow createFromParcel(Parcel in) {
                    return new Snow(in);
                }

                public Snow[] newArray(int size) {
                    return (new Snow[size]);
                }

            };

            protected Snow(Parcel in) {
                this._3h = ((Double) in.readValue((Double.class.getClassLoader())));
            }

            public Snow() {
            }

            public Double get3h() {
                return _3h;
            }

            public void set3h(Double _3h) {
                this._3h = _3h;
            }

            public void writeToParcel(Parcel dest, int flags) {
                dest.writeValue(_3h);
            }

            public int describeContents() {
                return 0;
            }

        }

        public final static Parcelable.Creator<List> CREATOR = new Creator<List>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public List createFromParcel(Parcel in) {
                return new List(in);
            }

            public List[] newArray(int size) {
                return (new List[size]);
            }

        };

        protected List(Parcel in) {
            this.dt = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.main = ((CurrentWeather.Main) in.readValue((CurrentWeather.Main.class.getClassLoader())));
            in.readList(this.weather, (insystem.hryharenka.weather.models.CurrentWeather.Weather.class.getClassLoader()));
            this.clouds = ((CurrentWeather.Clouds) in.readValue((CurrentWeather.Clouds.class.getClassLoader())));
            this.wind = ((CurrentWeather.Wind) in.readValue((CurrentWeather.Wind.class.getClassLoader())));
            this.snow = ((Snow) in.readValue((Snow.class.getClassLoader())));
            this.sys = ((CurrentWeather.Sys) in.readValue((CurrentWeather.Sys.class.getClassLoader())));
            this.dtTxt = ((String) in.readValue((String.class.getClassLoader())));
        }

        public List() {
        }

        public Integer getDt() {
            return dt;
        }

        public void setDt(Integer dt) {
            this.dt = dt;
        }

        public CurrentWeather.Main getMain() {
            return main;
        }

        public void setMain(CurrentWeather.Main main) {
            this.main = main;
        }

        public java.util.List<CurrentWeather.Weather> getWeather() {
            return weather;
        }

        public void setWeather(java.util.List<CurrentWeather.Weather> weather) {
            this.weather = weather;
        }

        public CurrentWeather.Clouds getClouds() {
            return clouds;
        }

        public void setClouds(CurrentWeather.Clouds clouds) {
            this.clouds = clouds;
        }

        public CurrentWeather.Wind getWind() {
            return wind;
        }

        public void setWind(CurrentWeather.Wind wind) {
            this.wind = wind;
        }

        public Snow getSnow() {
            return snow;
        }

        public void setSnow(Snow snow) {
            this.snow = snow;
        }

        public CurrentWeather.Sys getSys() {
            return sys;
        }

        public void setSys(CurrentWeather.Sys sys) {
            this.sys = sys;
        }

        public String getDtTxt() {
            return dtTxt;
        }

        public void setDtTxt(String dtTxt) {
            this.dtTxt = dtTxt;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(dt);
            dest.writeValue(main);
            dest.writeList(weather);
            dest.writeValue(clouds);
            dest.writeValue(wind);
            dest.writeValue(snow);
            dest.writeValue(sys);
            dest.writeValue(dtTxt);
        }

        public int describeContents() {
            return 0;
        }

    }

    public final static Parcelable.Creator<Forecast> CREATOR = new Creator<Forecast>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Forecast createFromParcel(Parcel in) {
            return new Forecast(in);
        }

        public Forecast[] newArray(int size) {
            return (new Forecast[size]);
        }

    };

    protected Forecast(Parcel in) {
        this.cod = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((Double) in.readValue((Double.class.getClassLoader())));
        this.cnt = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.list, (insystem.hryharenka.weather.models.Forecast.List.class.getClassLoader()));
        this.city = ((City) in.readValue((City.class.getClassLoader())));
    }

    public Forecast() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<insystem.hryharenka.weather.models.Forecast.List> getList() {
        return list;
    }

    public void setList(java.util.List<insystem.hryharenka.weather.models.Forecast.List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(cod);
        dest.writeValue(message);
        dest.writeValue(cnt);
        dest.writeList(list);
        dest.writeValue(city);
    }

    public int describeContents() {
        return 0;
    }

}