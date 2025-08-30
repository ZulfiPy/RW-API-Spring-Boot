package com.rw.service;

import com.rw.dto.TermRequestDTO;
import com.rw.dto.TermResponseDTO;
import com.rw.exception.TermNotFoundException;
import com.rw.model.Term;
import com.rw.repository.TermRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermService {

    public final TermRepository termRepository;

    public TermService(TermRepository termRepository) {
        this.termRepository = termRepository;
    }

    public List<TermResponseDTO> getAllTerms() {
        return termRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    public TermResponseDTO getTermById(Long id) {
        Term term = termRepository.findById(id).orElseThrow(() -> new TermNotFoundException("Term not found with the provided id: " + id));
        return mapToResponse(term);
    }

    public TermResponseDTO insertTerm(TermRequestDTO termRequestDTO) {
        Term term = mapToEntity(termRequestDTO);
        Term savedTerm = termRepository.save(term);
        return mapToResponse(savedTerm);
    }

    public void deleteDriverById(Long id) {
        if (!termRepository.existsById(id)) {
            throw new TermNotFoundException("Term not found with the provided id: " + id);
        }
        termRepository.deleteById(id);
    }

    private TermResponseDTO mapToResponse(Term term) {
        return new TermResponseDTO(
                term.getId(),
                term.getTitle(),
                term.getCategory(),
                term.getContent(),
                term.getActive(),
                term.getCustomTerm(),
                term.getCreatedAt(),
                term.getLastEditedAt()
        );
    }

    private Term mapToEntity(TermRequestDTO termRequestDTO) {
        return new Term(
                termRequestDTO.title(),
                termRequestDTO.category(),
                termRequestDTO.content()
        );
    }
}
