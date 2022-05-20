package br.com.isaquebrb.customerchallenge.adapter.filter;

import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class CustomerFilter {

    private final Long id;
    private final String name;
    private final String email;
    private final Boolean active;

    public Specification<CustomerEntity> getSpecification() {
        List<Predicate> predicates = new ArrayList<>();
        return ((root, query, criteriaBuilder) -> {
            if (id != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), id));
            }

            if (name != null) {
                predicates.add(criteriaBuilder.equal(root.get("name"), name));
            }

            if (email != null) {
                predicates.add(criteriaBuilder.equal(root.get("email"), email));
            }

            if (active != null) {
                predicates.add(criteriaBuilder.equal(root.get("active"), active));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
