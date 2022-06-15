package com.grupo7.airbnbclone.controller;

import com.grupo7.airbnbclone.model.Image;
import com.grupo7.airbnbclone.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<Image> save(@RequestBody Image image){
        return ResponseEntity.ok(imageService.saveImage(image));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> searchById(@PathVariable Integer id){
        return ResponseEntity.ok(imageService.searchImageById(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Image>> searchAll(){
        return ResponseEntity.ok(imageService.searchAllImages());
    }

    @PutMapping
    public ResponseEntity<Image> update(@RequestBody Image image){
        ResponseEntity<Image> response = null;
        if (image.getId() != null && imageService.searchImageById(image.getId()).isPresent()){
            response = ResponseEntity.ok(imageService.updateImage(image));
        }
        else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        if (imageService.searchImageById(id).isPresent()){
            imageService.deleteImage(id);
        }
        else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
