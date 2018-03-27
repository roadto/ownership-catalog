package ru.roadto.aocmicroservices.ownership.catalogmicroservice.core;


/**
 * @author Artem Krotov
 * Created on 20.11.2017.
 */
public class Constants {

    public static final class Core {
        public static final class Model {

            public static final class AEType {
                public static final String LEVEL_1 = "Хутор";
                public static final String LEVEL_2 = "Деревня";
                public static final String LEVEL_3 = "Село";
                public static final String LEVEL_4 = "Город";
            }

            public static final class AE {
                public static final String DATE_CREATE = "date_create";
            }

            public static final class PrincipalityType {

            }
        }

        public static final class Db {
            public static final String JPA_VENDOR_ADAPTER = "jpaVendorAdapter";
            public static final String JPA_PROPERTIES = "jpaProperties";
            public static final String PACKAGES_TO_SCAN = "com.akcompany.ownershipservice";
            public static final String ENTITY_MANAGER_FACTORY = "entityManagerFactory";
            public static final String TRANSACTION_MANAGER = "transactionManager";
            public static final String DATA_SOURCE = "dataSource";
            public static final String JDBC_TEMPLATE = "JdbcTemplate";
            public static final String NAMED_JDBC_TEMPLATE = "namedJdbcTemplate";
            public static final String DATABASE_PROPERTIES = "datasource";
            public static final String DATABASE_PROPERTIES_BEAN = "dataSourceProperties";
        }

        public static final class Sort {
                public static final String NAME = "name";
        }


    }

    public static final class Web {

        public static final int PAGINATION_MAX_LIMIT = 1000;

        public static final class RestApi {

            public static final String ROOT_PATH = "/api";
            public static final String AES = ROOT_PATH + "/aes";
            public static final String AES_BY_ID = AES + "/{id}";
            public static final String PRINCIPALITIES = ROOT_PATH + "/principalities";
            public static final String PRINCIPALITIES_BY_ID = PRINCIPALITIES + "/{id}";
            public static final String CLONES = ROOT_PATH + "/clones";
            public static final String CLONES_BY_ID = CLONES + "/{id}";
            public static final String BUILDINGS = ROOT_PATH + "/clones";
            public static final String BUILDINGS_BY_ID = BUILDINGS + "/{id}";

        }


        public static final class Parameters {

            public static final class DTOs {

                public static final String ID = "id";

                public static final class AE_DTO {
                    public static final String CLASS_NAME = "aeDto";
                }

                public static final class PRINCIPALITY {
                    public static final String CLASS_NAME = "principalityDto";
                }

                public static final class CLONE {
                    public static final String CLASS_NAME = "cloneDto";
                }

                public static final class BUILDING_DTO {
                    public static final String CLASS_NAME = "buildingDto";
                }
            }
        }

    }

}
