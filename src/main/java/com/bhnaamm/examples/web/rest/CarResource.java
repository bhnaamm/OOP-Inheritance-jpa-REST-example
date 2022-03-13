package com.bhnaamm.examples.web.rest;

import com.bhnaamm.examples.config.RequiresConversion;
import com.bhnaamm.examples.domain.Car;
import com.bhnaamm.examples.domain.enumeration.CarType;
import com.bhnaamm.examples.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
@Transactional
public class CarResource {

    private final Logger log = LoggerFactory.getLogger(CarResource.class);

    private static final String ENTITY_NAME = "car";

    private final CarService carService;

    @Autowired
    public CarResource(CarService carService) {
        this.carService = carService;
    }

    /**
     * {@code POST  /cars/:type} : Creates a new car.
     *
     * @param type the type of the car to save; sport, two wheels, or electrical in the body.
     * @param car the car to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new car, or with status {@code 400 (Bad Request)} if the car has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody final Car car) throws URISyntaxException {

        if (car.getId() != null) {
            // BAD REQUEST EXCEPTION
        }

        Car result = carService.save(car);

        return ResponseEntity
                .created(new URI("/api/cars/" +result.getId()))
                .body(result);
    }

    /**
     * {@code PUT  /cars/:id} : Updates an existing car.
     *
     * @param id the id of the car to save.
     * @param car the car to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated car,
     * or with status {@code 400 (Bad Request)} if the car is not valid,
     * or with status {@code 500 (Internal Server Error)} if the car couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable(value = "id", required = false) final Long id, @RequestBody Car car)
            throws URISyntaxException {
     return null;
    }

    /**
     * {@code GET  /cars} : get all the cars.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cars in body.
     */
    @GetMapping("/cars/{type}")
    public ResponseEntity<List<Car>> getAllCars(
            Pageable pageable,@RequiresConversion @PathVariable(name = "type") CarType type) {
        Page<Car> page;
        page = carService.findAll(pageable, type);

        return ResponseEntity.ok().body(page.getContent());
    }


}
