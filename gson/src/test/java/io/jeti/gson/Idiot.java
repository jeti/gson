package io.jeti.gson;

import java.io.Serializable;

public class Idiot implements Serializable {

    private final String name;
    private String       nickname;
    public final Integer height;
    public Integer       weight;

    public Idiot(String s1, String s2, Integer i1, Integer i2) {
        this.name = s1;
        this.nickname = s2;
        this.height = i1;
        this.weight = i2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Idiot that = (Idiot) o;

        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) {
            return false;
        }
        if (height != null ? !height.equals(that.height) : that.height != null) {
            return false;
        }
        return weight != null ? weight.equals(that.weight) : that.weight == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Idiot{" +
            "name='" + name + '\'' +
            ", nickname='" + nickname + '\'' +
            ", height=" + height +
            ", weight=" + weight +
            '}';
    }
}