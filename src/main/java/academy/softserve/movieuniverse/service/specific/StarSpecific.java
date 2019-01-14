package academy.softserve.movieuniverse.service.specific;

import academy.softserve.movieuniverse.dto.star.StarSearchRequest;
import academy.softserve.movieuniverse.entity.Movie;
import academy.softserve.movieuniverse.entity.Profession;
import academy.softserve.movieuniverse.entity.Star;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StarSpecific {

    public Specification<Star> filter(StarSearchRequest starSearchRequest) {
        Specification<Star> keyword = starSearchRequest.getKeyword() == null ? null
                : anyFieldContainsKeyword(starSearchRequest.getKeyword());
        Specification<Star> professions = starSearchRequest.getProfessions() == null ? null
                : containsAnyProfessionFromList(starSearchRequest.getProfessions());
        Specification<Star> movie = starSearchRequest.getMovie() == null ? null
                : containsMovie(starSearchRequest.getMovie());
        Specification<Star> removed = isRemoved(false);

        return Specification.where(keyword).and(removed).and(professions).and(movie);
    }

    private Specification<Star> isRemoved(boolean isRemoved) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("isRemoved"), isRemoved);
    }

    private Specification<Star> hasName(String name) {
        return Specification.where(containsKeyword("firstName", name).or(containsKeyword("lastName", name)));
    }

    private Specification<Star> anyFieldContainsKeyword(String keyword) {
        return Specification.where(containsKeyword("firstName", keyword).or(containsKeyword("lastName", keyword)))
                .or(containsKeyword("cityOfBirth", keyword)).or(containsKeyword("biography", keyword));
    }

    private Specification<Star> containsKeyword(String field, String keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(field)),
                "%" + keyword.toLowerCase() + "%");
    }

    private Specification<Star> containsAnyProfessionFromList(List<String> professions) {
        List<String> lowercaseProfessions = professions.stream().map(String::toLowerCase).collect(Collectors.toList());
        return (root, query, criteriaBuilder) -> {
            ListJoin<Star, Profession> joinList = root.joinList("professions", JoinType.INNER).joinList("profession",
                    JoinType.INNER);
            return (criteriaBuilder.lower(joinList.get("professionType")).in(lowercaseProfessions));
        };
    }

    private Specification<Star> containsMovie(String movieName) {
        return (root, query, criteriaBuilder) -> {
            ListJoin<Star, Movie> joinList = root.joinList("roles", JoinType.INNER).joinList("movie", JoinType.INNER);
            return criteriaBuilder.equal(criteriaBuilder.lower(joinList.get("movieName")), movieName.toLowerCase());
        };
    }

}
