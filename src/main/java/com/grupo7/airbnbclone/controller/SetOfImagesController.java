package com.grupo7.airbnbclone.controller;

import com.grupo7.airbnbclone.model.SetOfImages;
import com.grupo7.airbnbclone.service.SetOfImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setofimages")
public class SetOfImagesController {

    @Autowired
    private SetOfImagesService setOfImagesService;

    @PostMapping
    public ResponseEntity<SetOfImages> save(@RequestBody SetOfImages setOfImages){
        return ResponseEntity.ok(setOfImagesService.saveSetOfImages(setOfImages));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SetOfImages> searchById(@PathVariable Integer id){
        return ResponseEntity.ok(setOfImagesService.searchSetOfImagesById(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<SetOfImages>> searchAll(){
        return ResponseEntity.ok(setOfImagesService.searchAllSetOfImages());
    }

    @PutMapping
    public ResponseEntity<SetOfImages> update(@RequestBody SetOfImages setOfImages){
        ResponseEntity<SetOfImages> response = null;
        if (setOfImages.getId() != null && setOfImagesService.searchSetOfImagesById(setOfImages.getId()).isPresent()){
            response = ResponseEntity.ok(setOfImagesService.updateSetOfImages(setOfImages));
        }
        else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        if (setOfImagesService.searchSetOfImagesById(id).isPresent()){
            setOfImagesService.deleteSetOfImages(id);
        }
        else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
