package ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.dto;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.request.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PageableDto<T> {
    private Integer limit;
    private Integer offset;
    private Sort sort;
    private Integer totalCount;
    private List<?> data = new ArrayList<>();

    public PageableDto(Page page, List<?> data) {
        this.data = data;
        this.limit = page.getLimit();
        this.offset = page.getOffset();
        this.sort = page.getSort();
        this.totalCount = data.size();
    }


}
