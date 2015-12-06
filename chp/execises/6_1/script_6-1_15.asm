;----------------------------------------
;   SKRIPT 6
;----------------------------------------

;   Exercise Page 15
Main:
    JMP Part4

;
;   Part 1
;
Part1:
    MOV AL,0A

Loop1:
    DEC AL
    JNZ Loop1

;
;   Part 2
;
Part2:
    MOV AL,00

Loop2:
    INC AL
    CMP AL,0A
    JNZ Loop2

;
;   Part 3  (Faculties)
;
Part3:
    MOV AL,05   ; n
    MOV BL,01   ; Result

Loop3:
    MUL BL,AL
    DEC AL

    CMP AL,01
    JNZ Loop3

;
;   Part 4  (Fibonacci)
;
Part4:
    MOV AL,00   ; Summand 1
    MOV BL,01   ; Summand 2
    MOV CL,01   ; Result
    MOV DL,70   ; RAM

Loop4:    
    MOV [DL],CL
    
    MOV AL,BL
    MOV BL,CL   

    INC DL      ; RAM Address +1

    MOV CL,AL   ; Clear
    ADD CL,BL   ; CL = AL + BL
    
    JNO Loop4

    END
    