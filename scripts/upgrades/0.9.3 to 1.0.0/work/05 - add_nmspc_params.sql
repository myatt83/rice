INSERT INTO KRNS_NMSPC_T(NMSPC_CD, OBJ_ID, VER_NBR, NM, ACTV_IND) VALUES('KR-IDM', sys_guid(), 1, 'Identity Management', 'Y')
/
INSERT INTO KRNS_PARM_T(NMSPC_CD, PARM_DTL_TYP_CD, PARM_NM, OBJ_ID, VER_NBR, PARM_TYP_CD, TXT, PARM_DESC_TXT, CONS_CD, GRP_NM)  VALUES('KR-IDM', 'EntityNameImpl', 'PREFIXES', sys_guid(), 1, 'CONFG',  'Ms;Mrs;Mr;Dr', '','A', 'WorkflowAdmin')
/
INSERT INTO KRNS_PARM_T(NMSPC_CD, PARM_DTL_TYP_CD, PARM_NM, OBJ_ID, VER_NBR, PARM_TYP_CD, TXT, PARM_DESC_TXT, CONS_CD, GRP_NM)  VALUES('KR-IDM', 'EntityNameImpl', 'SUFFIXES', sys_guid(), 1, 'CONFG', 'Jr;Sr;Mr;Md', '','A', 'WorkflowAdmin')
/