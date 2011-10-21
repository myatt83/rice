-- KULRICE-5348
ALTER TABLE KREW_RULE_T RENAME COLUMN PREV_RULE_VER_NBR TO PREV_VER_RULE_ID
/
-- KULRICE-4589
UPDATE KRCR_PARM_T
SET PARM_NM='NOTIFY_GROUPS',
    PARM_DESC_TXT='Defines a group name (in the format "namespace:name") which contains members who should never receive "notifications" action requests from KEW.',
    EVAL_OPRTR_CD='D'
WHERE NMSPC_CD = 'KR-WKFLW'
  AND CMPNT_CD = 'Notification'
  AND PARM_NM = 'NOTIFY_EXCLUDED_USERS_IND'
/

