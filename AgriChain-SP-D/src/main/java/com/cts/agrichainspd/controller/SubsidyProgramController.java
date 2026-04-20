package com.cts.agrichainspd.controller;

import com.cts.agrichainspd.entity.SubsidyProgram;
import com.cts.agrichainspd.service.SubsidyProgramService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/subsidy-programs")
public class SubsidyProgramController {

    private final SubsidyProgramService service;

    public SubsidyProgramController(SubsidyProgramService service) {
        this.service = service;
    }

    @PostMapping
    public SubsidyProgram createProgram(@RequestBody SubsidyProgram program) {
        return service.createProgram(program);
    }

    @GetMapping
    public List<SubsidyProgram> getAllPrograms() {
        return service.getAllPrograms();
    }
}