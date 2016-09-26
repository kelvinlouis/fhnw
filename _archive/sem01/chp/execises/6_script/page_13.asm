;----------------------------------------
;   SKRIPT 6
;----------------------------------------

;   Page 13
Start:
    JMP Main
    
    ORG 20
Main:
Init:
    MOV AL,AA
    MOV BL,BB

Forever:
    INC AL
    DEC BL
    JMP Forever

    END