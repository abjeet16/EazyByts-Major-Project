package com.example.fitnessTrackerEazybits.controller;

import com.example.fitnessTrackerEazybits.dto.ActivityDto;
import com.example.fitnessTrackerEazybits.dto.WorkoutDto;
import com.example.fitnessTrackerEazybits.services.workout.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class WorkoutController {

    private final WorkoutService workoutService;
    @PostMapping("/workout")
    public ResponseEntity<?> addWorkout(@RequestBody WorkoutDto workoutDto){
        WorkoutDto createWorkout = workoutService.postWorkout(workoutDto);
        if (createWorkout != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createWorkout);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing went wrong");
        }
    }
    @GetMapping("/workouts")
    public ResponseEntity<?> getActivities(){
        try {
            return ResponseEntity.ok(workoutService.getWorkouts());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing went wrong");
        }
    }
}
