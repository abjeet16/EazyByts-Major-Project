package com.example.fitnessTrackerEazybits.controller;

import com.example.fitnessTrackerEazybits.dto.ActivityDto;
import com.example.fitnessTrackerEazybits.dto.GoalDto;
import com.example.fitnessTrackerEazybits.services.Goals.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class GoalController {

    private final GoalService goalService;

    @PostMapping("/goal")
    public ResponseEntity<?> postGoal(@RequestBody GoalDto goalDto){
        GoalDto createGoal = goalService.postGoal(goalDto);
        if (createGoal != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createGoal);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing went wrong");
        }
    }

    @GetMapping("/goals")
    public ResponseEntity<?> getGoals(){
        try {
            return ResponseEntity.ok(goalService.getGoals());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/goal/UpdateStatus/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id){
        try {
            return ResponseEntity.ok(goalService.updateGoalStatus(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
