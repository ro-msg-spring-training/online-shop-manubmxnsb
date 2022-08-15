package ro.msg.learning.shop.service;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.repository.exception.LocationNotFoundException;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.repository.LocationRepository;

import javax.xml.stream.Location;
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


    public Location getLocationById(@PathVariable int id) {
        return locationRepository.findById(id).orElseThrow(() -> new LocationNotFoundException(id));
    }

    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }
}
