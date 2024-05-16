package com.project.peixelandia.web;

import com.project.peixelandia.domain.entities.Peixes;
import com.project.peixelandia.domain.services.PeixesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
                peixes.getTipo_de_agua(),
                peixes.getPaises(),
                peixes.getCor(),
                peixes.getTemperamento()
        );
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
