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

;   Exercise P8 (De Morgansche)
;   1)
    MOV AL,08       ; A
    MOV BL,02       ; B
    AND AL,BL       ; AB
    
    MOV CL,08       ; A
    MOV DL,02       ;B
    NOT CL          ; ~A
    NOT DL          ; ~B
    OR  CL,DL       ; ~A + ~B
    NOT CL          ; ~(~A + ~B)
    ; AL = CL

;   2)
    MOV AL,03       ; A = 3
    MOV BL,05       ; B = 5
    MOV CL,06       ; C = 6
    OR  BL,CL       ; B + C
    AND AL,BL       ; A (B+C)
    
    MOV BL,03       ; A = 3
    MOV CL,05       ; B = 5
    MOV DL,06       ; C = 6
    AND DL,BL       ; AC
    AND BL,CL       ; AB
    OR  BL,DL       ; (AB) + (AC)
    ; AL = BL

    MOV AL,06       ; A = 6
    MOV BL,03       ; B = 3
    MOV CL,07       ; C = 7
    AND BL,CL       ; BC
    OR  AL,BL       ; A + (BC)

    MOV BL,06       ; A = 6
    MOV CL,03       ; B = 3
    MOV DL,07       ; C = 7
    OR  DL,BL       ; A+C
    OR  BL,CL       ; A+B
    AND BL,DL       ; (A+B) (A+C)
    ; AL = BL
    END
