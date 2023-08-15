package dev.raniery.jpa.services;

import dev.raniery.jpa.DTO.ExampleDTO;
import dev.raniery.jpa.entity.Example;
import org.springframework.stereotype.Service;
import dev.raniery.jpa.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExampleServices {
    @Autowired
    private ExampleRepository repository;

    @Transactional(readOnly = true)
    public List<ExampleDTO> findAll() {
        List<Example> list = repository.findAll();
        return list.stream().map(ExampleDTO::new).collect(Collectors.toList());
    }

}
