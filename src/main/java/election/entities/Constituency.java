package election.entities;

import java.util.Objects;

public class Constituency {
    private String name;

    public Constituency(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constituency that = (Constituency) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Constituency{" +
                "name='" + name + '\'' +
                '}';
    }
}
