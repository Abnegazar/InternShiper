package com.stage.geststage.service;

import com.stage.geststage.domain.Competence;
import com.stage.geststage.dto.add.AddCompetenceDto;
import com.stage.geststage.dto.linked.LinkedCompetenceDto;
import com.stage.geststage.mapper.CompetenceMapper;
import com.stage.geststage.repository.CompetenceRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompetenceService {

    private final CompetenceRepository repository;
    private final CompetenceMapper mapper = new CompetenceMapper();

    public CompetenceService(CompetenceRepository repository) {
        this.repository = repository;
    }

    public LinkedCompetenceDto save(AddCompetenceDto dto) {
        Competence competence = repository.save(mapper.toCompetence(dto));
        return mapper.toDto(competence);
    }

    public List<LinkedCompetenceDto> findBylabel(String label) {
        return repository.findAllByLabelContainingIgnoreCaseOrderByLabelAsc(label);
    }

    public List<LinkedCompetenceDto> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "label"))
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public LinkedCompetenceDto update(AddCompetenceDto dto) {
        Competence c = repository.saveAndFlush(mapper.toCompetence(dto));
        return mapper.toDto(c);
    }
}
