package pl.edu.wat.pze.kwejk.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.pze.kwejk.exception.ArticleNotFoundException;
import pl.edu.wat.pze.kwejk.model.Article;
import pl.edu.wat.pze.kwejk.model.Picture;
import pl.edu.wat.pze.kwejk.repository.ArticleRepository;
import pl.edu.wat.pze.kwejk.repository.PictureRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArticleService {

    @Autowired
    PictureRepository pictureRepository;

    public Picture getArticle(Long pictureId) {
        Picture found = pictureRepository.getOne(pictureId);
        if(found==null || found.getArticle().equals("")) throw new ArticleNotFoundException(pictureId);
        else return found;
    }

    public List<Picture> getArticles() {
        return pictureRepository.findAll().stream()
                .filter(p -> !p.getArticle().equals("") && p.getArticle()!=null)
                .collect(Collectors.toList());
        //ogólnie powinno się to filtrować na poziomie repozytorium (jakimś criteria api/querydsl/psql),
        // a nie pobieranie całej kolekcji i streamowanie - ale nas jebie wydajność przy 50 artykułach
    }

}
