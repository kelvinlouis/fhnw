;
;   Exercises 6.1
;

; 9  
    MOV     AL,80   ; Primes Pointer
    MOV     BL,70   ; Array Pointer
    MOV     CL,03   ; Rows
    MOV     DL,04   ; Cols
    MUL     CL,DL   ; Cells
    
    CMP     CL,00
    JZ      Done

    ADD     AL,CL
    ADD     BL,CL
Loop:
    DEC     AL
    DEC     BL
    
    MOV     DL,[AL]
    MOV     [BL],DL
    
    DEC     CL
    CMP     CL,00
    JNZ     Loop

Done:
    HALT

Primes:
    ORG     80
    DB      01
    DB      02
    DB      03
    DB      05
    DB      07
    DB      0B
    DB      0D
    DB      11
    DB      13
    DB      17
    DB      1D
    DB      1F

    END  