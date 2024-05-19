package com.project.peixelandia.web;

import com.project.peixelandia.domain.entities.Peixes;
import com.project.peixelandia.domain.services.PeixesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin( originPatterns = "*")
@RestController
@RequestMapping("/peixes")
public class PeixesController {

    @Autowired
    private PeixesService peixesService;

    @PostMapping("/find")
    public ResponseEntity<List<Peixes>> buscarPeixes(@RequestBody Peixes peixes){
        List<Peixes> result = peixesService.buscarPeixes(
                peixes.getNome(),
                peixes.getNome_cientifico(),
                peixes.getPaises(),
                peixes.getTipo_de_agua(),
                peixes.getTamanho(),
                peixes.getCor(),
                peixes.getTemperamento()
        );
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Peixes>> peixeId(@PathVariable("id") Integer id){
        Optional<Peixes> result = peixesService.peixePorId(id);
        return new ResponseEntity<Optional<Peixes>>(result, HttpStatus.OK);
    }
}
