
CREATE SEQUENCE KCB_MESSAGES_SEQ INCREMENT BY 1 START WITH 1000
/
CREATE SEQUENCE KCB_MSG_DELIVS_SEQ INCREMENT BY 1 START WITH 1000
/
CREATE SEQUENCE KCB_RECIP_DELIVS_SEQ INCREMENT BY 1 START WITH 1000
/
CREATE SEQUENCE KCB_RECIP_PREFS_SEQ INCREMENT BY 1 START WITH 1000
/
CREATE TABLE KCB_MESSAGES
(
    ID                  NUMBER(8) NOT NULL,
    ORIGIN_ID           VARCHAR2(128) NULL,
    DELIVERY_TYPE       VARCHAR2(500) NOT NULL,
    CREATED_DATETIME    TIMESTAMP NOT NULL,
    TITLE               VARCHAR2(255) NULL,
    CHANNEL             VARCHAR2(300) NOT NULL,
    PRODUCER            VARCHAR2(300) NULL,
    CONTENT             CLOB NOT NULL,
    CONTENT_TYPE        VARCHAR2(128) NULL,
    URL                 VARCHAR2(512) NULL,
    USER_RECIPIENT_ID   VARCHAR2(300) NOT NULL,
    DB_LOCK_VER_NBR     INTEGER DEFAULT 0 NOT NULL,
    CONSTRAINT KCB_MESSAGES_PK PRIMARY KEY (ID)
)
/
CREATE TABLE KCB_MSG_DELIVS
(
    ID                      NUMBER(8) NOT NULL,
    MESSAGE_ID              NUMBER(8) NOT NULL,
    DELIVERER_TYPE_NAME     VARCHAR2(500) NOT NULL,
    DELIVERER_SYSTEM_ID     VARCHAR2(300),
    DELIVERY_STATUS         VARCHAR2(15) NOT NULL,
    LOCKED_DATE             TIMESTAMP NULL,
    DB_LOCK_VER_NBR         INTEGER DEFAULT 0 NOT NULL,
    CONSTRAINT KCB_MSG_DELIVS_PK PRIMARY KEY (ID)
)
/
CREATE TABLE KCB_RECIP_DELIVS
(
    ID                  NUMBER(8) NOT NULL,
    RECIPIENT_ID        VARCHAR2(300) NOT NULL,
    CHANNEL             VARCHAR2(300) NOT NULL,
    DELIVERER_NAME      VARCHAR2(300) NOT NULL,
    DB_LOCK_VER_NBR     INTEGER DEFAULT 0 NOT NULL,
    CONSTRAINT KCB_RECIP_DELIVS_PK PRIMARY KEY (ID)
)
/
CREATE TABLE KCB_RECIP_PREFS
(
    ID                  NUMBER(8) NOT NULL,
    RECIPIENT_ID        VARCHAR2(300) NOT NULL,
    PROPERTY            VARCHAR2(300) NOT NULL,
    VALUE               VARCHAR2(1000) NOT NULL,
    DB_LOCK_VER_NBR     INTEGER DEFAULT 0 NOT NULL,
    CONSTRAINT KCB_RECIP_PREFS_PK PRIMARY KEY (ID)
)
/
ALTER TABLE KCB_MESSAGES
ADD CONSTRAINT KCB_MESSAGES_UK1 UNIQUE
(
ORIGIN_ID
)
 ENABLE
/
ALTER TABLE KCB_MSG_DELIVS
ADD CONSTRAINT KCB_MSG_DELIVS_UK1 UNIQUE
(
MESSAGE_ID,
DELIVERER_TYPE_NAME
)
 ENABLE
/

ALTER TABLE KCB_MSG_DELIVS
ADD CONSTRAINT KCB_MSG_DELIVS_FK1 FOREIGN KEY
(
MESSAGE_ID
)
REFERENCES KCB_MESSAGES
(
ID
) ENABLE
/
ALTER TABLE KCB_RECIP_DELIVS
ADD CONSTRAINT KCB_RECIP_DELIVS_UK1 UNIQUE
(
    RECIPIENT_ID,
    CHANNEL,
    DELIVERER_NAME
)
 ENABLE
/
ALTER TABLE KCB_RECIP_PREFS
ADD CONSTRAINT KCB_RECIP_PREFS_UK1 UNIQUE
(
    RECIPIENT_ID,
    PROPERTY
)
 ENABLE
/

alter table KCB_MSG_DELIVS add PROCESS_COUNT NUMBER(4) DEFAULT 0 NOT NULL /