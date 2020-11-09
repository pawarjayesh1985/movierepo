package ksubaka.view.omdb;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jpawar on 11/8/2020.
 */
public class Rating {
    @JsonProperty("Source")
    public String source;
    @JsonProperty("Value")
    public String value;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating = (Rating) o;

        if (!source.equals(rating.source)) return false;
        if (!value.equals(rating.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = source.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
