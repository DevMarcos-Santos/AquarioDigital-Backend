package com.project.peixelandia.domain.services;

import com.project.peixelandia.domain.entities.Peixes;
import com.project.peixelandia.domain.repositories.PeixesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeixesService {

    @Autowired
    private PeixesRepository peixesRepository;

    public Optional<Peixes> peixePorId(Integer id) {
        Optional<Peixes> peixes = peixesRepository.findById(id);
        return peixes;
    }

    public List<Peixes> buscarPeixes(String nome, String nome_cientifico, String paises, String tipo_de_agua, String tamanho, String cor, String temperamento){
        Specification<Peixes> specification = Specification.where(null);
        if (nome != null && !nome.isBlank()){
            specification = specification.and(((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("nome"), "%"+nome+"%")));
        }

        if(nome_cientifico != null && !nome_cientifico.isBlank()){
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("nome_cientifico"), "%"+nome_cientifico+"%" ));
        }

        if(tipo_de_agua != null && !tipo_de_agua.isBlank()){
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("tipo_de_agua"), "%"+tipo_de_agua+"%" ));
        }

        if(tamanho != null && !tamanho.isBlank()){
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("tamanho"), "%"+tamanho+"%" ));
        }

        if (paises != null && !paises.isBlank()){
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("paises"), "%"+paises+"%" ));
        }

        if(cor != null && !cor.isBlank()){
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("cor"), "%"+cor+"%" ));
        }

        if(temperamento != null && !temperamento.isBlank()){
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("temperamento"), "%"+temperamento+"%" ));

        }

        return peixesRepository.findAll(specification);
    }
}

