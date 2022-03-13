package com.bhnaamm.examples.domain;


import com.bhnaamm.examples.domain.enumeration.CabinType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sport")
@Data
@NoArgsConstructor
public class Sport extends Car<Sport>{

    private int horsePower;

    private CabinType cabinType;

    public Sport(final SportBuilder builder) {
        super(builder);
        this.horsePower = builder.horsePower;
    }

    public void drive() {

    }

    public static class SportBuilder extends Car.Builder<Sport> {

        private int horsePower;

        public Builder setHorsePower(int horsePower){
            this.horsePower = horsePower;
            return this;
        }
        @Override
        public Sport build() {
            return new Sport(this);
        }
    }
}
