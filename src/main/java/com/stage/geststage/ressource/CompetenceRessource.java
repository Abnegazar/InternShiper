package com.stage.geststage.ressource;

import com.stage.geststage.dto.add.AddCompetenceDto;
import com.stage.geststage.dto.linked.LinkedCompetenceDto;
import com.stage.geststage.service.CompetenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geststage/competence")
public class CompetenceRessource {
    private final CompetenceService competenceService;

    public CompetenceRessource(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @PostMapping("/add")
    public ResponseEntity<LinkedCompetenceDto> save(@RequestBody AddCompetenceDto dto) {
        return new ResponseEntity<>(competenceService.save(dto), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<LinkedCompetenceDto>> findByLabel(@PathVariable("id") String label) {
        return new ResponseEntity<>(competenceService.findBylabel(label), HttpStatus.FOUND);
    }

    @GetMapping
    private ResponseEntity<List<LinkedCompetenceDto>> findAll() {
        return new ResponseEntity<>(competenceService.findAll(), HttpStatus.FOUND);
    }
}
