package lk.ijse.gdse66.shoeshopbackend.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class CommonUtils {
    public final static int IS_ENABLE = 1;
    public final static int IS_DISABLE = 0;
    public final static int IS_ACTIVE = 1;
    public final static int IS_DEACTIVATE = 0;

    public static Pageable setPagination(Integer offset, Integer limit, String columnName) {
        return PageRequest.of(offset, limit, Sort.by(Sort.Direction.DESC, columnName));
    }

    public final static int DEFAULT_PAGE_NUMBER = 0;
    public final static int DEFAULT_PAGE_SIZE = 10;
    public final static String DEFAULT_SORT_BY = "create_date";
    public final static String DEFAULT_SORT_DIRECTION = "desc";
    public final static String DEFAULT_ALL = "ALL";
    public final static String ACTIVE = "ACTIVE";
    public final static String INACTIVE = "INACTIVE";


}
