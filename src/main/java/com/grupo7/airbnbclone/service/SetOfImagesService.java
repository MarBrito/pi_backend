package com.grupo7.airbnbclone.service;

import com.grupo7.airbnbclone.model.SetOfImages;
import com.grupo7.airbnbclone.repositories.SetOfImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetOfImagesService {

    @Autowired
    SetOfImagesRepository setOfImagesRepository;

    public SetOfImages saveSetOfImages(SetOfImages setOfImages){return setOfImagesRepository.save(setOfImages);}
    public List<SetOfImages> searchAllSetOfImages(){return setOfImagesRepository.findAll();}
    public Optional<SetOfImages> searchSetOfImagesById(Integer id){return setOfImagesRepository.findById(id);}
    public SetOfImages updateSetOfImages(SetOfImages setOfImages){return setOfImagesRepository.save(setOfImages);}
    public void deleteSetOfImages(Integer id){setOfImagesRepository.deleteById(id);}

}
