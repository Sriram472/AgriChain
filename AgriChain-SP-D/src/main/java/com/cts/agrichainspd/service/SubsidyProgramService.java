package com.cts.agrichainspd.service;

import com.cts.agrichainspd.entity.SubsidyProgram;
import com.cts.agrichainspd.repository.SubsidyProgramRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubsidyProgramService {

    private final SubsidyProgramRepository repository;

    public SubsidyProgramService(SubsidyProgramRepository repository) {
        this.repository = repository;
    }

    public SubsidyProgram createProgram(SubsidyProgram program) {
        return repository.save(program);
    }

    public List<SubsidyProgram> getAllPrograms() {
        return repository.findAll();
    }
}