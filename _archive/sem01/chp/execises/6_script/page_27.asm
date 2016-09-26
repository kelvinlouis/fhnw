Start:
    MOV     AL,03
    MOV     BL,08
    CALL    30          ; STACK BF 08 (TOS), BE (SP)
    CMP     CL,10
    HALT

    ORG     30
;   
;   param1 AL
;   param2 BL
;   return CL
;
Multiply:
    PUSH    AL          ; STACK BF 08, BE 03 (TOS), BD (SP)
    MUL     AL,BL

    CALL    40          ; STACK BF 08, BE 03, BD 37 (TOS), BC (SP) 
    POP     AL          ; STACK BF 08 (TOS), BE 03 (SP), BD 37
    RET                 ; STACK BF 08 (SP), BE 03, BD 37

    ORG     40
;
;   param1  AL
;   param2  BL
;   return  CL
;
Sub:
    MOV     CL,AL
    SUB     CL,BL
    RET                 ; STACK BF 08, BE 03 (TOS), BD 37 (SP)

    END