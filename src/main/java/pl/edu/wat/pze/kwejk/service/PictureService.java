package pl.edu.wat.pze.kwejk.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wat.pze.kwejk.model.Picture;
import pl.edu.wat.pze.kwejk.repository.PictureRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class PictureService {

    PictureRepository pictureRepository;

    public List<Picture> getPicturesForPage(int aPageNumber) {
        return pictureRepository.findAll();
    }

    public Picture getPictureById(Long id) {
        return pictureRepository.getOne(id);
    }

    public List<Picture> getPictures() {
        return pictureRepository.findAll().stream()
                .filter(p -> p.getArticle().equals("") || p.getArticle()==null)
                .collect(Collectors.toList());
        //ogólnie powinno się to filtrować na poziomie repozytorium (jakimś criteria api/querydsl/psql),
        // a nie pobieranie całej kolekcji i streamowanie - ale nas jebie wydajność przy 50 obrazkach
    }

    public void save(Picture picture) {
        pictureRepository.save(picture);
    }

}
