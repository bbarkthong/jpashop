package jpabook.jpashop.domain;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Builder;

@Builder
@Getter
@Embeddable
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
