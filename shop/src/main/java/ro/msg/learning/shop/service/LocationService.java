package ro.msg.learning.shop.service;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.repository.exception.LocationNotFoundException;
import ro.msg.learning.shop.model.Location;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.repository.LocationRepository;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }


    Location getLocationById(@PathVariable int id) {
        return locationRepository.findById(id).orElseThrow(() -> new LocationNotFoundException(id));
    }

    Location addLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }
}
