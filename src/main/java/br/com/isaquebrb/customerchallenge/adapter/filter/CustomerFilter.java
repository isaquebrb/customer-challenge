package br.com.isaquebrb.customerchallenge.adapter.filter;

import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerFilter {

    private Long id;
    private String name;
    private String email;
    private Boolean active;

    public Specification<CustomerEntity> getSpecification() {
        List<Predicate> predicates = new ArrayList<>();
        return ((root, query, criteriaBuilder) -> {
            if (this.active != null) {
                predicates.add(criteriaBuilder.equal(root.get("active"), this.active));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
