package DaliborJankovic.StudentskiServis.service.impl;

import DaliborJankovic.StudentskiServis.dao.TitleRepository;
import DaliborJankovic.StudentskiServis.entity.users.details.Title;
import DaliborJankovic.StudentskiServis.service.TitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TitleServiceImpl implements TitleService {

    private final TitleRepository titleRepository;


    @Override
    public void save(Title title) {
        titleRepository.save(title);
    }

    @Override
    public Title findById(Integer id) {
        Optional<Title> result = titleRepository.findById(id);
        Title tempTitle = null;
        if (result.isPresent()) {
            tempTitle = result.get();
        } else {
            throw new RuntimeException("Title not found!");
        }
        return null;
    }

    @Override
    public List<Title> findAll() {
        return titleRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        titleRepository.deleteById(id);
    }
}
