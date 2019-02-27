package election.entities;

import java.util.Objects;

public class Party {
    private final String id;
    private final String displayName;

    public Party(String id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party = (Party) o;
        return Objects.equals(id, party.id) &&
                Objects.equals(displayName, party.displayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, displayName);
    }

    @Override
    public String toString() {
        return "Party{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}