package com.grupo7.airbnbclone.service;

import com.grupo7.airbnbclone.model.Image;
import com.grupo7.airbnbclone.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    public Image saveImage(Image image){return imageRepository.save(image);}
    public List<Image> searchAllImages(){return imageRepository.findAll();}
    public Optional<Image> searchImageById(Integer id){return imageRepository.findById(id);}
    public Image updateImage(Image image){return imageRepository.save(image);}
    public void deleteImage(Integer id){imageRepository.deleteById(id);}

}
