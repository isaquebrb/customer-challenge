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

    private String name;
    private Integer age;
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
