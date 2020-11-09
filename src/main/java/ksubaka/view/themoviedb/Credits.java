package ksubaka.view.themoviedb;

import java.util.List;

/**
 * Created by jpawar on 11/8/2020.
 */
public class Credits {
    public String id;
    public List<Cast> cast;
    public List<Crew> crew;

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Crew> getCrew() {
        return crew;
    }

    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }
}
