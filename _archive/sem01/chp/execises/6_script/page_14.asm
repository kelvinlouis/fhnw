;----------------------------------------
;   SKRIPT 6
;----------------------------------------

;   Page 14
Main:
Init:
    MOV AL,01
    MOV CL,05

Loop:
    SHL AL

    DEC CL
    JNZ Loop

    END