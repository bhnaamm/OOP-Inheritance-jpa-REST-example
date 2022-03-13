package com.bhnaamm.examples.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "electrical")
public class Electrical extends Car<Electrical>{

    private int batteryDuration;


    public static class ElectricalBuilder extends Car.Builder<Electrical>{
        private int batteryDuration;

        public Builder setBatteryDuration(int duration){
            this.batteryDuration = duration;
            return this;
        }
        @Override
        public Electrical build() {
            return new Electrical(this);
        }
    }

    public Electrical(final ElectricalBuilder builder) {
        super(builder);
        this.batteryDuration = builder.batteryDuration;
    }

    @Override
    public void drive() {

    }
}
