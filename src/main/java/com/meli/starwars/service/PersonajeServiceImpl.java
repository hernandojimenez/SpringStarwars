package com.meli.starwars.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.starwars.dtos.PersonajeDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService{
    @Override
    public List<String> getNombres(String nombre) {
        List<String> cadena= new ArrayList<>();
        List<PersonajeDTO> list = loadFile();
        for(PersonajeDTO p: list){
            if(p.getName().contains(nombre)){
                cadena.add(p.getName());
            }
        }
        return cadena;
    }
    public static  List<PersonajeDTO> loadFile(){
        List<PersonajeDTO> list = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        }catch (Exception e){
            e.printStackTrace();
        }

        TypeReference<List<PersonajeDTO>> typeRef = new TypeReference<List<PersonajeDTO>>() {};

        try {
            list = objectMapper.readValue(file, typeRef);

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;

    }
}
