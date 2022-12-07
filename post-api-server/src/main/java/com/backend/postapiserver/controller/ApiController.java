package com.backend.postapiserver.controller;

import com.backend.postapiserver.entity.*;
import com.backend.postapiserver.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ApiController {

    private PersonRepository personRepository;
    private UserRepository userRepository;
    private AddressRepository addressRepository;
    private UniveristyRepository univeristyRepository;
    private StreamRepository streamRepository;
    private ViewerRepository viewerRepository;

    @PostMapping("/person")
    public ResponseEntity<Object> savePerson(@RequestBody Person person) {
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PostMapping("/user")
    public ResponseEntity<Object> saveUser(@RequestBody Users user) {
        addressRepository.save(user.getAddress());
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/university")
    public ResponseEntity<Object> saveUser(@RequestBody University university) {
        univeristyRepository.save(university);
        return new ResponseEntity<>(university, HttpStatus.CREATED);
    }

    @PostMapping("/viewers")
    public ResponseEntity<Object> saveViewers(@RequestBody List<Viewer> viewers) {
        for(Viewer viewer : viewers) {
            streamRepository.saveAll(viewer.getFollowedStreams());
        }
        viewerRepository.saveAll(viewers);
        return new ResponseEntity<>(viewers, HttpStatus.CREATED);
    }

}
