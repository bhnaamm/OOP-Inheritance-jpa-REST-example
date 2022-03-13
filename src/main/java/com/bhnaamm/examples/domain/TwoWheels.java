package com.bhnaamm.examples.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "two_wheels")
@NoArgsConstructor
public class TwoWheels extends Car<TwoWheels> {


    public static class TwoWheelBuilder extends Car.Builder{
        @Override
        public TwoWheels build() {
            return new TwoWheels(this);
        }
    }

    public TwoWheels(final TwoWheelBuilder builder) {
        super(builder);
    }
    @Override
    public void drive() {

    }
}
