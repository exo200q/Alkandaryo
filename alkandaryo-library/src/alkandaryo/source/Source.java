package alkandaryo.source;

import java.io.Serializable;
import java.util.Objects;

public class Source<S extends Source<?>> implements Serializable {
    private String description;
    private String name;

    public Source() {
        this.description = null;
        this.name        = null;
    }

    public Source(String name) {
        this.description = null;
        this.name        = name;
    }

    public Source(String name, String description) {
        this.description = description;
        this.name        = name;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unchecked")
    public S setDescription(String description) {
        this.description = description;
        return (S) this;
    }

    @SuppressWarnings("unchecked")
    public S setName(String name) {
        this.name = name;
        return (S) this;
    }

    @Override
    public boolean equals(Object object) {
        return     Objects.equals(((Source<?>) object).description, description)
                && Objects.equals(((Source<?>) object).name,        name);
    }

    @Override
    public String toString() {
        return     !Objects.isNull(description)
                && !Objects.isNull(name)
                    ? String.format("%s, %s",
                        name,
                        description)
                :  !Objects.isNull(description) ? description
                :  !Objects.isNull(name)        ? name
                : null;
    }
}
