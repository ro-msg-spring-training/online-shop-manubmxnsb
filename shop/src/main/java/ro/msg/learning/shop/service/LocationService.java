package ro.msg.learning.shop.service;

import ro.msg.learning.shop.repository.exception.LocationNotFoundException;
import ro.msg.learning.shop.model.Location;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.repository.LocationRepository;

import java.util.List;

public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @GetMapping("/locations")
    List<Location> all() {
        return locationRepository.findAll();
    }

    @GetMapping("/locations/{id}")
    Location one(@PathVariable int id) {
        return locationRepository.findById(id).orElseThrow(() -> new LocationNotFoundException(id));
    }

    @PostMapping("/locations")
    Location location(@RequestBody Location location) {
        return locationRepository.save(location);
    }
}
