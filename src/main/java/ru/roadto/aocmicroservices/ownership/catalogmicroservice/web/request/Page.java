package ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.request;

import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Collections;


/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Page implements Pageable, Serializable {

    public static Page EMPTY_PAGE = new Page(0, 0);

    private Integer offset = 0;
    private Integer limit = 20;
    private Sort sort;

    public Page(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public Page(int offset, int limit, Sort sort) {
        this.offset = offset;
        this.limit = limit;
        this.sort = sort;
    }

    public Page(int offset, int limit, Sort.Order order) {
        this.offset = offset;
        this.limit = limit;
        this.sort = new Sort(Collections.singletonList(order));
    }

    private Page (Sort defaultSort) {
        this.sort = defaultSort;
    }

    public static Page getPageWithDefaultSort(PageRequest page, @NonNull Sort defaultSort) {

        Sort.Order defaultOrder = defaultSort.iterator().next();

        if (defaultOrder == null) {
            throw new IllegalArgumentException("Default sort order must be not null!");
        }

        if (page == null) {
            return new Page(defaultSort);
        }

        Sort.Direction orderDirection = page.getOrderDirection() != null ? page.getOrderDirection() : defaultOrder.getDirection();
        String orderField = StringUtils.isNotEmpty(page.getOrderField()) ? page.getOrderField().toLowerCase() : defaultOrder.getProperty();

        return new PageRequest(page.getOffset(), page.getLimit(), orderField, orderDirection).toPage();
    }

    @Override
    public int getPageNumber() {
        return offset == 0 ? 0 : offset / limit - 1;
    }

    @Override
    public int getPageSize() {
        return limit;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public Pageable next() {
        return new Page(getPageNumber() + 1, getPageSize(), getSort());
    }

    @Override
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    @Override
    public Pageable first() {
        return new Page(0, getPageSize(), getSort());
    }

    @Override
    public boolean hasPrevious() {
        return offset > 0;
    }

    public Pageable previous() {
        return offset == 0 ? this : new Page(offset - limit, getPageSize(), getSort());
    }
}

