package com.bhnaamm.examples.service;


import com.bhnaamm.examples.domain.Car;
import com.bhnaamm.examples.domain.enumeration.CarType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CarService {
    /**
     * Save a Car based.
     *
     * @param car the entity to save.
     * @return the persisted entity.
     */
    Car save(Car car);

    /**
     * Partially updates a car.
     *
     * @param car the entity to update partially.
     * @return the persisted entity.
     */

    /**
     * Get all the cars.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Car> findAll(Pageable pageable, CarType carType);

    /**
     * Get the "id" car.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Car> findOne(Long id);

}
