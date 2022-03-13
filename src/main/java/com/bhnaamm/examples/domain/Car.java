package com.bhnaamm.examples.domain;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.bhnaamm.examples.domain.enumeration.ColorEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Car Superclass
 *
 */

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Sport.class, name = "sport"),
        @JsonSubTypes.Type(value = Electrical.class, name = "electrical"),
        @JsonSubTypes.Type(value = TwoWheels.class, name = "two_wheels")
})
public abstract class Car<T extends Car<T>> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "color")
    private ColorEnum color;


    @Column
    private String registrationNumber;

    @Column(name = "manufacturing_date", columnDefinition = "DATE")
    private LocalDate manufacturingDate;

    @Column(name = "price")
    private BigDecimal price;

    public abstract void drive(); //an example of functionality that all child classes need to implement.

    public static abstract class Builder<T>{
        private String name;
        private String manufacturer;
        private ColorEnum color;
        private Owner owner;
        private String registrationNumber;
        private LocalDate manufacturingDate;

        public Builder<T> carBuilder(String name, String manufacturer,
                     ColorEnum color, String registrationNumber,
                     LocalDate manufacturingDate){
            this.name = name;
            this.manufacturer = manufacturer;
            this.color = color;
            this.registrationNumber = registrationNumber;
            this.manufacturingDate = manufacturingDate;
            return this;
        }

        public abstract T build();

    }

    protected Car(final Builder<T> builder){
         this.name = builder.name;
         this.manufacturer = builder.manufacturer;
         this.color = builder.color;
         this.registrationNumber = builder.registrationNumber;
         this.manufacturingDate = builder.manufacturingDate;
    }


}
