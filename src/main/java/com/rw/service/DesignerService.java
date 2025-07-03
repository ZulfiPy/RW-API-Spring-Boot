package com.rw.service;

import com.rw.repository.DesignerRepository;
import com.rw.dto.DesignerRequestDTO;
import com.rw.dto.DesignerResponseDTO;
import com.rw.model.Designer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignerService {

    private final DesignerRepository designerRepository;

    public DesignerService(DesignerRepository designerRepository) {
        this.designerRepository = designerRepository;
    }

    public List<DesignerResponseDTO> getAllDesigners() {
        return designerRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public DesignerResponseDTO getDesignerById(Integer id) {
        Designer designer = designerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Designer not found by the provided id: " + id));
        return mapToResponseDTO(designer);
    }

    public DesignerResponseDTO insertDesigner(DesignerRequestDTO designerRequestDTO) {
        Designer designer = mapToEntity(designerRequestDTO);
        Designer savedDesigner = designerRepository.save(designer);
        return mapToResponseDTO(savedDesigner);
    }

    private DesignerResponseDTO mapToResponseDTO(Designer designer) {
        return new DesignerResponseDTO(
                designer.getId(),
                designer.getName(),
                designer.getDesignTools()
        );
    }

    private Designer mapToEntity(DesignerRequestDTO designerRequestDTO) {
        return new Designer(
                null,
                designerRequestDTO.name(),
                designerRequestDTO.designTools()
        );
    }
}
