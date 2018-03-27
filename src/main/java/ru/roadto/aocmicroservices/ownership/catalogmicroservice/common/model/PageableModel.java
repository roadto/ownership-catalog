package ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.model;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.request.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.domain.PageImpl;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Сущность для постраничного вывода результатов поиска
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
@Data
@ToString(callSuper = true, includeFieldNames = true)
@XmlRootElement
@EqualsAndHashCode(callSuper = true)
public class PageableModel<T> extends PageImpl<T> {

    private int offset = -1;
    private int limit = -1;
    private int totalCount = -1;
    private List<T> data = new ArrayList<>();

    public PageableModel(List<T> data, Page pageable, int totalCount) {
        super(data, pageable, totalCount);

        this.data = data;
        this.offset = pageable.getOffset();
        this.limit = pageable.getLimit();
        this.totalCount = totalCount;
    }
}
