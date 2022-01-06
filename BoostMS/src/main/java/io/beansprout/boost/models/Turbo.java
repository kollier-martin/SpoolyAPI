package io.beansprout.boost.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * This is the POJO for the Turbo component that comes with some cars
 * @author Kollier Martin
 * @date 1/4/2022
 */

@Getter
@Setter
@Entity
@ToString
@RequiredArgsConstructor
public class Turbo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NotNull
    private String name;

    @Column
    @NotNull
    private Integer sizeInMM;

    @Column
    @NotNull
    private Integer hpMin;

    @Column
    @NotNull
    private Integer hpMax;

    @Column
    @NotNull
    private Integer psi;

    @Column
    @NotNull
    private String manufacturer;

    @Column
    @NotNull
    private String link;

    @Column
    @NotNull
    private String displacement;

    @NotNull
    @OneToOne
    private Compressor compressor;

    @NotNull
    @OneToOne
    private Turbine turbine;

    @Enumerated
    private Rotation rotation;
    public enum Rotation{
        STANDARD,
        REVERSE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;

        Turbo turbo = (Turbo) o;
        return id != null && Objects.equals(id, turbo.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Entity
    @Getter
    @Setter
    @ToString
    @RequiredArgsConstructor
    public static class Compressor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @NotNull
        @OneToOne(mappedBy = "compressor")
        private Turbo turbo;

        @Column
        @NotNull
        private Float inducer;

        @Column
        @NotNull
        private Float exducer;

        @Column
        @NotNull
        private Integer trim;

        @Column(name = "ar")
        @NotNull
        private Float ar;
    }

    @Entity
    @Getter
    @Setter
    @ToString
    @RequiredArgsConstructor
    public static class Turbine {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @NotNull
        @OneToOne(mappedBy = "turbine")
        private Turbo turbo;

        @Column
        @NotNull
        private Float inducer;

        @Column
        @NotNull
        private Float exducer;

        @Column
        @NotNull
        private Integer trim;
    }
}