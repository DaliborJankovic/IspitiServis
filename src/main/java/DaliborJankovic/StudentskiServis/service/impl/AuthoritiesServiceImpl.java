package DaliborJankovic.StudentskiServis.service.impl;

import DaliborJankovic.StudentskiServis.authoriti.Authorities;
import DaliborJankovic.StudentskiServis.dao.AuthoritiesRepository;
import DaliborJankovic.StudentskiServis.service.AuthoritiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthoritiesServiceImpl implements AuthoritiesService {

    private final AuthoritiesRepository authoritiesRepository;

    @Override
    public void save(Authorities authorities) {
        authoritiesRepository.save(authorities);
    }

    @Override
    public Authorities findById(Integer id) {
        Optional<Authorities> result = authoritiesRepository.findById(id);
        Authorities tempAuthority = null;
        if (result.isPresent()) {
            tempAuthority = result.get();
        } else {
            throw new RuntimeException("Authority not found");
        }
        return tempAuthority;
    }

    @Override
    public List<Authorities> findAll() {
        return authoritiesRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        authoritiesRepository.deleteById(id);
    }
}
