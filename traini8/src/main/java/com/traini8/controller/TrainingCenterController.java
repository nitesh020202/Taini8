package com.traini8.controller;

import com.traini8.model.TrainingCenter;
import com.traini8.service.TrainingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {
    
    @Autowired
    private TrainingCenterService service;

    @PostMapping("/create")
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Validated @RequestBody TrainingCenter trainingCenter) {
        TrainingCenter savedCenter = service.createTrainingCenter(trainingCenter);
        return new ResponseEntity<>(savedCenter, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> centers = service.getAllTrainingCenters();
        return new ResponseEntity<>(centers, HttpStatus.OK);
    }
}
