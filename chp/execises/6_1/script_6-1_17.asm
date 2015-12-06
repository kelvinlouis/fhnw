;----------------------------------------
;   SKRIPT 6
;----------------------------------------

;   Exercise Page 17
Rest:
    MOV AL,00
    OUT 00
RG:
    MOV AL,82
    OUT 00
RY:
    MOV AL,84
    OUT 00
RR:
    MOV AL,88
    OUT 00
RYR:
    MOV AL,C8
    OUT 00
GR:
    MOV AL,28
    OUT 00
YR:
    MOV AL,48
    OUT 00    
RR2:
    MOV AL,88
    OUT 00
RRY:
    MOV AL,8C
    OUT 00

    JMP RG

END