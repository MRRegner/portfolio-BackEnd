package com.mrr.back.service;

import com.mrr.back.model.Skills;
import java.util.List;

public interface ISkillService {

    public List<Skills> getSkills();

    //metodo para dar de alta una Skill
    public void saveSkills(Skills ski);

    //metodo para borrar una skill
    public void deleteSkills(Long id);

    //metodo para encontrar un Skill
    public Skills findSkills(Long id);

}
