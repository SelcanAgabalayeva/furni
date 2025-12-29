package az.edu.itbrains.furni.services.impl;

import az.edu.itbrains.furni.dtos.ModelDto;
import az.edu.itbrains.furni.dtos.TestimonialsDto;
import az.edu.itbrains.furni.repositories.ModelRepository;
import az.edu.itbrains.furni.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
     private final ModelMapper modelMapper;

    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<ModelDto> getAllModels() {
        List<ModelDto>modelDtoList=modelRepository.findAll().stream()
                .limit(4).map(models -> modelMapper.map(models,ModelDto.class)).collect(Collectors.toList());
        return modelDtoList;
    }
}
