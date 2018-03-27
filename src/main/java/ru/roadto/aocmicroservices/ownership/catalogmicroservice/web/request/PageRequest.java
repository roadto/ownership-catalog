package ru.roadto.aocmicroservices.ownership.catalogmicroservice.web.request;

import ru.roadto.aocmicroservices.ownership.catalogmicroservice.common.exception.ExceptionUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.domain.Sort;

import static ru.roadto.aocmicroservices.ownership.catalogmicroservice.core.Constants.Web.PAGINATION_MAX_LIMIT;


/**
 * @author Artem Krotov
 * Created on 22.11.2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {

    private int offset = 0;
    private int limit = 20;
    private String orderField;
    private Sort.Direction orderDirection;

    public Page toPage() {

        if (limit > PAGINATION_MAX_LIMIT) {
            limit = PAGINATION_MAX_LIMIT;
        }

        if (orderField == null || orderDirection == null) {
            ExceptionUtils.throwInvalidRequestParametersException(
                    "Error. OrderField or orderDirection is null!"
            );
        }

        return new Page(offset, limit, new Sort.Order(orderDirection, orderField));

    }
}
