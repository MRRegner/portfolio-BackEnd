package com.mrr.back.service;

import com.mrr.back.model.Skills;
import com.mrr.back.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService {

    @Autowired
    private SkillRepository skiRepository;

    @Override
    public List<Skills> getSkills() {
        List<Skills> listaSkills = skiRepository.findAll();
        return listaSkills;
    }

    @Override
    public void saveSkills(Skills ski) {
        skiRepository.save(ski);
    }

    @Override
    public void deleteSkills(Long id) {
        skiRepository.deleteById(id);
    }

    @Override
    public Skills findSkills(Long id) {
        //Si no se encuentra skicacion devuelve null
        Skills ski = skiRepository.findById(id).orElse(null);
        return ski;
    }

}
