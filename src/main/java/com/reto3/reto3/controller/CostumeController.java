package com.reto3.reto3.controller;

import com.reto3.reto3.entities.Costume;
import com.reto3.reto3.service.CostumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Costume")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CostumeController {

    @Autowired
    private CostumeService costumeService;
    @GetMapping("/all")
    public List<Costume> getAll(){ return costumeService.getAll(); }

    @GetMapping("/{id}")
    public Optional<Costume> getCostume(@PathVariable("id") int id){ return costumeService.getCostume(id); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume save (@RequestBody Costume costume){ return costumeService.save(costume); }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Costume update (@RequestBody Costume costume){ return costumeService.update(costume); }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id") int carId){ return costumeService.delete(carId); }
}
