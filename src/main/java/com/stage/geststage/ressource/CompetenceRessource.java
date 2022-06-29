package com.stage.geststage.ressource;

import com.stage.geststage.domain.Competence;
import com.stage.geststage.dto.add.AddCompetenceDto;
import com.stage.geststage.dto.linked.LinkedCompetenceDto;
import com.stage.geststage.mapper.CompetenceMapper;
import com.stage.geststage.service.CompetenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geststage/competence")
public class CompetenceRessource {
    private final CompetenceService competenceService;
    private final CompetenceMapper mapper = new CompetenceMapper();

    public CompetenceRessource(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @PostMapping("/add")
    public ResponseEntity<LinkedCompetenceDto> save(@RequestBody AddCompetenceDto dto) {
        return new ResponseEntity<>(competenceService.save(dto), HttpStatus.CREATED);
    }

    @GetMapping("/get_by_name/{label}")
    public ResponseEntity<List<LinkedCompetenceDto>> findByLabel(@PathVariable("label") String label) {
        return new ResponseEntity<>(competenceService.findBylabel(label), HttpStatus.FOUND);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Competence> findByid(@PathVariable("id") Long id) {
        return new ResponseEntity<>(competenceService.findById(id), HttpStatus.FOUND);
    }

    @GetMapping
    private ResponseEntity<List<LinkedCompetenceDto>> findAll() {
        return new ResponseEntity<>(competenceService.findAll(), HttpStatus.FOUND);
    }

    /*@PutMapping("/update/{id}")
    private ResponseEntity<LinkedCompetenceDto> update(@PathParam ("id") Long id, @RequestBody AddCompetenceDto dto){
        Competence competence = competenceService.findById(id);

        if (competence != null){
            competence.setLabel(dto.getLabel());
            for (Long l : dto.getOffres()){
                competence.ajouterOffre();
            }
        }
    }*/
}
