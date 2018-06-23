package insystem.hryharenka.weather.models;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentWeather implements Parcelable {

    @SerializedName("coord")
    @Expose
    private Coord coord;
    @SerializedName("weather")
    @Expose
    private List<Weather> weather = new ArrayList<>();
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("main")
    @Expose
    private Main main;
    @SerializedName("visibility")
    @Expose
    private Integer visibility;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;
    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("sys")
    @Expose
    private Sys sys;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cod")
    @Expose
    private Integer cod;

    public static class Clouds implements Parcelable {

        @SerializedName("all")
        @Expose
        private Integer all;
        public final static Parcelable.Creator<Clouds> CREATOR = new Creator<Clouds>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Clouds createFromParcel(Parcel in) {
                return new Clouds(in);
            }

            public Clouds[] newArray(int size) {
                return (new Clouds[size]);
            }

        };

        protected Clouds(Parcel in) {
            this.all = ((Integer) in.readValue((Integer.class.getClassLoader())));
        }

        public Clouds() {
        }

        public Integer getAll() {
            return all;
        }

        public void setAll(Integer all) {
            this.all = all;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(all);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Coord implements Parcelable {

        @SerializedName("lon")
        @Expose
        private Double lon;
        @SerializedName("lat")
        @Expose
        private Double lat;
        public final static Parcelable.Creator<Coord> CREATOR = new Creator<Coord>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Coord createFromParcel(Parcel in) {
                return new Coord(in);
            }

            public Coord[] newArray(int size) {
                return (new Coord[size]);
            }

        };

        protected Coord(Parcel in) {
            this.lon = ((Double) in.readValue((Double.class.getClassLoader())));
            this.lat = ((Double) in.readValue((Double.class.getClassLoader())));
        }

        public Coord() {
        }

        public Double getLon() {
            return lon;
        }

        public void setLon(Double lon) {
            this.lon = lon;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(lon);
            dest.writeValue(lat);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Main implements Parcelable {

        @SerializedName("temp")
        @Expose
        private Double temp;
        @SerializedName("pressure")
        @Expose
        private Double pressure;
        @SerializedName("humidity")
        @Expose
        private Double humidity;
        @SerializedName("temp_min")
        @Expose
        private Double tempMin;
        @SerializedName("temp_max")
        @Expose
        private Double tempMax;
        public final static Parcelable.Creator<Main> CREATOR = new Creator<Main>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Main createFromParcel(Parcel in) {
                return new Main(in);
            }

            public Main[] newArray(int size) {
                return (new Main[size]);
            }

        };

        protected Main(Parcel in) {
            this.temp = ((Double) in.readValue((Double.class.getClassLoader())));
            this.pressure = ((Double) in.readValue((Double.class.getClassLoader())));
            this.humidity = ((Double) in.readValue((Double.class.getClassLoader())));
            this.tempMin = ((Double) in.readValue((Double.class.getClassLoader())));
            this.tempMax = ((Double) in.readValue((Double.class.getClassLoader())));
        }

        public Main() {
        }

        public Double getTemp() {
            return temp;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Double getPressure() {
            return pressure;
        }

        public void setPressure(Double pressure) {
            this.pressure = pressure;
        }

        public Double getHumidity() {
            return humidity;
        }

        public void setHumidity(Double humidity) {
            this.humidity = humidity;
        }

        public Double getTempMin() {
            return tempMin;
        }

        public void setTempMin(Double tempMin) {
            this.tempMin = tempMin;
        }

        public Double getTempMax() {
            return tempMax;
        }

        public void setTempMax(Double tempMax) {
            this.tempMax = tempMax;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(temp);
            dest.writeValue(pressure);
            dest.writeValue(humidity);
            dest.writeValue(tempMin);
            dest.writeValue(tempMax);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Sys implements Parcelable {

        @SerializedName("type")
        @Expose
        private Integer type;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("message")
        @Expose
        private Double message;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("sunrise")
        @Expose
        private Integer sunrise;
        @SerializedName("sunset")
        @Expose
        private Integer sunset;
        public final static Parcelable.Creator<Sys> CREATOR = new Creator<Sys>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Sys createFromParcel(Parcel in) {
                return new Sys(in);
            }

            public Sys[] newArray(int size) {
                return (new Sys[size]);
            }

        };

        protected Sys(Parcel in) {
            this.type = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.message = ((Double) in.readValue((Double.class.getClassLoader())));
            this.country = ((String) in.readValue((String.class.getClassLoader())));
            this.sunrise = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.sunset = ((Integer) in.readValue((Integer.class.getClassLoader())));
        }

        public Sys() {
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Double getMessage() {
            return message;
        }

        public void setMessage(Double message) {
            this.message = message;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Integer getSunrise() {
            return sunrise;
        }

        public void setSunrise(Integer sunrise) {
            this.sunrise = sunrise;
        }

        public Integer getSunset() {
            return sunset;
        }

        public void setSunset(Integer sunset) {
            this.sunset = sunset;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(type);
            dest.writeValue(id);
            dest.writeValue(message);
            dest.writeValue(country);
            dest.writeValue(sunrise);
            dest.writeValue(sunset);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Wind implements Parcelable {

        @SerializedName("speed")
        @Expose
        private Double speed;
        @SerializedName("deg")
        @Expose
        private Double deg;
        public final static Parcelable.Creator<Wind> CREATOR = new Creator<Wind>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Wind createFromParcel(Parcel in) {
                return new Wind(in);
            }

            public Wind[] newArray(int size) {
                return (new Wind[size]);
            }

        };

        protected Wind(Parcel in) {
            this.speed = ((Double) in.readValue((Double.class.getClassLoader())));
            this.deg = ((Double) in.readValue((Double.class.getClassLoader())));
        }

        public Wind() {
        }

        public Double getSpeed() {
            return speed;
        }

        public void setSpeed(Double speed) {
            this.speed = speed;
        }

        public Double getDeg() {
            return deg;
        }

        public void setDeg(Double deg) {
            this.deg = deg;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(speed);
            dest.writeValue(deg);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Weather implements Parcelable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("main")
        @Expose
        private String main;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("icon")
        @Expose
        private String icon;
        public final static Parcelable.Creator<Weather> CREATOR = new Creator<Weather>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Weather createFromParcel(Parcel in) {
                return new Weather(in);
            }

            public Weather[] newArray(int size) {
                return (new Weather[size]);
            }

        };

        protected Weather(Parcel in) {
            this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.main = ((String) in.readValue((String.class.getClassLoader())));
            this.description = ((String) in.readValue((String.class.getClassLoader())));
            this.icon = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Weather() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(id);
            dest.writeValue(main);
            dest.writeValue(description);
            dest.writeValue(icon);
        }

        public int describeContents() {
            return 0;
        }

    }


    public final static Parcelable.Creator<CurrentWeather> CREATOR = new Creator<CurrentWeather>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CurrentWeather createFromParcel(Parcel in) {
            return new CurrentWeather(in);
        }

        public CurrentWeather[] newArray(int size) {
            return (new CurrentWeather[size]);
        }

    };

    protected CurrentWeather(Parcel in) {
        this.coord = ((Coord) in.readValue((Coord.class.getClassLoader())));
        in.readList(this.weather, (CurrentWeather.Weather.class.getClassLoader()));
        this.base = ((String) in.readValue((String.class.getClassLoader())));
        this.main = ((Main) in.readValue((Main.class.getClassLoader())));
        this.visibility = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.wind = ((Wind) in.readValue((Wind.class.getClassLoader())));
        this.clouds = ((Clouds) in.readValue((Clouds.class.getClassLoader())));
        this.dt = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sys = ((Sys) in.readValue((Sys.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.cod = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public CurrentWeather() {
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(coord);
        dest.writeList(weather);
        dest.writeValue(base);
        dest.writeValue(main);
        dest.writeValue(visibility);
        dest.writeValue(wind);
        dest.writeValue(clouds);
        dest.writeValue(dt);
        dest.writeValue(sys);
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(cod);
    }

    public int describeContents() {
        return 0;
    }

}