package io.beansprout.boost.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Supercharger implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NotNull
    private String name;

    @Column
    @NotNull
    private String manufacturer;

    @Column
    @NotNull
    private Float housingDiameter;

    @Column
    @NotNull
    private Integer hpMax;

    @Column
    @NotNull
    private Integer baseHpMin;

    @Column
    @NotNull
    private Integer baseHpMax;

    @Column
    @NotNull
    private Integer maxFlow;

    @Column
    @NotNull
    private Integer psi;

    @Column
    @NotNull
    private Float inletHoseDiameter;

    @Column
    @NotNull
    private Float inducerDiameter;

    @Column
    @NotNull
    private Float exducerDiameter;

    @Column
    @NotNull
    private Float outletHoseDiameter;

    @Column
    @NotNull
    private Float outletID;

    @Column
    @NotNull
    private Integer maxImpellerRPM;

    @Column
    @NotNull
    private String internalStepUpRatio;

    @Enumerated
    private Rotation rotation;
    public enum Rotation{
        STANDARD,
        REVERSE
    }

    @Column
    @NotNull
    private Boolean selfContainedOil;

    @Column
    @NotNull
    private Float oilCapacity;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;

        Supercharger that = (Supercharger) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
