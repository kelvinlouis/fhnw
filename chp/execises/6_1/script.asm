;----------------------------------------
;   SKRIPT 6
;----------------------------------------

;   Exercise P7
    MOV AL, 07
    SUB AL, 01      ; Subtrahieren 07-01 = 06
    MOV BL, 02      ; 02 in BL
    MUL BL, AL      ; Multiplizieren 06 * 02 = OC
    DIV AL, 03      ; 12/3 = 4
    ;DIV BL, 00 ------> triggers execution error
    
    MOV AL, BL      ; BL ins AL schreiben
    MOV [00], BL    ; BL an Stelle 00 in RAM schreiben

;   Exercise P8
    MOV AL, 02
    MOV BL, 04
    AND AL, BL
    
    END
