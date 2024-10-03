package com.example.fitnessTrackerEazybits.controller;

import com.example.fitnessTrackerEazybits.dto.ActivityDto;
import com.example.fitnessTrackerEazybits.services.activity.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping("/activity")
    public ResponseEntity<?> postActivity(@RequestBody ActivityDto activityDto){
        ActivityDto createActivity = activityService.postActivity(activityDto);
        if (createActivity != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createActivity);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing went wrong");
        }
    }

    @GetMapping("/activities")
    public ResponseEntity<?> getActivities(){
        try {
            return ResponseEntity.ok(activityService.getActivities());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing went wrong");
        }
    }
}
