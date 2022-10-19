package com.sena.eproductiva.manager.models.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.sena.eproductiva.manager.models.entitys.Instructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class PageDto<T> extends ResponseDto {

    private transient List<T> content;
    private transient Pageable pageable;
    private Boolean last;
    private Boolean first;
    private Integer totalPages;
    private Integer size;
    private Integer number;
    private Integer numberOfElements;
    private Sort sort;

    public PageDto(Page<Instructor> page) {
        this.setPageable(page.getPageable());
        this.setLast(page.isLast());
        this.setFirst(page.isFirst());
        this.setTotalPages(page.getTotalPages());
        this.setSize(page.getSize());
        this.setNumber(page.getNumber());
        this.setNumberOfElements(page.getNumberOfElements());
    }
}
