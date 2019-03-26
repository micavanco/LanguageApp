package com.micavanco.languageapp.Database;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Data
@RequiredArgsConstructor
public class Language {

    private final String id;
    private final String name;
    private final Type type;



    public static enum Type
    {
        German, Spanish, Norwegian
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(id, language.id) &&
                Objects.equals(name, language.name) &&
                type == language.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
