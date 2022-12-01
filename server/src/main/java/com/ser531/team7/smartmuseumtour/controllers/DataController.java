package com.ser531.team7.smartmuseumtour.controllers;

import com.ser531.team7.smartmuseumtour.models.Artwork;
import com.ser531.team7.smartmuseumtour.services.AWSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    AWSService awsService;

//    @GetMapping("/artwork")
//    public Artwork getArtwork() {
//        awsService.getArtworkByQRCodeID(1);
//        return null;
//    }
//
//    @GetMapping("/smartMuseum/{qrcodeId}")
//    public Artwork getArtworkByQRCode(@PathVariable String qrcodeId) {
//        return awsService.getArtworkByQRCodeID(Integer.valueOf(qrcodeId));
//    }

    @GetMapping("/artwork/{artworkId}")
    public Artwork getArtworkByID(@PathVariable String artworkId) {
        return awsService.getArtworkByID(artworkId);
    }

}
