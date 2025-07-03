package com.rw.controller;

import com.rw.dto.DesignerRequestDTO;
import com.rw.dto.DesignerResponseDTO;
import com.rw.service.DesignerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/designers")
public class DesignerController {

    private final DesignerService designerService;

    public DesignerController(DesignerService designerService) {
        this.designerService = designerService;
    }

    @GetMapping
    public List<DesignerResponseDTO> getDesigners() {
        return designerService.getAllDesigners();
    }

    @GetMapping("{id}")
    public DesignerResponseDTO getDesignerById(@PathVariable Integer id) {
        return designerService.getDesignerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DesignerResponseDTO addDesigner(@Valid @RequestBody DesignerRequestDTO designerRequestDTO) {
        return designerService.insertDesigner(designerRequestDTO);
    }
}
