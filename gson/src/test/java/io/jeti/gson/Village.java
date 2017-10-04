package io.jeti.gson;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Village implements Serializable {

    private final List<Idiot> idiots;
    private final float[]     ages;

    public Village(List<Idiot> idiots, float[] ages) {
        this.idiots = idiots;
        this.ages = ages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Village village = (Village) o;

        if (idiots != null ? !idiots.equals(village.idiots) : village.idiots != null) {
            return false;
        }
        return Arrays.equals(ages, village.ages);
    }

    @Override
    public int hashCode() {
        int result = idiots != null ? idiots.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(ages);
        return result;
    }

    @Override
    public String toString() {
        return "Village{" +
            "idiots=" + idiots +
            ", ages=" + Arrays.toString(ages) +
            '}';
    }
}