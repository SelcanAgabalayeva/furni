package az.edu.itbrains.furni.services.impl;

import az.edu.itbrains.furni.dtos.TestimonialsDto;
import az.edu.itbrains.furni.repositories.TestimonialsRepository;
import az.edu.itbrains.furni.services.TermonialsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestimonialsServiceImpl implements TermonialsService {
    private final TestimonialsRepository testimonialsRepository;
    private  final ModelMapper modelMapper;

    public TestimonialsServiceImpl(TestimonialsRepository testimonialsRepository, ModelMapper modelMapper) {
        this.testimonialsRepository = testimonialsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TestimonialsDto> getAllTestimonials() {
        List<TestimonialsDto>testimonialsDtoList=testimonialsRepository.findAll().stream()
                .limit(4).map(testimonials -> modelMapper.map(testimonials,TestimonialsDto.class)).collect(Collectors.toList());
        return testimonialsDtoList;
    }
}
