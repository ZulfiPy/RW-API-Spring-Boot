package com.rw.controller;


import com.rw.dto.TermRequestDTO;
import com.rw.dto.TermResponseDTO;
import com.rw.service.TermService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/terms")
public class TermController {

    private final TermService termService;

    public TermController(TermService termService) {
        this.termService = termService;
    }

    @GetMapping
    public List<TermResponseDTO> getTerms() {
        return termService.getAllTerms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TermResponseDTO> getTermById(@PathVariable Long id) {
        TermResponseDTO term = termService.getTermById(id);
        return ResponseEntity.ok(term);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TermResponseDTO> addTerm(@Valid @RequestBody TermRequestDTO termRequestDTO) {
        TermResponseDTO term = termService.insertTerm(termRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(term);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteDriverById(@PathVariable Long id) {
        termService.deleteDriverById(id);
        return ResponseEntity.noContent().build();
    }
}
