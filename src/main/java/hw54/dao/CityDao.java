package hw54.dao;

import hw54.model.City;

import java.util.Optional;

public interface CityDao {

    Optional<City> findById(long id);
}
