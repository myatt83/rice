ALTER TABLE ROLES_USERS_T
ADD CONSTRAINT ROLES_USERS_FK1 FOREIGN KEY
(
ROLE_ID
)
REFERENCES ROLES_T
(
ID
) ENABLE
/
ALTER TABLE ROLES_USERS_T
ADD CONSTRAINT ROLES_USERS_FK2 FOREIGN KEY
(
USER_ID
)
REFERENCES USERS_T
(
ID
) ENABLE
/