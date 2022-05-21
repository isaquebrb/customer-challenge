package br.com.isaquebrb.customerchallenge.adapter.filter;

import br.com.isaquebrb.customerchallenge.adapter.repository.entity.CustomerEntity;
import br.com.isaquebrb.customerchallenge.core.filter.CustomerFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public interface CustomerSpecification {

    static Specification<CustomerEntity> getSpecification(CustomerFilter customerFilter) {
        List<Predicate> predicates = new ArrayList<>();
        return ((root, query, criteriaBuilder) -> {
            if (customerFilter.getAge() != null) {
                predicates.add(criteriaBuilder.equal(root.get("age"), customerFilter.getAge()));
            }

            if (customerFilter.getName() != null) {
                predicates.add(criteriaBuilder.equal(root.get("name"), customerFilter.getName()));
            }

            if (customerFilter.getEmail() != null) {
                predicates.add(criteriaBuilder.equal(root.get("email"), customerFilter.getEmail()));
            }

            if (customerFilter.getActive() != null) {
                predicates.add(criteriaBuilder.equal(root.get("active"), customerFilter.getActive()));
            }

            if (customerFilter.getCellphone() != null) {
                predicates.add(criteriaBuilder.equal(root.get("cellphone"), customerFilter.getCellphone()));
            }

            if (customerFilter.getPhone() != null) {
                predicates.add(criteriaBuilder.equal(root.get("phone"), customerFilter.getPhone()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
