CREATE TABLE APP_SPONSRD_USER_ATTRIB_DEFS_T (
        ID NUMBER(8) NOT NULL,
        APPLICATION_ID NUMBER(8) NOT NULL,
        ATTRIBUTE_NAME VARCHAR2(500) NOT NULL,
        ATTRIBUTE_TYPE_ID NUMBER(8) NOT NULL,
        DESCRIPTION VARCHAR(4000),
		OBJ_ID VARCHAR2(36) DEFAULT SYS_GUID() NOT NULL, 
        VER_NBR NUMBER(8) DEFAULT 1 NOT NULL, 
        CONSTRAINT APP_SPONSRD_USER_ATTR_PK PRIMARY KEY (ID)
)
/