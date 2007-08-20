CREATE TABLE FS_PARM_T (
        FS_SCR_NM                      VARCHAR2(255) CONSTRAINT FS_PARM_TN1 NOT NULL,
        FS_PARM_NM                     VARCHAR2(255) CONSTRAINT FS_PARM_TN2 NOT NULL,
        OBJ_ID                         VARCHAR2(36) DEFAULT SYS_GUID() CONSTRAINT FS_PARM_TN3 NOT NULL,
        VER_NBR                        NUMBER(8) DEFAULT 1 CONSTRAINT FS_PARM_TN4 NOT NULL,
        FS_PARM_TXT                    VARCHAR2(4000),
        FS_PARM_DESC                   VARCHAR2(2000),
        FS_MULT_VAL_IND                VARCHAR2(1) CONSTRAINT FS_PARM_TN5 NOT NULL,
        FS_MOD_CD                   VARCHAR2(2) NOT NULL,
     CONSTRAINT FS_PARM_TP1 PRIMARY KEY (FS_SCR_NM,FS_PARM_NM),
     CONSTRAINT FS_PARM_TC0 UNIQUE (OBJ_ID)
)
/
