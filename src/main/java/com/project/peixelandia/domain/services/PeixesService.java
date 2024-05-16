package com.project.peixelandia.domain.services;

import com.project.peixelandia.domain.entities.Peixes;
import com.project.peixelandia.domain.repositories.PeixesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeixesService {

    @Autowired
    private PeixesRepository peixesRepository;

    public List<Peixes> buscarPeixes(String nome, String nome_cientifico, String tipo_de_agua, String paises, String cor, String temperamento){
        Specification<Peixes> specification = Specification.where(null);
        if (nome != null && !nome.isEmpty()){
            specification = specification.and(((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("nome"), "%"+nome+"%")));
        }

        if(nome_cientifico != null && !nome_cientifico.isEmpty()){
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("nome_cientifico"), "%"+nome_cientifico+"%" ));
        }

        if(tipo_de_agua != null && !tipo_de_agua.isEmpty()){
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("tipo_de_agua"), "%"+tipo_de_agua+"%" ));
        }

        if (paises != null && !paises.isEmpty()){
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("paises"), "%"+paises+"%" ));
        }

        if(cor != null && !cor.isEmpty()){
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("cor"), "%"+cor+"%" ));
        }

        if(temperamento != null && !temperamento.isEmpty()){
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("temperamento"), "%"+temperamento+"%" ));

        }
        return peixesRepository.findAll(specification);
    }
}

